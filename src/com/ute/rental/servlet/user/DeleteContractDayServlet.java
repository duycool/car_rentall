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
import com.ute.rental.bo.Car;
import com.ute.rental.bo.Contract;
import com.ute.rental.bo.Contractday;
import com.ute.rental.dao.BillDAO;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.ContractDAO;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.SpeciesCarDAO;
import com.ute.rental.dao.SpeciesContractDAO;

/**
 * Servlet implementation class DeleteContractDayServlet
 */
@WebServlet(name = "deleteContractDay", urlPatterns = { "/deleteContractDay" })
public class DeleteContractDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContractDayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contractid = Integer.parseInt(request.getParameter("id_contract"));
		
		ContractDAO contractDAO = new ContractDAO();
		Contract contract = contractDAO.getContract(contractid);
		
		BillDAO billDAO = new BillDAO();
		ContractDayDAO contractDayDAO = new  ContractDayDAO();
	
		Bill bill = billDAO.getBill(contractid);
		
		if(contract.getStatus().equals("newRent") && bill.getStatus().equals("newRent")) {			
			contractDAO.deleteContractDay(contractid);
			response.sendRedirect(request.getContextPath() + "/historyContractDay");		
		}else if(contract.getStatus().equals("AlreadyPaid") && bill.getStatus().equals("AlreadyPaid")) {
			contractDAO.deleteContractDay(contractid);
			response.sendRedirect(request.getContextPath() + "/historyContractDay");	
		}else {
			String notification = "Xe đã được duyệt nên bạn không thể hủy được !!!";
			request.setAttribute("notification", notification);
			HttpSession session = request.getSession();
			int custumerid = (int) session.getAttribute("custumerid");						
			ArrayList<Contract> liscontract = contractDAO.getContractCustumer(custumerid);							
			ArrayList<Contractday> listcontractday  = contractDayDAO.getAllcontractDayJoin();				
			ArrayList<Contractday> listcontractdayCheck = new ArrayList<Contractday>();		
			for(Contract contract1 : liscontract) {
				for(Contractday contractday : listcontractday) {
					if(contract1.getContractid() == contractday.getContractid()) {					
						listcontractdayCheck.add(contractday);
					}
				}
			}			
			request.setAttribute("listcontractday", listcontractdayCheck);		
			RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/historyDay.jsp");
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
