package com.huoyun.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huoyun.controller.user.model.LoginForm;
import com.huoyun.controller.user.model.RegisterForm;
import com.huoyun.core.user.ErrorCode;
import com.huoyun.core.user.UserService;
import com.huoyun.exception.BusinessException;

@Controller
public class UserController {

	public static final String VIEW_NAME_LOGIN = "accounts/login";
	public static final String VIEW_NAME_REGISTER = "accounts/register";

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String loginPage(LoginForm loginForm) {
		return VIEW_NAME_LOGIN;
	}

	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public String registerPage(RegisterForm registerForm) {
		return VIEW_NAME_REGISTER;
	}

	@RequestMapping(value = "/forgetpassword.html", method = RequestMethod.GET)
	public String forgetpasswordPage() {
		return "accounts/forgetpassword";
	}

	@RequestMapping(value = "/resetpassword.html", method = RequestMethod.GET)
	public String resetpasswordPage() {
		return "accounts/resetpassword";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerByEmail(@Valid RegisterForm registerForm,
			BindingResult result) {
		registerForm.onValid(result);

		if (result.hasErrors()) {
			return VIEW_NAME_REGISTER;
		}

		try {
			this.userService.registerByEmail(registerForm.getEmail(),
					registerForm.getPassword());
		} catch (BusinessException ex) {
			registerForm.addError(result, ex.getCode());
			return VIEW_NAME_REGISTER;
		} catch (Exception ex) {
			registerForm.addError(result, ErrorCode.Register_Failed);
			return VIEW_NAME_REGISTER;
		}

		return "redirect:/login.html";
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid LoginForm loginForm, BindingResult result) {
		loginForm.onValid(result);
		if (result.hasErrors()) {
			return VIEW_NAME_LOGIN;
		}

		try {
			this.userService.loginByEmailOrPhone(loginForm.getAccount(),
					loginForm.getPassword());
		} catch (BusinessException ex) {
			loginForm.addError(result, ex.getCode());
			return VIEW_NAME_LOGIN;
		} catch (Exception ex) {
			loginForm.addError(result, ErrorCode.Login_Failed);
			return VIEW_NAME_LOGIN;
		}

		return "redirect:/";
	}*/
}
