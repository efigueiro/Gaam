package com.gaam.model.service;

import com.gaam.model.entity.User;

public class LoginService {
	
	private static LoginService loginService;

	private LoginService() {
	}

	public static LoginService getInstance() {
		if (loginService == null) {
			loginService = new LoginService();
		}
		return loginService;
	}

	public User authentication(User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginService.getInstance().authentication(user);
		return authenticated;
	}

}
