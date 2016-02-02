package com.huoyun.core.company.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column
	private Long logo;

	@Column
	private String description;

	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinColumn
	private CompanyAddress companyAddress;

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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CompanyAddress getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(CompanyAddress companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Long getLogo() {
		return logo;
	}

	public void setLogo(Long logo) {
		this.logo = logo;
	}
}
