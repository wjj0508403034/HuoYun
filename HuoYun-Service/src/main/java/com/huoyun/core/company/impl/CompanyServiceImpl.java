package com.huoyun.core.company.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.huoyun.core.company.CompanyService;
import com.huoyun.core.company.ErrorCode;
import com.huoyun.core.company.entity.Company;
import com.huoyun.core.company.entity.Department;
import com.huoyun.core.company.repository.CompanyRepository;
import com.huoyun.core.company.repository.DepartmentRepository;
import com.huoyun.core.locale.LocaleService;
import com.huoyun.exception.BusinessException;
import com.huoyun.upload.UploadService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private LocaleService localeService;

	@Autowired
	private UploadService uploadService;

	@Override
	public Company get() throws BusinessException {
		List<Company> companies = (List<Company>) Lists
				.newArrayList(this.companyRepository.findAll());
		if (companies.size() != 0) {
			return companies.get(0);
		}

		throw new BusinessException(ErrorCode.Company_No_Data, localeService);
	}

	@Override
	public void uploadLogo(MultipartFile file) throws BusinessException {
		long id = uploadService.upload(file);
		Company company = this.get();
		company.setLogo(id);
		this.companyRepository.save(company);
	}

	@Override
	public void save(Company company) throws BusinessException {
		Company oldEntity = this.get();
		company.setLogo(oldEntity.getLogo());
		company.setId(oldEntity.getId());
		this.companyRepository.save(company);
	}

	@Override
	public void createDepartment(Department department)
			throws BusinessException {
		Department find = this.departmentRepository.findByCode(department
				.getCode());
		if (find != null) {
			throw new BusinessException(ErrorCode.Department_Code_Exist,
					localeService);
		}

		this.departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartments() {
		return (List<Department>) Lists.newArrayList(this.departmentRepository
				.findAll());
	}
}
