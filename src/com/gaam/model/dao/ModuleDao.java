package com.gaam.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gaam.model.entity.User;

public class ModuleDao extends BaseDao {

	private static ModuleDao moduleDao;

	private ModuleDao() {
	}

	public static ModuleDao getInstance() {
		if (moduleDao == null) {
			moduleDao = new ModuleDao();
		}
		return moduleDao;
	}

	public User authentication(User user) throws Exception {
		Connection conn = this.getConnection();
		User u = new User();
		String sql = "select * from users where email = ? and password = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getPassword());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				u.setUserId(rs.getInt("user_id"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}
			conn.close();
		} catch (Exception e) {
		}
		return u;
	}

}
