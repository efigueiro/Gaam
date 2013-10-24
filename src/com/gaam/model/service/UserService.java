package com.gaam.model.service;

import com.gaam.model.dao.LoginDao;
import com.gaam.model.entity.User;

public class UserService {
	
	private static UserService userService;

	private UserService() {
	}

	public static UserService getInstance() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	public User authentication(User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginDao.getInstance().authentication(user);
		return authenticated;
	}

}
