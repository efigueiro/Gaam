package com.gaam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaam.model.entity.InsuranceCompany;
import com.gaam.model.service.InsuranceCompanyService;

/**
 * Servlet implementation class UpdateInsuranceCompany
 */
@WebServlet("/updateInsuranceCompany")
public class UpdateInsuranceCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInsuranceCompany() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		String strInsuranceCompanyId = (String) request.getParameter("insuranceCompanyId");
		int insuranceCompanyId = Integer.parseInt(strInsuranceCompanyId);
		
		InsuranceCompany selectedInsuranceCompany = new InsuranceCompany();
		
		try {
			selectedInsuranceCompany = InsuranceCompanyService.getInstance().retrieveById(insuranceCompanyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("selectedInsuranceCompany", selectedInsuranceCompany);
		request.getRequestDispatcher("modules/admin/updateInsuranceCompany.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		InsuranceCompany insuranceCompany = new InsuranceCompany();
		
		String strInsuranceCompanyId = (String) request.getParameter("insuranceCompanyId");
		int insuranceCompanyId = Integer.parseInt(strInsuranceCompanyId);
		String name = (String) request.getParameter("name");
		String phone = (String) request.getParameter("phone");
		String address = (String) request.getParameter("address");
		String observation = (String) request.getParameter("observation");
		
		//load old insuranceCompany
		try {
			insuranceCompany = InsuranceCompanyService.getInstance().retrieveById(insuranceCompanyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		//set new values to ensuranceCompany
		insuranceCompany.setAddress(address);
		insuranceCompany.setName(name);
		insuranceCompany.setObservation(observation);
		insuranceCompany.setPhone(phone);
		
		//send the object to update
		try {
			message = InsuranceCompanyService.getInstance().update(insuranceCompany);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		try {
			insuranceCompany = InsuranceCompanyService.getInstance().retrieveById(insuranceCompanyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("selectedInsuranceCompany", insuranceCompany);
		request.getRequestDispatcher("modules/admin/updateInsuranceCompany.jsp").forward(request, response);
	}

}
