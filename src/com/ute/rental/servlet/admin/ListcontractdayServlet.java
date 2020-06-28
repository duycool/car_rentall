package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Contractday;
import com.ute.rental.bo.Staff;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.StaffDAO;

/**
 * Servlet implementation class ListcontractdayServlet
 */
@WebServlet(name = "listcontractday", urlPatterns = { "/listcontractday" })
public class ListcontractdayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListcontractdayServlet() {
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
		String status = request.getParameter("status");
		ContractDayDAO contractDayDAO  = new ContractDayDAO();
		StaffDAO dao = new StaffDAO();
		ArrayList<Contractday> listContractday = MethodDAO.listContractdayParse(contractDayDAO.getAllcontractDayJoin(status));	
		ArrayList<Staff> lisStaff  = dao.getAllStaffByWork(work);
		if(MethodDAO.checkStatusContractDay(listContractday)) {
			request.setAttribute("listContractday", listContractday);
			request.setAttribute("lisStaff", lisStaff);
			RequestDispatcher dispatcher =
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listcontractday.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("listContractday", listContractday);
			request.setAttribute("lisStaff", lisStaff);
			RequestDispatcher dispatcher =
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listcontractday.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
