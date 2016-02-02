package com.huoyun.business.leave;

import com.huoyun.business.leave.entity.LeaveApprover;
import com.huoyun.business.leave.entity.LeaveRecord;

public interface MailService {

	/*
	 * 发送请假邮件给审批人
	 */
	void sendLeaveRequest(LeaveRecord leaveRecord);

	/*
	 * 发送审批结果邮件给申请人
	 */
	void sendApproveResult(LeaveRecord leaveRecord);
	
	/*
	 * 发送审批人设置成功邮件给申请人
	 */
	void sendSetApproverSuccess(LeaveApprover leaveApprover);
}
