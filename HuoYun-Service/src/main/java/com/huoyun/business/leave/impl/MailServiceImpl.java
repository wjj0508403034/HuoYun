package com.huoyun.business.leave.impl;

import org.springframework.stereotype.Service;

import com.huoyun.business.leave.MailService;
import com.huoyun.business.leave.entity.LeaveApprover;
import com.huoyun.business.leave.entity.LeaveRecord;

@Service(value = "LeaveMailService")
public class MailServiceImpl implements MailService {

	@Override
	public void sendLeaveRequest(LeaveRecord leaveRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendApproveResult(LeaveRecord leaveRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendSetApproverSuccess(LeaveApprover leaveApprover) {
		// TODO Auto-generated method stub

	}

}
