package com.huoyun.core.user.impl;

import java.time.LocalDate;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.huoyun.api.user.model.SmsValidateCode;
import com.huoyun.core.common.BoService;
import com.huoyun.core.common.session.SessionUtils;
import com.huoyun.core.employee.EmployeeService;
import com.huoyun.core.extension.endpoint.UserEventListenerForEmployee;
import com.huoyun.core.locale.LocaleService;
import com.huoyun.core.user.ErrorCode;
import com.huoyun.core.user.MailService;
import com.huoyun.core.user.UserInfo;
import com.huoyun.core.user.UserService;
import com.huoyun.core.user.dto.InviteRegisterForm;
import com.huoyun.core.user.dto.ResetPasswordFormByEmail;
import com.huoyun.core.user.entity.InviteRecord;
import com.huoyun.core.user.entity.ResetPasswordRecord;
import com.huoyun.core.user.entity.Role;
import com.huoyun.core.user.entity.User;
import com.huoyun.core.user.repository.InviteRecordRepository;
import com.huoyun.core.user.repository.ResetPasswordRecordRepository;
import com.huoyun.core.user.repository.RoleRepository;
import com.huoyun.core.user.repository.UserRepository;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.BusinessObjectNotFoundException;
import com.huoyun.exception.LocalableBusinessException;
import com.huoyun.exception.NotAdminException;

@Service
public class UserServiceImpl extends BoService implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserEventListenerForEmployee userEventListenerForEmployee;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private InviteRecordRepository inviteRecordRepository;

	@Autowired
	private ResetPasswordRecordRepository resetPasswordRecordRepository;

	@Autowired
	private LocaleService localeService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private MailService mailService;

	@Autowired
	private HttpSession httpSession;

	@PostConstruct
	public void init() {
		this.register(userEventListenerForEmployee);
	}

	@Override
	public void login(String email, String password) throws BusinessException {
		User user = this.userRepository.findByEmail(email);
		this.login(user, password);
	}

	@Override
	public void loginByEmailOrPhone(String account, String password)
			throws BusinessException {
		User user = this.userRepository.findByEmailOrPhone(account, account);
		this.login(user, password);
	}

	@Override
	public void logout() throws BusinessException {
		if (!this.isLogin()) {
			throw new BusinessException(ErrorCode.Logout_Failed_With_No_User,
					localeService);
		}
		SecurityContextHolder.getContext().setAuthentication(null);
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User create(User user) {
		Role admin = this.roleRepository.findAdminRole();
		user.setRole(admin);
		User result = this.userRepository.save(user);
		super.postCreate(result);
		this.mailService.sendRegisterSuccessMail(user);
		return result;
	}

	@Override
	public UserInfo getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null && auth.getPrincipal().getClass() == UserInfo.class) {
			return (UserInfo) auth.getPrincipal();
		}
		return null;
	}

	@Override
	public boolean isLogin() {
		return this.getCurrentUser() != null;
	}

	@Override
	public void resetPassword(String orgianlPassword, String newPassword)
			throws BusinessException {
		User user = this.getCurrentUser().getUser();
		String userPassword = user.getPassword();
		if (!passwordEncoder.matches(orgianlPassword, userPassword)) {
			throw new LocalableBusinessException(
					ErrorCode.ResetPassword_Failed_With_Invalid_Password,
					localeService, "orgianlPassword");
		}

		this.resetPassword(user, newPassword);
	}

	@Override
	public void setAdmin(User user) {
		Role admin = this.roleRepository.findAdminRole();
		user.setRole(admin);
		this.userRepository.save(user);
	}

	@Override
	public void inviteRegister(String email) throws BusinessException {

		/*
		 * 只有管理员才能邀请用户注册
		 */
		User currentUser = this.getCurrentUser().getUser();
		if (currentUser.getRole().getCode() != "ADMIN") {
			throw new NotAdminException(this.localeService);
		}

		/*
		 * 检查邮箱是否被注册
		 */
		User user = this.findByEmail(email);
		if (user != null) {
			throw new BusinessException(ErrorCode.Register_Email_Exist,
					this.localeService);
		}

		/*
		 * 检查邮箱是否已被邀请
		 */
		InviteRecord record = this.inviteRecordRepository.findByEmail(email);
		if (record != null) {
			throw new BusinessException(
					ErrorCode.Register_Email_Already_Invited,
					this.localeService);
		}

		/*
		 * 生成邀请记录
		 */
		LocalDate now = LocalDate.now();
		record = new InviteRecord();
		record.setEmail(email);
		record.setInviteCode(UUID.randomUUID().toString());
		record.setInviter(currentUser);
		record.setInvitationTime(now);
		record.setExpirationTime(now.plusDays(1));
		this.inviteRecordRepository.save(record);

		/*
		 * 发送邀请邮件
		 */
		this.mailService.sendInviteRegisterMail(record);
	}

	@Override
	public void register(InviteRegisterForm registerForm)
			throws BusinessException {
		/*
		 * 检查邮箱是否被注册
		 */
		User checkUser = this.findByEmail(registerForm.getEmail());
		if (checkUser != null) {
			throw new LocalableBusinessException(
					ErrorCode.Register_Email_Exist, this.localeService, "email");
		}

		/*
		 * 检查邮箱是否被邀请
		 */
		InviteRecord record = this.inviteRecordRepository
				.findByEmail(registerForm.getEmail());
		if (record == null) {
			throw new LocalableBusinessException(
					ErrorCode.Register_Failed_Email_No_Invite,
					this.localeService, "email");
		}

		/*
		 * 注册邀请码不匹配
		 */
		if (!StringUtils.equals(record.getInviteCode(), registerForm.getCode())) {
			throw new LocalableBusinessException(
					ErrorCode.Register_Failed_Invite_Code_Error,
					this.localeService, "code");
		}

		/*
		 * 邀请码过期
		 */
		if (record.getExpirationTime().isBefore(LocalDate.now())) {
			throw new LocalableBusinessException(
					ErrorCode.Register_Failed_Invite_Code_Expired,
					this.localeService, "code");
		}

		/*
		 * 创建用户
		 */
		User user = new User();
		user.setEmail(registerForm.getEmail());
		user.setPassword(registerForm.getPassword());
		this.create(user);

		/*
		 * 设置用户完成注册状态
		 */
		record.setFinishRegister(true);
		this.inviteRecordRepository.save(record);
	}

	@Override
	public void reinviteRegister(Long id) throws BusinessException {
		InviteRecord record = this.inviteRecordRepository.findOne(id);

		/*
		 * 邀请记录不存在
		 */
		if (record == null) {
			throw new BusinessObjectNotFoundException(InviteRecord.class, id,
					this.localeService);
		}

		/*
		 * 用户已经完成注册
		 */
		if (record.isFinishRegister()) {
			throw new BusinessException(
					ErrorCode.Register_Reinvite_Failed_Due_To_User_Finished_Register,
					this.localeService);
		}

		/*
		 * 重新生成邀请码，并延长有效期
		 */
		record.setInviteCode(UUID.randomUUID().toString());
		record.setExpirationTime(LocalDate.now().plusDays(1));
		this.inviteRecordRepository.save(record);

		/*
		 * 发送邀请邮件
		 */
		this.mailService.sendInviteRegisterMail(record);
	}

	@Override
	public void forgotPassword(String email) throws BusinessException {
		/*
		 * 检查邮箱是否存在
		 */
		User checkUser = this.findByEmail(email);
		if (checkUser != null) {
			throw new BusinessException(ErrorCode.User_Not_Exist,
					this.localeService);
		}

		/*
		 * 生成重置密码记录
		 */
		LocalDate now = LocalDate.now();
		ResetPasswordRecord record = new ResetPasswordRecord();
		record.setCode(UUID.randomUUID().toString());
		record.setCreateTime(now);
		record.setExpirationTime(now.plusDays(1));
		record.setEmail(email);
		this.resetPasswordRecordRepository.save(record);

		/*
		 * 发送重置密码邮件
		 */
		this.mailService.sendResetPasswordMail(record);
	}

	@Override
	public void resetPassword(ResetPasswordFormByEmail form)
			throws BusinessException {
		ResetPasswordRecord record = this.resetPasswordRecordRepository
				.findByCode(form.getCode());

		/*
		 * 重置密码记录不能为空
		 */
		if (record == null) {
			throw new BusinessException(
					ErrorCode.ResetPassword_Failed_With_No_Record,
					this.localeService);
		}

		/*
		 * 重置的email与记录里的email比对
		 */
		if (!StringUtils.equalsIgnoreCase(form.getEmail(), record.getEmail())) {
			throw new BusinessException(
					ErrorCode.ResetPassword_Failed_With_Code_Error,
					this.localeService);
		}

		/*
		 * 重置密码请求已经过期
		 */
		if (record.getExpirationTime().isBefore(LocalDate.now())) {
			throw new BusinessException(
					ErrorCode.ResetPassword_Failed_With_Code_Expired,
					this.localeService);
		}

		User user = this.findByEmail(record.getEmail());
		/*
		 * 用户不存在
		 */
		if (user == null) {
			throw new BusinessException(ErrorCode.User_Not_Exist,
					this.localeService);
		}

		/*
		 * 修改密码
		 */
		this.resetPassword(user, form.getPassword());

		/*
		 * 发送密码修改成功邮件
		 */
		this.mailService.sendResetPasswordSuccessMail(user);

		/*
		 * 设置用户修改密码状态
		 */
		record.setFinish(true);
		this.resetPasswordRecordRepository.save(record);
	}

	private void resetPassword(User user, String newPassword)
			throws LocalableBusinessException {
		String oldPassword = user.getPassword();

		if (StringUtils.equals(oldPassword, newPassword)) {
			throw new LocalableBusinessException(
					ErrorCode.ResetPassword_Failed_With_Same_Password,
					localeService, "password");
		}

		user.setPassword(passwordEncoder.encode(newPassword));
		this.userRepository.save(user);
	}

	@Override
	public void registerByEmail(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		user.setFirstLogin(true);
		this.create(user);
	}

	private void login(User user, String password) throws BusinessException {
		if (user != null) {
			if (passwordEncoder.matches(password, user.getPassword())) {
				UserInfo userInfo = new UserInfo(user);
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
						userInfo, null, userInfo.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(token);
				logger.info("login success.");
				return;
			}
		}

		SecurityContextHolder.getContext().setAuthentication(null);
		throw new BusinessException(ErrorCode.Login_Failed, localeService);
	}

	@Override
	public User findByEmailOrPhone(String account) {
		return this.userRepository.findByEmailOrPhone(account, account);
	}

	@Override
	public void registerByPhone(String phone, String password, String code)
			throws BusinessException {
		// 手机格式检查

		// 手机是否被注册检查

		// 注册验证码检查是否有效
		SmsValidateCode smsValidateCode = (SmsValidateCode) httpSession
				.getAttribute(SessionUtils.Names_Register_SMS_Validator_Code);
		if (smsValidateCode == null
				|| smsValidateCode.getExpireDate().isBefore(LocalDate.now())) {
			throw new BusinessException(ErrorCode.Login_Failed, localeService);
		}
		
		// 创建用户

	}
}
