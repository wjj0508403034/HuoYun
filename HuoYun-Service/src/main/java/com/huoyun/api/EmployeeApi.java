package com.huoyun.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huoyun.core.employee.EmployeeService;
import com.huoyun.core.employee.dto.EmployeeDTO;
import com.huoyun.core.employee.entity.Employee;
import com.huoyun.core.locale.LocaleService;
import com.huoyun.core.tools.EntityToDtoConverter;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.BusinessObjectNotFoundException;

@RestController
@RequestMapping("/api")
public class EmployeeApi extends Api {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private LocaleService localeService;

	@RequestMapping(path = "/employee({id})", method = RequestMethod.GET)
	public @ResponseBody EmployeeDTO get(@PathVariable Long id) {
		return mapper.map(this.employeeService.get(id), EmployeeDTO.class);
	}

	@RequestMapping(path = "/employee({id})", method = RequestMethod.PATCH)
	public @ResponseBody void update(@PathVariable Long id,
			@RequestBody Map<String, Object> map) throws BusinessException {

		Employee employee = this.employeeService.get(id);
		if (employee == null) {
			throw new BusinessObjectNotFoundException(Employee.class, id,
					localeService);
		}

		this.copy(map, EmployeeDTO.class, employee);
		this.employeeService.update(employee);
	}

	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public @ResponseBody Page<EmployeeDTO> query(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			Sort sort) {
		PageRequest request = new PageRequest(page, size, sort);
		Page<Employee> pageData = this.employeeService.query(request);
		EntityToDtoConverter<Employee, EmployeeDTO> converter = new EntityToDtoConverter<Employee, EmployeeDTO>(
				mapper, EmployeeDTO.class);
		return pageData.map(converter);
	}

	@RequestMapping(path = "/employee/my", method = RequestMethod.GET)
	public @ResponseBody EmployeeDTO getCurrentEmployee()
			throws BusinessException {
		return mapper.map(this.employeeService.currentEmployee(),
				EmployeeDTO.class);
	}
}
