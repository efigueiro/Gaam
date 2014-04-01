package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gaam.model.entity.Category;
import com.gaam.util.Msg;

public class CategoryDao extends BaseDao {

	private static CategoryDao categoryDao;

	private CategoryDao() {
	}

	public static CategoryDao getInstance() {
		if (categoryDao == null) {
			categoryDao = new CategoryDao();
		}
		return categoryDao;
	}

	public Category retrieveById(int categoryId) throws Exception {
		Connection conn = this.getConnection();
		Category category = new Category();
		String sql = "select * from category where category_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, categoryId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				category.setCategoryId(rs.getInt("category_id"));
				category.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			
		}
		
		return category;
	}
	
	public Category retrieveByName(String name) throws Exception {
		Connection conn = this.getConnection();
		Category category = new Category();
		String sql = "select * from category where name ilike ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				category.setCategoryId(rs.getInt("category_id"));
				category.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return category;
	}

	public String create(Category category) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into category(name)"
				+ "values(?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, category.getName());
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

	public List<Category> retrieveAll() throws Exception {
		Connection conn = this.getConnection();
		List<Category> categoryList = new ArrayList<Category>();
		String sql = "select * from category order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setName(rs.getString("name"));
				
				categoryList.add(category);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return categoryList;
	}
	
	public List<Category> retrieveByFilter(String keyword) throws Exception {
		Connection conn = this.getConnection();
		List<Category> categoryList = new ArrayList<Category>();
		String sql = "select * from category where name ilike ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Category category = new Category();

				category.setCategoryId(rs.getInt("category_id"));
				category.setName(rs.getString("name"));
				categoryList.add(category);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return categoryList;
	}
	
	public String deleteById(int categoryId) throws Exception {
		Connection conn = this.getConnection();
		String sql = "delete from category where category_id = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, categoryId);
			pstm.execute();
			return Msg.getProperty("message.success");
		} catch (Exception e) {
			conn.close();
		}
		return null;
	}
	
	public String update(Category category) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "update category set medic_category_id=?, name=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, category.getCategoryId());
			pstm.setString(2, category.getName());
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
