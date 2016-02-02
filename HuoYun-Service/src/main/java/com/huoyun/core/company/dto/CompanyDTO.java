package com.huoyun.core.company.dto;

public class CompanyDTO{

	private String name;
	private Long logo;
	private String description;
	private CompanyAddressDTO companyAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLogo() {
		return logo;
	}

	public void setLogo(Long logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CompanyAddressDTO getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(CompanyAddressDTO companyAddress) {
		this.companyAddress = companyAddress;
	}
}
