package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gaam.model.entity.InsuranceCompany;
import com.gaam.util.Msg;

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

	public InsuranceCompany retrieveById(int insuranceCompanyId) throws Exception {
		Connection conn = this.getConnection();
		InsuranceCompany insuranceCompany = new InsuranceCompany();
		String sql = "select * from insurance_company where insurance_company_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, insuranceCompanyId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				insuranceCompany.setAddress(rs.getString("address"));
				insuranceCompany.setInsuranceCompanyId(rs.getInt("insurance_company_id"));
				insuranceCompany.setName(rs.getString("name"));
				insuranceCompany.setObservation(rs.getString("observation"));
				insuranceCompany.setPhone(rs.getString("phone"));
			}
			rs.close();
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			
		}
		
		return insuranceCompany;
	}
	
	public InsuranceCompany retrieveName(String name) throws Exception {
		Connection conn = this.getConnection();
		InsuranceCompany insuranceCompany = new InsuranceCompany();
		String sql = "select * from insurance_company where name ilike ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				insuranceCompany.setAddress(rs.getString("address"));
				insuranceCompany.setInsuranceCompanyId(rs.getInt("insurance_company_id"));
				insuranceCompany.setName(rs.getString("name"));
				insuranceCompany.setObservation(rs.getString("observation"));
				insuranceCompany.setPhone(rs.getString("phone"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return insuranceCompany;
	}

	public String create(InsuranceCompany insuranceCompany) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into insurance_company(name, phone, address, observation)"
				+ "values(?,?,?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, insuranceCompany.getName());
			pstm.setString(2, insuranceCompany.getPhone());
			pstm.setString(3, insuranceCompany.getAddress());
			pstm.setString(4, insuranceCompany.getObservation());
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

	public List<InsuranceCompany> retrieveAll() throws Exception {
		Connection conn = this.getConnection();
		List<InsuranceCompany> insuranceCompanyList = new ArrayList<InsuranceCompany>();
		String sql = "select * from insurance_company order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				InsuranceCompany insuranceCompany = new InsuranceCompany();
				insuranceCompany.setInsuranceCompanyId(rs.getInt("insurance_company_id"));
				insuranceCompany.setAddress(rs.getString("address"));
				insuranceCompany.setName(rs.getString("name"));
				insuranceCompany.setPhone(rs.getString("phone"));
				insuranceCompany.setObservation(rs.getString("observation"));
				
				insuranceCompanyList.add(insuranceCompany);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return insuranceCompanyList;
	}
	
	public List<InsuranceCompany> retrieveByFilter(String keyword) throws Exception {
		Connection conn = this.getConnection();
		List<InsuranceCompany> insuranceCompanyList = new ArrayList<InsuranceCompany>();
		String sql = "select * from insurance_company where name ilike ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				InsuranceCompany insuranceCompany = new InsuranceCompany();

				insuranceCompany.setAddress(rs.getString("address"));
				insuranceCompany.setInsuranceCompanyId(rs.getInt("insurance_company_id"));
				insuranceCompany.setName(rs.getString("name"));
				insuranceCompany.setObservation(rs.getString("observation"));
				insuranceCompany.setPhone(rs.getString("phone"));
				insuranceCompanyList.add(insuranceCompany);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return insuranceCompanyList;
	}
	
	public String deleteById(int insuranceCompanyId) throws Exception {
		Connection conn = this.getConnection();
		String sql = "delete from insurance_company where insurance_company_id = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, insuranceCompanyId);
			pstm.execute();
			return Msg.getProperty("message.success");
		} catch (Exception e) {
			conn.close();
		}
		return null;
	}
	
	public String update(InsuranceCompany insuranceCompany) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "update insurance_company set insurance_company_id=?, name=?, phone=?, address=?, observation=?" + "where insurance_company_id=?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, insuranceCompany.getInsuranceCompanyId());
			pstm.setString(2, insuranceCompany.getName());
			pstm.setString(3, insuranceCompany.getPhone());
			pstm.setString(4, insuranceCompany.getAddress());
			pstm.setString(5, insuranceCompany.getObservation());
			pstm.setInt(6, insuranceCompany.getInsuranceCompanyId());
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
