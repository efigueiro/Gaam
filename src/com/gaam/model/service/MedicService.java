package com.gaam.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gaam.model.dao.LoginDao;
import com.gaam.model.dao.MedicDao;
import com.gaam.model.entity.Category;
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
	
	public boolean isValidCrm(String crm) throws Exception {
		Medic medic = new Medic();
		medic = MedicDao.getInstance().retrieveByCrm(crm);
		
		if(StringUtils.isEmpty(medic.getCrm())){
			return true;
		} else {
			return false;
		}
	}
	
	public String insertMedicCategory(int medicId, String categoryId) throws NumberFormatException, Exception {
		return MedicDao.getInstance().medicCategory(medicId, Integer.parseInt(categoryId));
	}
	
	public String insertMedicInsuranceCompany(int medicId, String insuranceCompanyId) throws NumberFormatException, Exception {
		return MedicDao.getInstance().medicInsuranceCompany(medicId, Integer.parseInt(insuranceCompanyId));
	}
	
	public List<Medic> retrieveByFilter(String keyword) throws Exception {
		List<Medic> medicList = new ArrayList<Medic>();
		
		medicList = MedicDao.getInstance().retrieveByFilter(keyword);
		
		for (Medic medic : medicList) {
			List<Category> categoryList = new ArrayList<Category>();
			List<Integer> categoryIdList = new ArrayList<Integer>();
			categoryIdList = MedicDao.getInstance().retrieveMedicCategory(medic.getMedicId());
			
			for (Integer integer : categoryIdList) {
				Category category = new Category();
				category = CategoryService.getInstance().retrieveById(integer);
				categoryList.add(category);
			} 
			medic.setCategoryList(categoryList);
		}
		
		
		
		
		return medicList;
		
	}

}
