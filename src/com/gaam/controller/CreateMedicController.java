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
		InsuranceCompany insuranceCompany = new InsuranceCompany();
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
		String strCategory = (String) request.getParameter("category");
		String strInsuranceCompany = (String) request.getParameter("insuranceCompany");
		String observation = (String) request.getParameter("observation");
		
		// Categories
		String[] categoryList = request.getParameterValues("category");  
				
		// Fields validation
		if(StringUtils.isEmpty(email) || StringUtils.isEmpty(name) || StringUtils.isEmpty(crm) || StringUtils.isEmpty(password)) {
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
		
		/*// Retrieve insurance company
		if(isOk) {
			try {
				insuranceCompany = InsuranceCompanyService.getInstance().retrieveById(Integer.parseInt(insuranceCompanyId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isOk = false;
			}
		}*/
		
		// Buscando category
		Category category = new Category();
		category.setCategoryId(Integer.parseInt(strCategory));
		try {
			category = CategoryService.getInstance().retrieveById(category.getCategoryId());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Set customer for dont lose data on screen
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
		
		// Insert into medic_insurance_company table
		try {
			medic = MedicService.getInstance().retrieveByCrm(medic.getCrm());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			MedicDao.getInstance().medicInsuranceCompany(medic.getMedicId(), insuranceCompany.getInsuranceCompanyId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Problema de foward para cada role deve ser resolvido pegando o usuário da sessão com sua role.
		request.setAttribute("user", user);
		request.setAttribute("medic", medic);
		request.setAttribute("message", message);
		request.getRequestDispatcher("modules/admin/createMedic.jsp").forward(request, response);
		
	}

}
