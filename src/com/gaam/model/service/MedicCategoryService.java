package com.gaam.model.service;

import java.util.List;

import com.gaam.model.dao.LoginDao;
import com.gaam.model.dao.MedicCategoryDao;
import com.gaam.model.entity.MedicCategory;
import com.gaam.model.entity.User;

public class MedicCategoryService {
	
	private static MedicCategoryService medicCategoryService;

	private MedicCategoryService() {
	}

	public static MedicCategoryService getInstance() {
		if (medicCategoryService == null) {
			medicCategoryService = new MedicCategoryService();
		}
		return medicCategoryService;
	}

	public User authentication(User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginDao.getInstance().authentication(user);
		return authenticated;
	}
	
	public String create(MedicCategory medicCategory) throws Exception {
		return MedicCategoryDao.getInstance().create(medicCategory);
	}
	
	public List<MedicCategory> retrieveAll() throws Exception {
		return MedicCategoryDao.getInstance().retrieveAll();
	}
	
	public List<MedicCategory> retrieveByFilter(String keyword) throws Exception {
		return MedicCategoryDao.getInstance().retrieveByFilter(keyword);
	}
	
	public String deleteById(int medicCategoryId) throws Exception {
		return MedicCategoryDao.getInstance().deleteById(medicCategoryId);
	}
	
	public MedicCategory retrieveById(int medicCategoryId) throws Exception {
		return MedicCategoryDao.getInstance().retrieveById(medicCategoryId);
	}

	public String update(MedicCategory medicCategory) throws Exception {
		return MedicCategoryDao.getInstance().update(medicCategory);
	}
}
