package com.huoyun.business.leave.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.huoyun.business.leave.AdminService;
import com.huoyun.business.leave.entity.LeaveType;
import com.huoyun.business.leave.repository.EmployeeLeaveRepository;
import com.huoyun.core.common.BoService;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.NotAdminException;

public class AdminServiceImpl extends BoService implements AdminService{

	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;
	
	@Override
	public void createLeaveType(LeaveType leaveType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLeaveType(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMarriageLeave(Long id, boolean lateMarried, int days,
			int lateMarriedDays) throws BusinessException {
		if (!this.boFacade.isAdmin()) {
			throw new NotAdminException(this.localeService);
		}
		
	}

}
