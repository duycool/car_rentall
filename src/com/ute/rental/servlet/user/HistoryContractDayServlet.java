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

import com.ute.rental.bo.Bill;
import com.ute.rental.bo.Contract;
import com.ute.rental.bo.Contractday;
import com.ute.rental.dao.BillDAO;
import com.ute.rental.dao.ContractDAO;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.MethodDAO;

/**
 * Servlet implementation class HistoryContractDayServlet
 */
@WebServlet(name = "historyContractDay", urlPatterns = { "/historyContractDay" })
public class HistoryContractDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryContractDayServlet() {
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
		ContractDAO contractDAO = new ContractDAO();
		
		ArrayList<Contract> liscontract = contractDAO.getContractCustumer(custumerid);	
		
		ContractDayDAO contractDayDAO = new ContractDayDAO();
		ArrayList<Contractday> listcontractday  = contractDayDAO.getAllcontractDayJoin();
		
	//	ArrayList<Contract> listcontractCheck = new ArrayList<Contract>();
		ArrayList<Contractday> listcontractdayCheck = new ArrayList<Contractday>();		
		for(Contract contract : liscontract) {
			for(Contractday contractday : listcontractday) {
				if(contract.getContractid() == contractday.getContractid()) {
					String hireday = MethodDAO.ParseDateInDatabase(contractday.getDayhire());
					String payday = MethodDAO.ParseDateInDatabase(contractday.getPayday());				
					contractday.setDayhire(hireday);
					contractday.setPayday(payday);
					listcontractdayCheck.add(contractday);
				}
			}
		}			
		request.setAttribute("listcontractday", listcontractdayCheck);		
		RequestDispatcher dispatcher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/historyDay.jsp");
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
