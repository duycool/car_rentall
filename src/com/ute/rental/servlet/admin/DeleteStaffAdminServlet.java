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
import com.ute.rental.dao.StaffDAO;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class DeleteStaffAdminServlet
 */
@WebServlet(name = "deleteStaffAdmin", urlPatterns = { "/deleteStaffAdmin" })
public class DeleteStaffAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStaffAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String useridString = request.getParameter("userid");
		int userid = Integer.parseInt(useridString);
		String work = request.getParameter("works");
		StaffDAO dao = new StaffDAO();
		
		Staff staff = dao.getStaff(userid);
		dao.deleteStaff(staff.getStaffid());
		
		UserDAO userDao = new UserDAO();
		userDao.deleteUsers(userid);
		
		ArrayList<Staff> liststaff = dao.getAllStaffByWork(work);
		request.setAttribute("liststaff", liststaff);
		RequestDispatcher dispatcher 
							= this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listStaffAdmin.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
