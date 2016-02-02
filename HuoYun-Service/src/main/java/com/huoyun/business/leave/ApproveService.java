package com.huoyun.business.leave;

import com.huoyun.core.employee.entity.Employee;
import com.huoyun.exception.BusinessException;

public interface ApproveService {

	/*
	 * 审批同意 -请假记录的id
	 */
	void approve(Long id) throws BusinessException;

	/*
	 * 审批拒绝 -请假记录的id
	 */
	void reject(Long id) throws BusinessException;

	/*
	 * 设置请假审批人-被审批人id,审批人id
	 */
	void setApprover(Long employeeId, Long approverId) throws BusinessException;

	/*
	 * 获取当前用户的审批人
	 */
	Employee getApprover() throws BusinessException;
}
