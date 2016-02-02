package com.huoyun.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.huoyun.security.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();

		httpSecurity.authorizeRequests().antMatchers("/**","/assets/**").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/api/user/register").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/api/user/login").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/login.html").permitAll();

		httpSecurity.authorizeRequests().anyRequest().authenticated().and()
				.formLogin().loginPage("/login.html")
				.loginProcessingUrl("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.failureUrl("/login.html?error")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
				.logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
