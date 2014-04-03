package com.gaam.model.service;

import java.util.List;

import com.gaam.model.dao.LoginDao;
import com.gaam.model.dao.CategoryDao;
import com.gaam.model.entity.Category;
import com.gaam.model.entity.User;

public class CategoryService {
	
	private static CategoryService categoryService;

	private CategoryService() {
	}

	public static CategoryService getInstance() {
		if (categoryService == null) {
			categoryService = new CategoryService();
		}
		return categoryService;
	}

	public User authentication(User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginDao.getInstance().authentication(user);
		return authenticated;
	}
	
	public String create(Category category) throws Exception {
		return CategoryDao.getInstance().create(category);
	}
	
	public List<Category> retrieveAll() throws Exception {
		return CategoryDao.getInstance().retrieveAll();
	}
	
	public List<Category> retrieveByFilter(String keyword) throws Exception {
		return CategoryDao.getInstance().retrieveByFilter(keyword);
	}
	
	public String deleteById(int categoryId) throws Exception {
		return CategoryDao.getInstance().deleteById(categoryId);
	}
	
	public Category retrieveById(int categoryId) throws Exception {
		return CategoryDao.getInstance().retrieveById(categoryId);
	}
	
	public Category retrieveByName(String name) throws Exception {
		return CategoryDao.getInstance().retrieveByName(name);
	}

}
