package com.huoyun.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huoyun.api.models.leaves.SetApproverModel;
import com.huoyun.business.leave.ApproveService;
import com.huoyun.core.employee.dto.EmployeeDTO;
import com.huoyun.exception.BusinessException;

@RestController
@RequestMapping("/api/approve")
public class LeaveApproveApi extends Api {

	@Autowired
	private ApproveService approveService;

	/*
	 * 获取当前用户的审批人
	 */
	@RequestMapping(path = "/getApprover", method = RequestMethod.GET)
	public @ResponseBody EmployeeDTO getApprover() throws BusinessException {
		return this.mapper.map(this.approveService.getApprover(),
				EmployeeDTO.class);
	}

	/*
	 * 设置审批人
	 */
	@RequestMapping(path = "/setApprover", method = RequestMethod.POST)
	public @ResponseBody void setApprover(@RequestBody SetApproverModel model)
			throws BusinessException {
		this.approveService.setApprover(model.getEmployeeId(),
				model.getApproverId());
	}
}
