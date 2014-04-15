package com.gaam.model.entity;

import java.io.Serializable;
import java.util.List;

public class Medic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int medicId;
	private String name;
	private String phone;
	private String address;
	private String crm;
	private User user;
	private String observation;
	private List<Category> categoryList;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public int getMedicId() {
		return medicId;
	}

	public void setMedicId(int medicId) {
		this.medicId = medicId;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<InsuranceCompany> getInsuranceCompanyList() {
		return insuranceCompanyList;
	}

	public void setInsuranceCompanyList(List<InsuranceCompany> insuranceCompanyList) {
		this.insuranceCompanyList = insuranceCompanyList;
	}
}
