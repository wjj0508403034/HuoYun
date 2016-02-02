package com.huoyun.core.company.repository;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.core.company.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>{

	Department findByCode(String code);
}
