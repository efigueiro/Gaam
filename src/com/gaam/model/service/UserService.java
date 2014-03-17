package com.gaam.model.service;

import org.apache.commons.lang3.StringUtils;

import com.gaam.model.dao.LoginDao;
import com.gaam.model.dao.UserDao;
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
	
	public User retrieveByEmail(String email) throws Exception {
		return UserDao.getInstance().retrieveByEmail(email);
	}
	
	public boolean isValidEMail(String email) throws Exception {
		User user = new User();
		user = UserDao.getInstance().retrieveByEmail(email);
		
		if(StringUtils.isEmpty(user.getEmail())){
			return true;
		} else {
			return false;
		}
	}
	
	public String createUser(User user) throws Exception {
		return UserDao.getInstance().create(user);
	}
	
	
}
