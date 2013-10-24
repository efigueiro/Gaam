package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gaam.model.entity.User;
import com.gaam.util.Msg;

public class UserDao extends BaseDao {

	private static UserDao userDao;

	private UserDao() {
	}

	public static UserDao getInstance() {
		if (userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
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
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return user;
	}

	public String create(User user) throws Exception {
        String message = "";
        Connection conn = this.getConnection();
        String sql = "insert into users(email, password, status, role)" + "values(?,?,?,?);";
        try {
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setString(1, user.getEmail());
                pstm.setString(2, user.getPassword());
                pstm.setString(3, user.getStatus());
                pstm.setString(4, user.getRole());
                pstm.execute();
                pstm.close();
                conn.close();

                message = Msg.getProperty("message.success");
        } catch (Exception e) {
                message = e + " " + Msg.getProperty("message.error");
                conn.close();
        }
        return message;
}
}
