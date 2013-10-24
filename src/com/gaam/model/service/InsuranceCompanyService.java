package com.gaam.model.service;

import com.gaam.model.dao.LoginDao;
import com.gaam.model.entity.User;

public class InsuranceCompanyService {
	
	private static InsuranceCompanyService insuranceCompanyService;

	private InsuranceCompanyService() {
	}

	public static InsuranceCompanyService getInstance() {
		if (insuranceCompanyService == null) {
			insuranceCompanyService = new InsuranceCompanyService();
		}
		return insuranceCompanyService;
	}

	public User authentication(User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginDao.getInstance().authentication(user);
		return authenticated;
	}

}
