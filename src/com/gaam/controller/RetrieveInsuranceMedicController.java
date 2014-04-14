package com.gaam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaam.model.entity.Medic;
import com.gaam.model.service.MedicService;

/**
 * Servlet implementation class RetrieveInsuranceCompany
 */
@WebServlet("/retrieveMedic")
public class RetrieveInsuranceMedicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveInsuranceMedicController() {
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
		List<Medic> medicList = new ArrayList<Medic>();

		try {
			medicList = MedicService.getInstance().retrieveByFilter(keyword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("medicList", medicList);
		request.getRequestDispatcher("modules/admin/retrieveMedic.jsp").forward(request, response);
	}
}
