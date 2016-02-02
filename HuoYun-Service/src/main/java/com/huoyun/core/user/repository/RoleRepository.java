package com.huoyun.core.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.huoyun.core.user.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	@Query("select t0 from Role t0 where t0.code = 'ADMIN'")
	Role findAdminRole();
}
