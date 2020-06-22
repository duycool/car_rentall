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
 * Servlet implementation class UpdateWorkAdminServlet
 */
@WebServlet(name = "updateWorkAdmin", urlPatterns = { "/updateWorkAdmin" })
public class UpdateWorkAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWorkAdminServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idstaffStr = request.getParameter("idstaff");
		String useridStr = request.getParameter("userid");
		String work = request.getParameter("work");
		
		int idstaff = Integer.parseInt(idstaffStr);
		int userid = Integer.parseInt(useridStr);
		
	
		Users user = new Users();
		user.setUserid(userid);
		user.setRoles(work);
		
		
		UserDAO dao = new UserDAO();
		dao.updateUserByRoles(user);
		
		Staff staff = new Staff();
		staff.setStaffid(idstaff);
		staff.setWorks(work);
		
		StaffDAO staffDAO = new StaffDAO();
		staffDAO.updateStaffByWork(staff);
		
		staff = staffDAO.getStaff(userid);
		request.setAttribute("staff", staff);
		
		
		
		user = dao.getUser(userid);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listStaffIdAdmin.jsp");
		dispatcher.forward(request, response);
	}

}
