package com.gaam.model.service;

import java.util.List;

import com.gaam.model.dao.InsuranceCompanyDao;
import com.gaam.model.dao.LoginDao;
import com.gaam.model.entity.InsuranceCompany;
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
	
	public String create(InsuranceCompany insuranceCompany) throws Exception {
		return InsuranceCompanyDao.getInstance().create(insuranceCompany);
	}
	
	public List<InsuranceCompany> retrieveAll() throws Exception {
		return InsuranceCompanyDao.getInstance().retrieveAll();
	}
	
	public List<InsuranceCompany> retrieveByFilter(String keyword) throws Exception {
		return InsuranceCompanyDao.getInstance().retrieveByFilter(keyword);
	}

}
