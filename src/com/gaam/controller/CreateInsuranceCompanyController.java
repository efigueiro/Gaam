package com.gaam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gaam.model.entity.InsuranceCompany;
import com.gaam.model.service.InsuranceCompanyService;
import com.gaam.util.Msg;

/**
 * Servlet implementation class CreateInsuranceCompany
 */
@WebServlet("/createInsuranceCompany")
public class CreateInsuranceCompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateInsuranceCompanyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*private String name;
		private String phone;
		private String address;
		private String observation;
		private List<Customer> customerList;
		private List<Medic> medicList;*/
		
		
		String message = "";

		String name = (String) request.getParameter("name");
		String phone = (String) request.getParameter("phone");
		String address = (String) request.getParameter("address");
		String observation = (String) request.getParameter("observation");

		InsuranceCompany insuranceCompany = new InsuranceCompany();
		insuranceCompany.setAddress(address);
		insuranceCompany.setName(name);
		insuranceCompany.setObservation(observation);
		insuranceCompany.setPhone(phone);

		
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(phone)) {
			message = Msg.getProperty("message.empty.fields");
		} else {
			try {
				message = InsuranceCompanyService.getInstance().create(insuranceCompany);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("modules/admin/createInsuranceCompany.jsp").forward(request, response);
	}
}
