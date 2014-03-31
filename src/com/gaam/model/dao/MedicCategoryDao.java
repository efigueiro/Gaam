package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gaam.model.entity.MedicCategory;
import com.gaam.util.Msg;

public class MedicCategoryDao extends BaseDao {

	private static MedicCategoryDao medicCategoryDao;

	private MedicCategoryDao() {
	}

	public static MedicCategoryDao getInstance() {
		if (medicCategoryDao == null) {
			medicCategoryDao = new MedicCategoryDao();
		}
		return medicCategoryDao;
	}

	public MedicCategory retrieveById(int medicCategoryId) throws Exception {
		Connection conn = this.getConnection();
		MedicCategory medicCategory = new MedicCategory();
		String sql = "select * from medic_category where medic_category_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medicCategoryId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				medicCategory.setMedicCategoryId(rs.getInt("medic_category_id"));
				medicCategory.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			
		}
		
		return medicCategory;
	}
	
	public MedicCategory retrieveByName(String name) throws Exception {
		Connection conn = this.getConnection();
		MedicCategory medicCategory = new MedicCategory();
		String sql = "select * from medic_category where name ilike ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				medicCategory.setMedicCategoryId(rs.getInt("medic_category_id"));
				medicCategory.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return medicCategory;
	}

	public String create(MedicCategory medicCategory) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into medic_category(name)"
				+ "values(?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, medicCategory.getName());
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

	public List<MedicCategory> retrieveAll() throws Exception {
		Connection conn = this.getConnection();
		List<MedicCategory> medicCategoryList = new ArrayList<MedicCategory>();
		String sql = "select * from medic_category order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				MedicCategory medicCategory = new MedicCategory();
				medicCategory.setMedicCategoryId(rs.getInt("medic_category_id"));
				medicCategory.setName(rs.getString("name"));
				
				medicCategoryList.add(medicCategory);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return medicCategoryList;
	}
	
	public List<MedicCategory> retrieveByFilter(String keyword) throws Exception {
		Connection conn = this.getConnection();
		List<MedicCategory> medicCategoryList = new ArrayList<MedicCategory>();
		String sql = "select * from medic_category where name ilike ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				MedicCategory medicCategory = new MedicCategory();

				medicCategory.setMedicCategoryId(rs.getInt("medic_category_id"));
				medicCategory.setName(rs.getString("name"));
				medicCategoryList.add(medicCategory);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return medicCategoryList;
	}
	
	public String deleteById(int medicCategoryId) throws Exception {
		Connection conn = this.getConnection();
		String sql = "delete from medic_category where medic_category_id = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medicCategoryId);
			pstm.execute();
			return Msg.getProperty("message.success");
		} catch (Exception e) {
			conn.close();
		}
		return null;
	}
	
	public String update(MedicCategory medicCategory) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "update medic_category set medic_category_id=?, name=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medicCategory.getMedicCategoryId());
			pstm.setString(2, medicCategory.getName());
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
