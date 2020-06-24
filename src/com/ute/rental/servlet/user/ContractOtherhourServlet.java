package com.ute.rental.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.ContractHour;
import com.ute.rental.dao.ContractHourDAO;

/**
 * Servlet implementation class ContractOtherhourServlet
 */
@WebServlet(name = "contractOtherhour", urlPatterns = { "/contractOtherhour" })
public class ContractOtherhourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractOtherhourServlet() {
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
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String phonenumber =  request.getParameter("phone");
		int deposit = Integer.parseInt(request.getParameter("deposit"));
		ContractHour contractHour = (ContractHour) session.getAttribute("contractHour");
		contractHour.setAdressDelivery(address);
		contractHour.setPhoneNumber(phonenumber);
		contractHour.setName(name);
		contractHour.setDeposit(deposit);
		ContractHourDAO contractHourDAO = new ContractHourDAO();
		contractHourDAO.AddContractHourOtherAddress(contractHour);
		String result = "Đăng ký thành công !";
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = 
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/ResultSuccess.jsp");
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
