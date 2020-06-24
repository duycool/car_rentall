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
import com.ute.rental.bo.ContractHour;
import com.ute.rental.bo.OtherAddress;
import com.ute.rental.dao.BillDAO;
import com.ute.rental.dao.ContractDAO;
import com.ute.rental.dao.ContractHourDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.OtherAddressDAO;

/**
 * Servlet implementation class DeleteContracthourServlet
 */
@WebServlet(name = "deleteContracthour", urlPatterns = { "/deleteContracthour" })
public class DeleteContracthourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContracthourServlet() {
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
		ContractHourDAO contractHourDAO = new  ContractHourDAO();
	
		Bill bill = billDAO.getBill(contractid);
		OtherAddressDAO addressDAO  = new OtherAddressDAO();
		OtherAddress otherAddress = addressDAO.getOtherAddress(contractid);
		if(contract.getStatus().equals("newRent") && bill.getStatus().equals("newRent")) {	
			if(otherAddress == null) {
				contractDAO.deleteContracthour(contractid);
				response.sendRedirect(request.getContextPath() + "/historyContractHour");
			}else {
				contractDAO.deleteContracthourOtherAddress(contractid);
				response.sendRedirect(request.getContextPath() + "/historyContractHour");
			}					
		}else if(contract.getStatus().equals("AlreadyPaid") && bill.getStatus().equals("AlreadyPaid")) {
			if(otherAddress == null) {
				contractDAO.deleteContracthour(contractid);
				response.sendRedirect(request.getContextPath() + "/historyContractHour");
			}else {
				contractDAO.deleteContracthourOtherAddress(contractid);
				response.sendRedirect(request.getContextPath() + "/historyContractHour");
			}
		}else {
			String notification = "Xe đã được duyệt nên bạn không thể hủy được !!!";
			request.setAttribute("notification", notification);
			HttpSession session = request.getSession();
			int custumerid = (int) session.getAttribute("custumerid");												
			ArrayList<ContractHour> lisContractHour  = MethodDAO.listContracthouParse(contractHourDAO.getAllcontractHourJoin(custumerid));							
			request.setAttribute("lisContractHour", lisContractHour);		
			RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/historyhour.jsp");
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
