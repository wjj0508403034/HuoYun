package com.huoyun.core.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.core.user.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
	User findByPhone(String phone);
	
	User findByEmailOrPhone(String email,String phone);
}
