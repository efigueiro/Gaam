package com.gaam.model.service;

import com.gaam.model.dao.InsuranceCompanyDao;
import com.gaam.model.dao.LoginDao;
import com.gaam.model.dao.MedicDao;
import com.gaam.model.entity.InsuranceCompany;
import com.gaam.model.entity.Medic;
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
	
	public String create(Medic medic) throws Exception {
		return MedicDao.getInstance().create(medic);
	}
	
	public Medic retrieveById(int medicId) throws Exception {
		return MedicDao.getInstance().retrieveById(medicId);
	}
	
	public Medic retrieveByCrm(String crm) throws Exception {
		return MedicDao.getInstance().retrieveByCrm(crm);
	}

}
