package com.huoyun.business.leave;

/*
 * 请假管理相关的ErrorCode，范围从21001~22000
 */
public class ErrorCode {

	public final static int EndDate_Before_StartDate = 21001;
	public final static int EndTime_Before_StartTime = 21002;
	public final static int LeaveDate_Is_Holiday = 21003;
	public final static int Leave_Total_Time_Equal_Zero = 21004;
	public final static int Leave_Exceed_Available_Days = 21005;
	public final static int Leave_Not_Allow_Corss_Year = 21006;
	public final static int Leave_Date_Range_Is_Conflict = 21007;
	public final static int Leave_Not_Allow_Cancel = 21008;
	public final static int Leave_Not_Allow_Cancel_By_Other = 21009;
	public final static int Employee_Not_Set_Approver = 21010;
	public final static int Leave_Not_Allow_Approver = 21011;
	public final static int Leave_Not_Allow_Reject = 21012;
	public final static int Leave_Incorrect_Approver = 21013;
}
