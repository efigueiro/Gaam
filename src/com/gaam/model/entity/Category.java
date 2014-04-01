package com.gaam.model.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private String name;
	private List<Medic> medicList;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
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
	
}
