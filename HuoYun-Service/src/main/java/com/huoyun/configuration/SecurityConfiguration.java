package com.huoyun.configuration;

import java.net.Authenticator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.huoyun.core.common.web.ProxyAuth;
import com.huoyun.core.common.web.ProxyProperties;
import com.huoyun.security.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private ProxyProperties proxyProperties;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		this.setSystemProxy();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();

		httpSecurity.authorizeRequests()
				.antMatchers("/css/**", "/imgs/**", "/libs/**").permitAll();

		httpSecurity.authorizeRequests()
				.antMatchers("/login.html", "/register.html").permitAll();
		httpSecurity.authorizeRequests()
				.antMatchers("/register", "/registerByPhone").permitAll();

		/************************************************************
		 * API
		 ************************************************************/
		httpSecurity
				.authorizeRequests()
				.antMatchers("/api/user/login", "/api/user/register",
						"/api/user/registerByPhone",
						"/api/user/sendRegisterSmsCode",
						"/api/user/checkEmailExist",
						"/api/user/checkPhoneExist").permitAll();

		httpSecurity.authorizeRequests().anyRequest().authenticated().and()
				.formLogin().loginPage("/login.html")
				.loginProcessingUrl("/login").usernameParameter("account")
				.passwordParameter("password").failureUrl("/login.html?error")
				.defaultSuccessUrl("/").permitAll().and().logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
				passwordEncoder);
	}

	private void setSystemProxy() {
		if (!StringUtils.isEmpty(proxyProperties.getHost())) {
			System.setProperty("http.proxyHost", proxyProperties.getHost());
			System.setProperty("https.proxyHost", proxyProperties.getHost());
			System.setProperty("http.proxyPort", proxyProperties.getPort());
			System.setProperty("https.proxyPort", proxyProperties.getPort());

			if (!StringUtils.isEmpty(proxyProperties.getUserName())
					&& !StringUtils.isEmpty(proxyProperties.getPassword())) {
				Authenticator.setDefault(new ProxyAuth(proxyProperties
						.getUserName(), proxyProperties.getPassword()));
			}
		}
	}
}
