package com.huoyun.business.leave;

import java.time.LocalDate;
import java.util.List;

import com.huoyun.business.leave.entity.Holiday;
import com.huoyun.exception.BusinessException;

public interface HolidayService {

	/*
	 * 判断指定日期是不是非工作日
	 */
	boolean isNotWorkDay(LocalDate date) throws BusinessException;

	/*
	 * 获取当年所有的假日（包括国家和公司）
	 */
	List<Holiday> getHolidays(int year);

	/*
	 * 创建假日
	 */
	void createHoliday(Holiday holiday) throws BusinessException;

	/*
	 * 删除假日
	 */
	void deleteHoliday(Long id) throws BusinessException;
}
