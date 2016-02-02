package com.huoyun.core.company.dto;

import org.joda.time.DateTime;

public class WorkHoursDTO {

	private DateTime morningStart;

	private DateTime moringEnd;

	private DateTime afternoonStart;

	private DateTime afternoonEnd;

	public DateTime getMorningStart() {
		return morningStart;
	}

	public void setMorningStart(DateTime morningStart) {
		this.morningStart = morningStart;
	}

	public DateTime getMoringEnd() {
		return moringEnd;
	}

	public void setMoringEnd(DateTime moringEnd) {
		this.moringEnd = moringEnd;
	}

	public DateTime getAfternoonStart() {
		return afternoonStart;
	}

	public void setAfternoonStart(DateTime afternoonStart) {
		this.afternoonStart = afternoonStart;
	}

	public DateTime getAfternoonEnd() {
		return afternoonEnd;
	}

	public void setAfternoonEnd(DateTime afternoonEnd) {
		this.afternoonEnd = afternoonEnd;
	}
}
