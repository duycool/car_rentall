package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Staff;
import com.ute.rental.bo.Users;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.StaffDAO;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class CreateStaffServlet
 */
@WebServlet(name = "createStaff", urlPatterns = { "/createStaff" })
public class CreateStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/createStaff.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String namestaff = request.getParameter("namestaff");
		String address  = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password =MethodDAO.hashPass(request.getParameter("passwords"));
		String work = request.getParameter("work");
		
		
		String m = "Username available!!";
		UserDAO userdao = new UserDAO();
		
		ArrayList<Users> list = userdao.getAllUsers();
		for(Users users : list) {
			if(users.getUsername().equals(email)) {
				request.setAttribute("mess",m);
				RequestDispatcher dispatcher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/createStaff.jsp");
				dispatcher.forward(request, response);
				return;
			}
			}
//		Users users = new Users();
//		users.setUsername(username);
//		users.setPasswords(password);
//		users.setRoles(work);
		
		Staff staff = new Staff();
		staff.setFullname(namestaff);
		staff.setAddress(address);
		staff.setPhone(phone);
		staff.setWorks(work);
		staff.setEmail(email);
		staff.setPasswords(password);
		staff.setRoles(work);
		
		
		StaffDAO dao = new StaffDAO();
		dao.AddStaff(staff);
		response.sendRedirect(request.getContextPath() + "/homeadmin");
	}

}
