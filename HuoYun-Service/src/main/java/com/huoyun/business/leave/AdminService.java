package com.huoyun.business.leave;

import com.huoyun.business.leave.entity.LeaveType;
import com.huoyun.exception.BusinessException;

public interface AdminService {

	/*
	 * 创建一个新的请假类型
	 */
	void createLeaveType(LeaveType leaveType);

	/*
	 * 删除一个新的请假类型
	 */
	void deleteLeaveType(Long id);
	
	/*
	 * 为员工添加婚假-员工的Id，是否晚婚，婚假天数，晚婚婚假天数
	 */
	void setMarriageLeave(Long id,boolean lateMarried,int days,int lateMarriedDays) throws BusinessException;
}
