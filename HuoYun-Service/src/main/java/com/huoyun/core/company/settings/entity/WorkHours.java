package com.huoyun.core.company.settings.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class WorkHours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private LocalDate morningStart;

	@Column
	private LocalDate moringEnd;

	@Column
	private LocalDate afternoonStart;

	@Column
	private LocalDate afternoonEnd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getMorningStart() {
		return morningStart;
	}

	public void setMorningStart(LocalDate morningStart) {
		this.morningStart = morningStart;
	}

	public LocalDate getMoringEnd() {
		return moringEnd;
	}

	public void setMoringEnd(LocalDate moringEnd) {
		this.moringEnd = moringEnd;
	}

	public LocalDate getAfternoonStart() {
		return afternoonStart;
	}

	public void setAfternoonStart(LocalDate afternoonStart) {
		this.afternoonStart = afternoonStart;
	}

	public LocalDate getAfternoonEnd() {
		return afternoonEnd;
	}

	public void setAfternoonEnd(LocalDate afternoonEnd) {
		this.afternoonEnd = afternoonEnd;
	}
}
