package com.huoyun.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huoyun.core.user.UserInfo;
import com.huoyun.core.user.UserService;
import com.huoyun.core.user.entity.User;

@Service
public class UserDetailsService implements
		org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		User user = this.userService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format(
					"User with email=%s was not found", email));
		}

		return new UserInfo(user);
	}

}
