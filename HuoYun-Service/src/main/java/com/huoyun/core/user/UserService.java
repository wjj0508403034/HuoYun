package com.huoyun.core.user;

import com.huoyun.core.user.dto.InviteRegisterForm;
import com.huoyun.core.user.dto.ResetPasswordFormByEmail;
import com.huoyun.core.user.entity.User;
import com.huoyun.exception.BusinessException;

public interface UserService {

	void login(String email, String password) throws BusinessException;

	void loginByEmailOrPhone(String account, String password)
			throws BusinessException;

	void logout() throws BusinessException;

	void resetPassword(String orgianlPassword, String newPassword)
			throws BusinessException;

	void resetPassword(ResetPasswordFormByEmail form) throws BusinessException;

	void forgotPassword(String email) throws BusinessException;

	User findByEmail(String email);
	
	User findByPhone(String phone);
	
	User findByEmailOrPhone(String account);

	User create(User user);

	UserInfo getCurrentUser();

	boolean isLogin();

	void setAdmin(User user);

	void inviteRegister(String email) throws BusinessException;

	void register(InviteRegisterForm registerForm) throws BusinessException;

	void reinviteRegister(Long id) throws BusinessException;

	void registerByEmail(String email, String password,String repeatPassword) throws BusinessException;
	
	void registerByPhone(String phone,String password,String code) throws BusinessException;
}
