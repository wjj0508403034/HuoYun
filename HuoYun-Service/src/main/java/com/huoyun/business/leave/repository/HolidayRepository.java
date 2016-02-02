package com.huoyun.business.leave.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.business.leave.entity.Holiday;

public interface HolidayRepository extends CrudRepository<Holiday, Long> {

	public Holiday findByYearAndMonthAndDay(int year, int month, int day);

	public List<Holiday> findAllByYear(int year);
}
