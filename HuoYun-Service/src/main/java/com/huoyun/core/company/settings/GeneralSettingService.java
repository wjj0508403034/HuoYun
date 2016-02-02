package com.huoyun.core.company.settings;

import java.time.LocalDate;

import com.huoyun.core.company.settings.entity.WorkDay;
import com.huoyun.core.company.settings.entity.WorkHours;
import com.huoyun.exception.BusinessException;

public interface GeneralSettingService {

	/*
	 * 设置工作时间段，例如早上8：00~12:00，下午2：00~6：00
	 */
	void setWorkHour(WorkHours workhours) throws BusinessException;

	/*
	 * 设置工作日
	 */
	void setWorkDay(WorkDay workDay) throws BusinessException;

	/*
	 * 获取公司的工作日信息
	 */
	WorkDay getWorkDay() throws BusinessException;

	/*
	 * 获取公司每日的工作时间
	 */
	WorkHours getWorkHours() throws BusinessException;
	
	/*
	 * 是否工作日
	 */
	boolean isWorkDay(LocalDate date) throws BusinessException;
}
