package com.gaam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gaam.model.entity.InsuranceCompany;
import com.gaam.model.service.InsuranceCompanyService;
import com.gaam.model.service.LoginService;
import com.gaam.util.Msg;

/**
 * Servlet implementation class CreateInsuranceCompany
 */
@WebServlet("/retrieveInsuranceCompany")
public class RetrieveInsuranceCompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveInsuranceCompanyController() {
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

		String keyword = (String) request.getParameter("keyword");
		List<InsuranceCompany> insuranceCompanyList = new ArrayList<InsuranceCompany>();

		try {
			insuranceCompanyList = InsuranceCompanyService.getInstance().retrieveByFilter(keyword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("insuranceCompanyList", insuranceCompanyList);
		request.getRequestDispatcher("modules/admin/retrieveInsuranceCompany.jsp").forward(request, response);
	}
}
