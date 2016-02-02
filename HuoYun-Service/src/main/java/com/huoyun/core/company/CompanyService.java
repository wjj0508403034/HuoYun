package com.huoyun.core.company;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.huoyun.core.company.entity.Company;
import com.huoyun.core.company.entity.Department;
import com.huoyun.exception.BusinessException;

public interface CompanyService {

	Company get() throws BusinessException;

	void uploadLogo(MultipartFile file) throws BusinessException;

	void save(Company company) throws BusinessException;
	
	void createDepartment(Department department) throws BusinessException;
	
	List<Department> getDepartments();
}
