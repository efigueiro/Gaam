package com.gaam.model.service;

import com.gaam.model.dao.LoginDao;
import com.gaam.model.entity.User;

public class CustomerService {
	
	private static CustomerService customerService;

	private CustomerService() {
	}

	public static CustomerService getInstance() {
		if (customerService == null) {
			customerService = new CustomerService();
		}
		return customerService;
	}

	public User authentication(User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginDao.getInstance().authentication(user);
		return authenticated;
	}

}
