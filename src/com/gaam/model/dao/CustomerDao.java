package com.gaam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gaam.model.entity.Customer;
import com.gaam.model.entity.InsuranceCompany;
import com.gaam.model.entity.User;
import com.gaam.util.Msg;

public class CustomerDao extends BaseDao {

	private static CustomerDao customerDao;

	private CustomerDao() {
	}

	public static CustomerDao getInstance() {
		if (customerDao == null) {
			customerDao = new CustomerDao();
		}
		return customerDao;
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

	public String create(Customer customer) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into customer(user_id, name, phone, address, observation, cpf, rg, insurance_company_id, insurance_company_identification, observation)"
				+ "values(?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, customer.getUser().getUserId());
			pstm.setString(2, customer.getName());
			pstm.setString(3, customer.getPhone());
			pstm.setString(4, customer.getAddress());
			pstm.setString(5, customer.getObservation());
			pstm.setString(6, customer.getCpf());
			pstm.setString(7, customer.getRg());
			pstm.setInt(8, customer.getInsuranceCompany().getInsuranceCompanyId());
			pstm.setString(7, customer.getInsuranceCompanyIdentification());
			pstm.setString(7, customer.getObservation());
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

	// search for partial or full name
	public List<Customer> retrieveByFilter(String keyword) throws Exception {
		Connection conn = this.getConnection();
		List<Customer> customerList = new ArrayList<Customer>();
		String sql = "select * from customer where name ilike ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Customer customer= new Customer();
				InsuranceCompany insuranceCompany = new InsuranceCompany();

				// Load customer
				customer.setAddress(rs.getString("address"));
				customer.setBirthDate(rs.getString("birth_date"));
				customer.setCpf(rs.getString("cpf"));
				customer.setInsuranceCompanyIdentification(rs.getString("insurance_company_identification"));
				customer.getInsuranceCompany().setInsuranceCompanyId(rs.getInt("insurance_company_id"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setRg(rs.getString("rg"));

				// Add customer to customerList
				customerList.add(customer);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return customerList;
	}
}
