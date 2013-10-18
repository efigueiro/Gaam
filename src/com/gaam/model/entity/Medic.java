package com.gaam.model.entity;

import java.io.Serializable;
import java.util.List;

public class Medic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String address;
	private String crm;
	private String speciality;
	private List<InsuranceCompany> insuranceCompanyList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<InsuranceCompany> getInsuranceCOmpanyList() {
		return insuranceCompanyList;
	}

	public void setInsuranceCompanyList(
			List<InsuranceCompany> insuranceCompanyList) {
		this.insuranceCompanyList = insuranceCompanyList;
	}

}
