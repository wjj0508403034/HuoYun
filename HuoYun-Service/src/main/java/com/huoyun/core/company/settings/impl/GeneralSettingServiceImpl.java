package com.huoyun.core.company.settings.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.huoyun.business.leave.repository.WorkDayRepository;
import com.huoyun.business.leave.repository.WorkHoursRepository;
import com.huoyun.core.common.BoService;
import com.huoyun.core.company.ErrorCode;
import com.huoyun.core.company.settings.GeneralSettingService;
import com.huoyun.core.company.settings.entity.WorkDay;
import com.huoyun.core.company.settings.entity.WorkHours;
import com.huoyun.exception.BusinessException;

@Service
public class GeneralSettingServiceImpl extends BoService implements
		GeneralSettingService {

	@Autowired
	private WorkDayRepository workDayRepository;

	@Autowired
	private WorkHoursRepository workHoursRepository;

	@Override
	public void setWorkHour(WorkHours workhours) throws BusinessException {
		this.workHoursRepository.save(workhours);
	}

	@Override
	public void setWorkDay(WorkDay workDay) throws BusinessException {
		this.workDayRepository.save(workDay);
	}

	@Override
	public WorkDay getWorkDay() throws BusinessException {
		List<WorkDay> workdays = (List<WorkDay>) Lists
				.newArrayList(this.workDayRepository.findAll());

		if (workdays.size() > 0) {
			return workdays.get(0);
		}

		throw new BusinessException(ErrorCode.Company_Workday_No_Data,
				localeService);
	}

	@Override
	public WorkHours getWorkHours() throws BusinessException {
		List<WorkHours> workHours = (List<WorkHours>) Lists
				.newArrayList(this.workHoursRepository.findAll());

		if (workHours.size() > 0) {
			return workHours.get(0);
		}

		throw new BusinessException(ErrorCode.Company_Workhours_No_Data,
				localeService);
	}

	@Override
	public boolean isWorkDay(LocalDate date) throws BusinessException {
		WorkDay workDay = this.getWorkDay();
		if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
			return workDay.isMonday();
		}

		if (date.getDayOfWeek() == DayOfWeek.TUESDAY) {
			return workDay.isTuesday();
		}

		if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
			return workDay.isWednesday();
		}

		if (date.getDayOfWeek() == DayOfWeek.THURSDAY) {
			return workDay.isThursday();
		}

		if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
			return workDay.isFriday();
		}

		if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
			return workDay.isSaturday();
		}

		return workDay.isSunday();
	}

}
