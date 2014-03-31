package com.gaam.model.service;

import java.util.List;

import com.gaam.model.dao.RoleDao;
import com.gaam.model.entity.Role;

public class RoleService {
	
	private static RoleService roleService;

	private RoleService() {
	}

	public static RoleService getInstance() {
		if (roleService == null) {
			roleService = new RoleService();
		}
		return roleService;
	}
	
	public List<Role> retrieveAll() throws Exception {
		return RoleDao.getInstance().retrieveAll();
	}
	
	public Role retrieveById(int roleId) throws Exception {
		return RoleDao.getInstance().retrieveById(roleId);
	}
	
}
