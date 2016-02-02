package com.huoyun.core.user.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ResetPasswordRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = true)
	private String email;

	@Column(nullable = true)
	private String code;
	
	@Column(nullable = true)
	private LocalDate createTime;
	
	@Column(nullable = true)
	private LocalDate expirationTime;
	
	@Column
	private boolean finish;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	public LocalDate getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(LocalDate expirationTime) {
		this.expirationTime = expirationTime;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}
}
