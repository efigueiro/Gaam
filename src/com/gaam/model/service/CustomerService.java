package com.gaam.model.service;

import com.gaam.model.dao.CustomerDao;
import com.gaam.model.dao.LoginDao;
import com.gaam.model.entity.Customer;
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
	
	public String create(Customer customer) throws Exception {
		return CustomerDao.getInstance().create(customer);
	}
	
	public String customerInsuranceCompany(int customerId, int insuranceCompanyId, String insuranceCompanyIdentification) throws Exception {
		return CustomerDao.getInstance().customerInsuranceCompany(customerId, insuranceCompanyId, insuranceCompanyIdentification);
	}

}
