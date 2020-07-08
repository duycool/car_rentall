package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.ContractHour;
import com.ute.rental.bo.Staff;
import com.ute.rental.dao.ContractHourDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.StaffDAO;

/**
 * Servlet implementation class ListcontracthourServlet
 */
@WebServlet(name = "listcontracthour", urlPatterns = { "/listcontracthour" })
public class ListcontracthourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListcontracthourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String work = "staffdelivery";
		String action = "normal";
		String status = request.getParameter("status");
		ContractHourDAO contractHourDAO  = new ContractHourDAO();
		StaffDAO dao = new StaffDAO();
		ArrayList<ContractHour> listcontracthour = MethodDAO.listContracthouParse(contractHourDAO.getAllcontractHourJoin(status));	
		ArrayList<Staff> lisStaff  = dao.getAllStaffByWorkAndAction(work,action);
		request.setAttribute("listcontracthour", listcontracthour);
		request.setAttribute("lisStaff", lisStaff);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listcontracthour.jsp");
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
