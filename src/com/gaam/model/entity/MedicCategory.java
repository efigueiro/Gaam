package com.gaam.model.entity;

import java.io.Serializable;
import java.util.List;

public class MedicCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int medicCategoryId;
	private String name;
	private List<Medic> medicList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Medic> getMedicList() {
		return medicList;
	}
	public void setMedicList(List<Medic> medicList) {
		this.medicList = medicList;
	}
	public int getMedicCategoryId() {
		return medicCategoryId;
	}
	public void setMedicCategoryId(int medicCategoryId) {
		this.medicCategoryId = medicCategoryId;
	}
	
}
