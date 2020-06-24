package com.ute.rental.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Contractday;
import com.ute.rental.dao.ContractDayDAO;

/**
 * Servlet implementation class ContractOtherdayservlet
 */
@WebServlet(name = "contractOtherday", urlPatterns = { "/contractOtherday" })
public class ContractOtherdayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractOtherdayservlet() {
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
		Contractday contractday = (Contractday) session.getAttribute("contractday");
		contractday.setAdressDelivery(address);
		contractday.setPhoneNumber(phonenumber);
		contractday.setName(name);
		ContractDayDAO contractDayDAO = new ContractDayDAO();
		contractDayDAO.AddContractDayOtherAddress(contractday);		
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
