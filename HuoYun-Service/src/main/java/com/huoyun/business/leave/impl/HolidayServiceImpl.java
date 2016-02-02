package com.huoyun.business.leave.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huoyun.business.leave.HolidayService;
import com.huoyun.business.leave.entity.Holiday;
import com.huoyun.business.leave.repository.HolidayRepository;
import com.huoyun.core.common.BoService;
import com.huoyun.core.company.settings.GeneralSettingService;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.BusinessObjectNotFoundException;
import com.huoyun.exception.NotAdminException;

@Service
public class HolidayServiceImpl extends BoService implements HolidayService {

	@Autowired
	private HolidayRepository holidayRepository;

	@Autowired
	private GeneralSettingService generalSettingService;

	@Override
	public boolean isNotWorkDay(LocalDate date) throws BusinessException {
		boolean isWorkDay = this.generalSettingService.isWorkDay(date);
		if (isWorkDay) {
			Holiday holiday = this.holidayRepository.findByYearAndMonthAndDay(
					date.getYear(), date.getMonthValue(), date.getDayOfMonth());
			return holiday == null;
		}
		return false;
	}

	@Override
	public List<Holiday> getHolidays(int year) {
		return this.holidayRepository.findAllByYear(year);
	}

	@Override
	public void createHoliday(Holiday holiday) throws BusinessException {
		if (!this.boFacade.isAdmin()) {
			throw new NotAdminException(this.localeService);
		}

		this.holidayRepository.save(holiday);
	}

	@Override
	public void deleteHoliday(Long id) throws BusinessException {
		if (!this.boFacade.isAdmin()) {
			throw new NotAdminException(this.localeService);
		}

		Holiday holiday = this.holidayRepository.findOne(id);
		if (holiday == null) {
			throw new BusinessObjectNotFoundException(Holiday.class, id,
					this.localeService);
		}

		this.holidayRepository.delete(holiday);
	}

}
