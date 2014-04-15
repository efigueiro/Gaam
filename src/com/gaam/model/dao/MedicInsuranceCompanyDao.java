package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gaam.util.Msg;

public class MedicInsuranceCompanyDao extends BaseDao {

	private static MedicInsuranceCompanyDao medicInsuranceCompanyDao;

	private MedicInsuranceCompanyDao() {
	}

	public static MedicInsuranceCompanyDao getInstance() {
		if (medicInsuranceCompanyDao == null) {
			medicInsuranceCompanyDao = new MedicInsuranceCompanyDao();
		}
		return medicInsuranceCompanyDao;
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
	
	public List<Integer> retrieveMedicInsuranceCompany(int medicId) throws Exception {
		Connection conn = this.getConnection();
		List<Integer> insuranceCompanies = new ArrayList<Integer>();
		String sql = "select * from medic_insurance_company where medic_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medicId);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				insuranceCompanies.add(rs.getInt("insurance_company_id"));
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return insuranceCompanies;
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
	
	
}

