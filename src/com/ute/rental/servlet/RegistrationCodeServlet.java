package com.ute.rental.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Custumer;
import com.ute.rental.bo.Users;
import com.ute.rental.dao.CustumerDAO;
import com.ute.rental.dao.Random;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class RegistrationCodeServlet
 */
@WebServlet(name = "registrationCode", urlPatterns = { "/registrationCode" })
public class RegistrationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		//request.setCharacterEncoding("UTF-8");
		//int cod = Random.ran();
		//String code1=String.valueOf(cod);
		String code = request.getParameter("codeinput");
		//String code1 = request.getParameter("code");
		String result = "Successfully!";
		HttpSession session = request.getSession();
		Custumer custumer = (Custumer) session.getAttribute("custumer");
		String codeSession = (String) session.getAttribute("content");
		if(codeSession.equals(code)) {			
			CustumerDAO custumerDAO = new CustumerDAO();
			custumerDAO.AddCustumer(custumer);
			request.setAttribute("result",result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/result.jsp");
			dispatcher.forward(request, response);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			result = "Incorrect Code !";	
			//session.setAttribute("users", users);
			//session.setAttribute("custumer", custumer);
			//request.setAttribute("content", code1);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/registrationCode.jsp");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}

}
