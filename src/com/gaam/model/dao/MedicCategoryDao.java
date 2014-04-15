package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public String insertMedicInsuranceCompany(int medicId, int insuranceCompanyId) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into medic_insurance_company(medic_id, insurance_company_id)"
				+ "values(?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medicId);
			pstm.setInt(2, insuranceCompanyId);
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
	
	public String insertMedicCategory(int medicId, int categoryId) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into medic_category(medic_id, category_id)"
				+ "values(?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medicId);
			pstm.setInt(2, categoryId);
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
	
	public List<Integer> retrieveMedicCategory(int medicId) throws Exception {
		Connection conn = this.getConnection();
		List<Integer> categories = new ArrayList<Integer>();
		String sql = "select * from medic_category where medic_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medicId);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				categories.add(rs.getInt("category_id"));
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return categories;
	}
}

