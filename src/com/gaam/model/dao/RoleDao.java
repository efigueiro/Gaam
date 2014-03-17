package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gaam.model.entity.InsuranceCompany;
import com.gaam.model.entity.Role;
import com.gaam.util.Msg;

public class RoleDao extends BaseDao {

	private static RoleDao roleDao;

	private RoleDao() {
	}

	public static RoleDao getInstance() {
		if (roleDao == null) {
			roleDao = new RoleDao();
		}
		return roleDao;
	}

	public Role retrieveById(int roleId) throws Exception {
		Connection conn = this.getConnection();
		Role role = new Role();
		String sql = "select * from role where role_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, roleId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				role.setRoleId(rs.getInt("role_id"));
				role.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			
		}
		
		return role;
	}
	
	public Role retrieveName(String name) throws Exception {
		Connection conn = this.getConnection();
		Role role = new Role();
		String sql = "select * from role where name ilike ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				role.setRoleId(rs.getInt("role_id"));
				role.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return role;
	}

	public List<Role> retrieveAll() throws Exception {
		Connection conn = this.getConnection();
		List<Role> roleList = new ArrayList<Role>();
		String sql = "select * from role order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRoleId(rs.getInt("role_id"));
				role.setName(rs.getString("name"));
				
				roleList.add(role);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return roleList;
	}
}
