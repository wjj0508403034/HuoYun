package com.huoyun.business.leave.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.huoyun.business.leave.enums.LeaveRecordStatus;
import com.huoyun.business.leave.enums.TimeRange;
import com.huoyun.core.employee.entity.Employee;

@Entity
@Table
public class LeaveRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn
	private Employee employee;

	@Column(nullable = false)
	private LocalDate startDate;

	@Column(nullable = false)
	private LocalDate endDate;

	@Column
	private TimeRange start;

	@Column
	private TimeRange end;

	@Column
	private double total;

	@Column
	private int year;

	@Column(length = 1000)
	private String description;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn
	private LeaveType type;
	
	@Column
	private LeaveRecordStatus status = LeaveRecordStatus.NEW;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

}
