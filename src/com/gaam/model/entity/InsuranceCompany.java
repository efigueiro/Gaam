package com.gaam.model.entity;

import java.io.Serializable;
import java.util.List;

public class InsuranceCompany implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int insuranceCompanyId;
	private String name;
	private String phone;
	private String address;
	private String observation;
	private List<Customer> customerList;
	private List<Medic> medicList;

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

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Medic> getMedicList() {
		return medicList;
	}

	public void setMedicList(List<Medic> medicList) {
		this.medicList = medicList;
	}

	public int getInsuranceCompanyId() {
		return insuranceCompanyId;
	}

	public void setInsuranceCompanyId(int insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}

}
