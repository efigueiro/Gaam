package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gaam.model.entity.InsuranceCompany;
import com.gaam.model.entity.Medic;
import com.gaam.util.Msg;

public class MedicDao extends BaseDao {

	private static MedicDao medicDao;

	private MedicDao() {
	}

	public static MedicDao getInstance() {
		if (medicDao == null) {
			medicDao = new MedicDao();
		}
		return medicDao;
	}

	public Medic retrieveById(int userId) throws Exception {
		Connection conn = this.getConnection();
		Medic medic = new Medic();
		String sql = "select * from medic where medic_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				medic.setMedicId(rs.getInt("medic_id"));
				medic.setAddress(rs.getString("address"));
				medic.setCrm(rs.getString("crm"));
				medic.setName(rs.getString("name"));
				medic.setObservation(rs.getString("name"));
				medic.setPhone(rs.getString("phone"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return medic;
	}
	
	public String create(Medic medic) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into medic(user_id, address, crm, name, phone, observation)"
				+ "values(?,?,?,?,?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medic.getUser().getUserId());
			pstm.setString(2, medic.getAddress());
			pstm.setString(3, medic.getCrm());
			pstm.setString(4, medic.getName());
			pstm.setString(5, medic.getPhone());
			pstm.setString(6, medic.getObservation());
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
	
	public Medic retrieveName(String name) throws Exception {
		Connection conn = this.getConnection();
		Medic medic = new Medic();
		String sql = "select * from medic where name = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				medic.setMedicId(rs.getInt("medic_id"));
				medic.setAddress(rs.getString("address"));
				medic.setCrm(rs.getString("crm"));
				medic.setName(rs.getString("name"));
				medic.setObservation(rs.getString("name"));
				medic.setPhone(rs.getString("phone"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return medic;
	}
	
	public Medic retrieveByCrm(String crm) throws Exception {
		Connection conn = this.getConnection();
		Medic medic = new Medic();
		String sql = "select * from medic where crm = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, crm);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				medic.setMedicId(rs.getInt("medic_id"));
				medic.setAddress(rs.getString("address"));
				medic.setCrm(rs.getString("crm"));
				medic.setName(rs.getString("name"));
				medic.setObservation(rs.getString("name"));
				medic.setPhone(rs.getString("phone"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return medic;
	}
	
	public String medicInsuranceCompany(int medicId, int insuranceCompanyId) throws Exception {
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
	
	public String medicCategory(int medicId, int categoryId) throws Exception {
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
	
	public List<Medic> retrieveByFilter(String keyword) throws Exception {
		Connection conn = this.getConnection();
		List<Medic> medicList = new ArrayList<Medic>();
		String sql = "select * from medic where name ilike ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Medic medic = new Medic();
				medic.setAddress(rs.getString("address"));
				medic.setCrm(rs.getString("crm"));
				medic.setMedicId(rs.getInt("medic_id"));
				medic.setName(rs.getString("name"));
				medic.setObservation(rs.getString("observation"));
				medic.setPhone(rs.getString("phone"));
				medicList.add(medic);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return medicList;
	}
	
	public List<Integer> retrieveMedicCategory(int medicId) throws Exception {
		Connection conn = this.getConnection();
		List<Integer> categories = new ArrayList<Integer>();
		int i = 0;
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

