package com.ute.rental.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.StaffDAO;
import com.ute.rental.bo.*;

/**
 * Servlet implementation class ListcontractdayManagerServlet
 */
@WebServlet(name = "listcontractdayManager", urlPatterns = { "/listcontractdayManager" })
public class ListcontractdayManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListcontractdayManagerServlet() {
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
		ContractDayDAO contractDayDAO  = new ContractDayDAO();
		StaffDAO dao = new StaffDAO();
		ArrayList<Contractday> listContractday = MethodDAO.listContractdayParse(contractDayDAO.getAllcontractDayJoin(status));	
		ArrayList<Staff> lisStaff  = dao.getAllStaffByWorkAndAction(work,action);
		request.setAttribute("listContractday", listContractday);
		request.setAttribute("lisStaff", lisStaff);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/listcontractdayManager.jsp");
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
