package com.gaam.model.service;

import com.gaam.model.dao.LoginDao;
import com.gaam.model.entity.User;

public class MedicService {
	
	private static MedicService medicService;

	private MedicService() {
	}

	public static MedicService getInstance() {
		if (medicService == null) {
			medicService = new MedicService();
		}
		return medicService;
	}

	public User authentication(User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginDao.getInstance().authentication(user);
		return authenticated;
	}

}
