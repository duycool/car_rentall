package com.ute.rental.servlet.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.ContractHour;
import com.ute.rental.dao.ContractHourDAO;
import com.ute.rental.dao.MethodDAO;

/**
 * Servlet implementation class PrintBillhourManagerServlet
 */
@WebServlet(name = "printBillhourManager", urlPatterns = { "/printBillhourManager" })
public class PrintBillhourManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintBillhourManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int contractid  =  Integer.parseInt(request.getParameter("contractid"));
		ContractHourDAO contractHourDAO = new ContractHourDAO();
		ContractHour contractHour =MethodDAO.ContracthouParse(contractHourDAO.getcontractHourBill(contractid));	
		request.setAttribute("rest", contractHour.getTotalMoney() - contractHour.getDeposit());
		request.setAttribute("contractHour",contractHour);
		RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/printfBillHourManager.jsp");
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
