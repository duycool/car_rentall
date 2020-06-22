package com.ute.rental.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.ContractHour;
import com.ute.rental.dao.ContractHourDAO;
import com.ute.rental.dao.MethodDAO;

/**
 * Servlet implementation class HistoryContractHourServlet
 */
@WebServlet(name = "historyContractHour", urlPatterns = { "/historyContractHour" })
public class HistoryContractHourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryContractHourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int custumerid = (int) session.getAttribute("custumerid");
		
		ContractHourDAO contractHourDAO = new ContractHourDAO();
		ArrayList<ContractHour> lisContractHour = MethodDAO.listContracthouParse(contractHourDAO.getAllcontractHourJoin(custumerid));			
		request.setAttribute("lisContractHour", lisContractHour);
		RequestDispatcher dispatcher =
					this.getServletContext().getRequestDispatcher("");
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
