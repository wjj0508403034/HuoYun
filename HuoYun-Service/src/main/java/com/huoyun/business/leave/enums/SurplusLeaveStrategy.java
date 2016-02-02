package com.huoyun.business.leave.enums;

/*
 * 剩余假期处理策略
 */

public enum SurplusLeaveStrategy {
	/*
	 * 立即失效
	 */
	FAILURE,
	/*
	 * 移到下一年度
	 */
	MOVETO,
	/*
	 * 到指定日期前失效
	 */
	NEVER_FAILURE
}
