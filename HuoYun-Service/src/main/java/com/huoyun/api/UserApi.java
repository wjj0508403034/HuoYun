package com.huoyun.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huoyun.core.locale.LocaleService;
import com.huoyun.core.user.UserService;
import com.huoyun.core.user.dto.InviteRegisterForm;
import com.huoyun.core.user.dto.Login;
import com.huoyun.core.user.dto.RegisterUser;
import com.huoyun.core.user.dto.ResetPassword;
import com.huoyun.core.user.dto.ResetPasswordFormByEmail;
import com.huoyun.exception.BusinessException;

@RestController
@RequestMapping("/api/user")
public class UserApi {

	@Autowired
	private UserService userService;

	@Autowired
	private LocaleService localeService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/*
	 * 用户注册
	 */
	@RequestMapping(path = "register", method = RequestMethod.POST)
	public @ResponseBody void register(@RequestBody RegisterUser registerUser)
			throws BusinessException {
		registerUser.onValid(localeService);
		this.userService.create(registerUser.parse(passwordEncoder));
	}

	/*
	 * 用户登录
	 */
	@RequestMapping(path = "login", method = RequestMethod.POST)
	public @ResponseBody void login(@RequestBody Login login)
			throws BusinessException {
		this.userService.login(login.getEmail(), login.getPassword());
	}

	/*
	 * 用户登出
	 */
	@RequestMapping(path = "logout", method = RequestMethod.POST)
	public @ResponseBody void logout() throws Exception {
		this.userService.logout();
	}

	/*
	 * 用户重置密码
	 */
	@RequestMapping(path = "resetpassword", method = RequestMethod.POST)
	public @ResponseBody void resetPassword(
			@RequestBody ResetPassword resetPassword) throws BusinessException {
		resetPassword.onValid(localeService);
		this.userService.resetPassword(resetPassword.getOrgianlPassword(),
				resetPassword.getPassword());
	}

	/*
	 * 找回密码
	 */
	@RequestMapping(path = "forgotPassword", method = RequestMethod.POST)
	public @ResponseBody void forgotPassword(@RequestBody String email)
			throws BusinessException {
		this.userService.forgotPassword(email);
	}

	/*
	 * 通过邮件重置密码
	 */
	@RequestMapping(path = "resetPasswordByEmail", method = RequestMethod.POST)
	public @ResponseBody void resetPassword(
			@RequestBody ResetPasswordFormByEmail form) {

	}

	/*
	 * 邀请用户注册 -- 邀请人邮箱
	 */
	@RequestMapping(path = "invite", method = RequestMethod.POST)
	public @ResponseBody void inviteRegister(@RequestBody String email)
			throws BusinessException {
		this.userService.inviteRegister(email);
	}

	/*
	 * 用户通过邀请码注册
	 */
	@RequestMapping(path = "registerByCode", method = RequestMethod.POST)
	public @ResponseBody void registerByCode(
			@RequestBody InviteRegisterForm registerForm)
			throws BusinessException {
		registerForm.onValid(localeService);
		this.userService.register(registerForm);
	}

	/*
	 * 重新发送邀请注册
	 */
	@RequestMapping(path = "reinvite", method = RequestMethod.POST)
	public @ResponseBody void reinviteRegister(@PathVariable Long id)
			throws BusinessException {
		this.userService.reinviteRegister(id);
	}
}
