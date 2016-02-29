package com.huoyun.core.user;

import org.springframework.security.core.authority.AuthorityUtils;

import com.huoyun.core.user.entity.User;

public class UserInfo extends
		org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = -8050466418909724802L;

	private User user;

	public UserInfo(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils
				.createAuthorityList(user.getRole().getCode()));
		this.user = user;
	}

	public Long getId() {
		return this.user.getId();
	}

	public String getEmail() {
		return this.user.getEmail();
	}

	public User getUser() {
		return this.user;
	}
}
