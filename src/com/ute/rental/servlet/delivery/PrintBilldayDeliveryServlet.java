package com.ute.rental.servlet.delivery;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Contractday;
import com.ute.rental.bo.Violate;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.ViolateDAO;

/**
 * Servlet implementation class PrintBilldayDeliveryServlet
 */
@WebServlet(name = "printBilldayDelivery", urlPatterns = { "/printBilldayDelivery" })
public class PrintBilldayDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintBilldayDeliveryServlet() {
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
		ContractDayDAO contractDayDAO = new ContractDayDAO();
		Contractday contractday =MethodDAO.ContractdayParse(contractDayDAO.getcontractDayBill(contractid));	
		request.setAttribute("rest", contractday.getTotalMoney() - contractday.getDeposit());
		request.setAttribute("contractday",contractday);
		RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/pritfBillDay.jsp");
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
