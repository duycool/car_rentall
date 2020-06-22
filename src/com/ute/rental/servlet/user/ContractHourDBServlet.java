package com.ute.rental.servlet.user;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

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
 * Servlet implementation class ContractHourDBServlet
 */
@WebServlet(name = "contractHourDB", urlPatterns = { "/contractHourDB" })
public class ContractHourDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractHourDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		int deposit  = Integer.parseInt(request.getParameter("deposit"));
		if(deposit > 0) {
			String result = "Đăng ký thành công";
			request.setAttribute("result", result);
			HttpSession session = request.getSession();
			ContractHour contractHour = (ContractHour) session.getAttribute("contractHour");
			contractHour.setDeposit(deposit);
			ContractHourDAO dao = new ContractHourDAO();
			dao.AddContractHour(contractHour);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/ResultSuccess.jsp");
			dispatcher.forward(request, response);	
			
		}
	}

}
