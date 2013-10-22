package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gaam.model.entity.User;

public class LoginDao extends BaseDao {

	private static LoginDao loginDao;

	private LoginDao() {
	}

	public static LoginDao getInstance() {
		if (loginDao == null) {
			loginDao = new LoginDao();
		}
		return loginDao;
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
