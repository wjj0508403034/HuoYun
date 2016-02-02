package com.huoyun.business.leave.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.huoyun.business.leave.enums.HolidayType;


@Entity
@Table
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Column
	private String foreignName;

	@Column
	private int year;

	@Column
	private int month;

	@Column
	private int day;

	@Column
	private HolidayType holidayType = HolidayType.NATIONALITY;

	@Transient
	public LocalDate getDate() {
		return LocalDate.of(this.year, this.month, this.day);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForeignName() {
		return foreignName;
	}

	public void setForeignName(String foreignName) {
		this.foreignName = foreignName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public HolidayType getHolidayType() {
		return holidayType;
	}

	public void setHolidayType(HolidayType holidayType) {
		this.holidayType = holidayType;
	}
}
