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
	private List<InsuranceCompany> insuranceCompanyList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMedicId() {
		return medicId;
	}

	public void setMedicId(int medicId) {
		this.medicId = medicId;
	}

	public List<InsuranceCompany> getInsuranceCompanyList() {
		return insuranceCompanyList;
	}

	public void setInsuranceCompanyList(List<InsuranceCompany> insuranceCompanyList) {
		this.insuranceCompanyList = insuranceCompanyList;
	}
}
