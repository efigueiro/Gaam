package com.gaam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gaam.model.dao.MedicDao;
import com.gaam.model.entity.Category;
import com.gaam.model.entity.InsuranceCompany;
import com.gaam.model.entity.Medic;
import com.gaam.model.entity.Role;
import com.gaam.model.entity.User;
import com.gaam.model.service.CategoryService;
import com.gaam.model.service.InsuranceCompanyService;
import com.gaam.model.service.MedicService;
import com.gaam.model.service.UserService;
import com.gaam.util.Msg;

/**
 * Servlet implementation class CreateCustomerController
 */
@WebServlet("/createMedic")
public class CreateMedicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMedicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		boolean isOk = false;
		
		User user = new User();
		Medic medic = new Medic();
		Role role = new Role();
		
		// User
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String status = (String) request.getParameter("status");
		
		// Medic
		String name = (String) request.getParameter("name");
		String phone = (String) request.getParameter("phone");
		String address = (String) request.getParameter("address");
		String crm = (String) request.getParameter("crm");
		String observation = (String) request.getParameter("observation");
		
		// Categorie and insurance company lists
		String[] categoryList = request.getParameterValues("category");  
		String[] insuranceCompanyList = request.getParameterValues("insuranceCompany"); 
				
		// Fields validation
		if(StringUtils.isEmpty(email) || StringUtils.isEmpty(name) || StringUtils.isEmpty(crm) || StringUtils.isEmpty(password) || categoryList == null || insuranceCompanyList == null) {
			message = Msg.getProperty("message.user.mandatory.fields");
			isOk = false;
		} else {
			isOk = true;
		}
		
		// User validation
		if(isOk) {
			try {
				if(UserService.getInstance().isValidEMail(email)){
					isOk = true;
				} else {
					message = Msg.getProperty("message.email.exist");
					isOk = false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = e.getMessage();
			}
		}
		
		// Crm validation
		if(isOk) {
			try {
				if(MedicService.getInstance().isValidCrm(crm)){
					isOk = true;
				} else {
					isOk = false;
					message = Msg.getProperty("message.crm.exist");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		// Retrieve role
		/*if(isOk){
			try {
				role = RoleService.getInstance().retrieveById(intRole);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		// Create user
		if(isOk) {
			// remove after
			status = "active";
			user.setEmail(email);
			user.setPassword(password);
			user.setRole("medico");
			user.setStatus(status);
			try {
				message = UserService.getInstance().createUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Retrieve user by email
		if(isOk) {
			try {
				user = UserService.getInstance().retrieveByEmail(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Set medic for dont lose data on screen
		medic.setAddress(address);
		medic.setCrm(crm);
		medic.setName(name);
		medic.setObservation(observation);
		medic.setPhone(phone);
		medic.setUser(user);
		
		// Create medic
		if(isOk) {
			try {
				message = MedicService.getInstance().create(medic);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isOk = false;
			}
		}
		
		// Loading medic created before
		if(isOk) {
			try {
				medic = MedicService.getInstance().retrieveByCrm(crm);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = e.getMessage();
			}
		}
		
		// Insert into medic_category table
		if(isOk) {
			for(int i = 0; i < categoryList.length; i++) {
				try {
					MedicService.getInstance().insertMedicCategory(medic.getMedicId(), categoryList[i]);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					message = e.getMessage();
				}
			}
		}
		

		// Insert into medic_insuranceCompany table
		if(isOk) {
			for(int i = 0; i < insuranceCompanyList.length; i++) {
				try {
					MedicService.getInstance().insertMedicInsuranceCompany(medic.getMedicId(), insuranceCompanyList[i]);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					message = e.getMessage();
				}
			}
		}		
		
		// Problema de foward para cada role deve ser resolvido pegando o usuário da sessão com sua role.
		request.setAttribute("user", user);
		request.setAttribute("medic", medic);
		request.setAttribute("message", message);
		request.getRequestDispatcher("modules/admin/createMedic.jsp").forward(request, response);
		
	}

}
