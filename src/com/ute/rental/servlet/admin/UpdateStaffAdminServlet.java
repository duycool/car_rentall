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
import com.ute.rental.dao.StaffDAO;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class UpdateStaffAdminServlet
 */
@WebServlet(name = "updateStaffAdmin", urlPatterns = { "/updateStaffAdmin" })
public class UpdateStaffAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String useridStr = request.getParameter("userid");
		int userid = Integer.parseInt(useridStr);
		StaffDAO dao = new StaffDAO();
		Staff staff = dao.getStaff(userid);
		request.setAttribute("staff",staff);
		
		UserDAO userDAO = new UserDAO();
		Users user = userDAO.getUser(staff.getUserid());
		request.setAttribute("user",user);
		
		
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/updateStaffAdmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idstaffStr = request.getParameter("idstaff");
		String useridStr = request.getParameter("userid");
		String staffname = request.getParameter("staffname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		int idstaff = Integer.parseInt(idstaffStr);
		int userid = Integer.parseInt(useridStr);
		
		
		Staff staff = new Staff();
		staff.setStaffid(idstaff);
		staff.setFullname(staffname);
		staff.setAddress(address);
		staff.setPhone(phone);
		
		StaffDAO dao = new StaffDAO();
		dao.updateStaff(staff);
		
		staff = dao.getStaff(userid);
		request.setAttribute("staff", staff);
		
		
		UserDAO uDao = new UserDAO();
		Users user = uDao.getUser(userid);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listStaffIdAdmin.jsp");
		dispatcher.forward(request, response);
	}

}
