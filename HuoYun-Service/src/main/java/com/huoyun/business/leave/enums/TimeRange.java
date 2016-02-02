package com.huoyun.business.leave.enums;

public enum TimeRange {
	MORNING(0), NOON(1), AFTERNOON(2);

	private int enumCode;

	private TimeRange(int enumCode) {
		this.enumCode = enumCode;
	}

	public int getEnumCode() {
		return enumCode;
	}
}
