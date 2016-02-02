package com.huoyun.business.leave.dto;

import java.time.LocalDate;

import com.huoyun.business.leave.entity.LeaveType;
import com.huoyun.business.leave.enums.LeaveRecordStatus;
import com.huoyun.business.leave.enums.TimeRange;

public class LeaveRecordDTO {

	private long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private TimeRange start;
	private TimeRange end;
	private double total;
	private String description;
	private LeaveType type;
	private LeaveRecordStatus status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public TimeRange getStart() {
		return start;
	}

	public void setStart(TimeRange start) {
		this.start = start;
	}

	public TimeRange getEnd() {
		return end;
	}

	public void setEnd(TimeRange end) {
		this.end = end;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LeaveType getType() {
		return type;
	}

	public void setType(LeaveType type) {
		this.type = type;
	}

	public LeaveRecordStatus getStatus() {
		return status;
	}

	public void setStatus(LeaveRecordStatus status) {
		this.status = status;
	}
}
