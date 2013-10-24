package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gaam.model.entity.User;

public class InsuranceCompanyDao extends BaseDao {

	private static InsuranceCompanyDao insuranceCompanyDao;

	private InsuranceCompanyDao() {
	}

	public static InsuranceCompanyDao getInstance() {
		if (insuranceCompanyDao == null) {
			insuranceCompanyDao = new InsuranceCompanyDao();
		}
		return insuranceCompanyDao;
	}

	public User retrieveById(int userId) throws Exception {
		Connection conn = this.getConnection();
		User user = new User();
		String sql = "select * from users where user_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserId(rs.getInt("user_id"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return user;
	}
}
