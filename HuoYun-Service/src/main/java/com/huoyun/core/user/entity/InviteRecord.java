package com.huoyun.core.user.entity;

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
import javax.persistence.Table;

@Entity
@Table
public class InviteRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = true)
	private String email;

	@Column(nullable = true)
	private String inviteCode;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn
	private User inviter;

	@Column(nullable = true)
	private LocalDate invitationTime;
	
	@Column(nullable = true)
	private LocalDate expirationTime; 
	
	@Column
	private boolean finishRegister;

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

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public User getInviter() {
		return inviter;
	}

	public void setInviter(User inviter) {
		this.inviter = inviter;
	}

	public LocalDate getInvitationTime() {
		return invitationTime;
	}

	public void setInvitationTime(LocalDate invitationTime) {
		this.invitationTime = invitationTime;
	}

	public LocalDate getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(LocalDate expirationTime) {
		this.expirationTime = expirationTime;
	}

	public boolean isFinishRegister() {
		return finishRegister;
	}

	public void setFinishRegister(boolean finishRegister) {
		this.finishRegister = finishRegister;
	}
}
