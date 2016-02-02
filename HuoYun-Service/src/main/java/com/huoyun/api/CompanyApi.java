package com.huoyun.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huoyun.core.company.CompanyService;
import com.huoyun.core.company.dto.CompanyDTO;
import com.huoyun.core.company.dto.DepartmentDTO;
import com.huoyun.core.company.dto.WorkDayDTO;
import com.huoyun.core.company.dto.WorkHoursDTO;
import com.huoyun.core.company.entity.Company;
import com.huoyun.core.company.entity.Department;
import com.huoyun.core.company.settings.GeneralSettingService;
import com.huoyun.core.company.settings.entity.WorkDay;
import com.huoyun.core.company.settings.entity.WorkHours;
import com.huoyun.exception.BusinessException;

@Controller
@RequestMapping("/api")
public class CompanyApi extends Api {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private GeneralSettingService generalSettingService;

	@RequestMapping(path = "company", method = RequestMethod.GET)
	public @ResponseBody CompanyDTO get() throws BusinessException {
		Company company = this.companyService.get();
		CompanyDTO dto = mapper.map(company, CompanyDTO.class);
		return dto;
	}

	@RequestMapping(value = "/company/upload", method = RequestMethod.POST)
	public void uploadLogo(@RequestParam("file") MultipartFile file)
			throws BusinessException {
		this.companyService.uploadLogo(file);
	}

	@RequestMapping(path = "company", method = RequestMethod.PUT)
	public @ResponseBody void update(@RequestBody CompanyDTO companyDTO)
			throws BusinessException {
		this.companyService.save(mapper.map(companyDTO, Company.class));
	}

	@RequestMapping(path = "company/setting/workhours", method = RequestMethod.PUT)
	public @ResponseBody void setWorkHours(
			@RequestBody WorkHoursDTO workHoursDTO) throws BusinessException {
		this.generalSettingService.setWorkHour(this.mapper.map(workHoursDTO,
				WorkHours.class));
	}

	@RequestMapping(path = "company/setting/workday", method = RequestMethod.PUT)
	public @ResponseBody void setWorkDay(@RequestBody WorkDayDTO workDayDTO)
			throws BusinessException {
		this.generalSettingService.setWorkDay(this.mapper.map(workDayDTO,
				WorkDay.class));
	}

	@RequestMapping(path = "department", method = RequestMethod.POST)
	public @ResponseBody void createDepartment(
			@RequestBody DepartmentDTO departmentDTO) throws BusinessException {
		this.companyService.createDepartment(this.mapper.map(departmentDTO,
				Department.class));
	}

	@RequestMapping(path = "departments", method = RequestMethod.GET)
	public @ResponseBody List<DepartmentDTO> getDepartments() {
		return this.listMapper.map(this.companyService.getDepartments(),
				DepartmentDTO.class);
	}
}
