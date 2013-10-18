package com.gaam.model.entity;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String address;
	private String cpf;
	private String rg;
	private String country;
	private String city;
	private List<InsuranceCompany> InsuranceCompanyList;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<InsuranceCompany> getInsuranceCompanyList() {
		return InsuranceCompanyList;
	}

	public void setInsuranceCompanyList(
			List<InsuranceCompany> insuranceCompanyList) {
		InsuranceCompanyList = insuranceCompanyList;
	}

}
