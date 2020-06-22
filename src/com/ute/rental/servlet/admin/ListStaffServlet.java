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

/**
 * Servlet implementation class ListStaffServlet
 */
@WebServlet(name = "listStaff", urlPatterns = { "/listStaff" })
public class ListStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String work = request.getParameter("work");
		StaffDAO dao = new StaffDAO();
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
