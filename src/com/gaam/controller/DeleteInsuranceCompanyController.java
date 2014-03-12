package com.gaam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaam.model.service.InsuranceCompanyService;

/**
 * Servlet implementation class DeleteInsuranceCompany
 */
@WebServlet("/deleteInsuranceCompany")
public class DeleteInsuranceCompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteInsuranceCompanyController() {
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

		String message = "";

		String strInsuranceCompanyId = (String) request.getParameter("selectedValueId");
		int insuranceCompanyId  = Integer.parseInt(strInsuranceCompanyId);

		try {
			message = InsuranceCompanyService.getInstance().deleteById(insuranceCompanyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("modules/admin/retrieveInsuranceCompany.jsp").forward(request, response);
	}
}
