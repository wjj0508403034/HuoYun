package com.huoyun.business.leave.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.huoyun.business.leave.enums.SurplusLeaveStrategy;

@Entity
@Table
public class LeaveType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false, unique = true)
	private String foreignName;
	
	@Column(nullable = false)
	private SurplusLeaveStrategy surplusLeaveStrategy = SurplusLeaveStrategy.FAILURE;

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
}
