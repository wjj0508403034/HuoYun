package com.huoyun.core.common.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.huoyun.core.user.entity.User;

@MappedSuperclass
public abstract class BaseEntity extends Entity {

	@ManyToOne
	@JoinColumn
	private User createBy;

	@ManyToOne
	@JoinColumn
	private User updateBy;

	@Column
	private LocalDate createTime;

	@Column
	private LocalDate updateTime;

	@ManyToOne
	@JoinColumn
	private User owner;

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	public LocalDate getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
