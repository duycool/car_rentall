package com.ute.rental.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Staff;
import com.ute.rental.bo.Users;
import com.ute.rental.dao.StaffDAO;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class UpdateUserStaffAdminServlet
 */
@WebServlet(name = "updateUserStaffAdmin", urlPatterns = { "/updateUserStaffAdmin" })
public class UpdateUserStaffAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserStaffAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		String username = request.getParameter("username");
		String passwords = request.getParameter("username");
		
		Users user = new Users();
		user.setUserid(userid);
		user.setUsername(username);
		user.setPasswords(passwords);
		
		UserDAO dao = new UserDAO();
		dao.updateUserByUserNameAndPass(user);
		
		
		
		
		StaffDAO  staffDAO = new StaffDAO();
		Staff staff = staffDAO.getStaff(userid);
		request.setAttribute("staff", staff);
		
		
		
		user = dao.getUser(userid);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listStaffIdAdmin.jsp");
		dispatcher.forward(request, response);
		
		doGet(request, response);
	}

}
