package com.ute.rental.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Custumer;
import com.ute.rental.bo.Users;
import com.ute.rental.dao.CustumerDAO;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class CustumerIdAdminServlet
 */
@WebServlet(name = "custumerIdAdmin", urlPatterns = { "/custumerIdAdmin" })
public class CustumerIdAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustumerIdAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int userid = Integer.parseInt(request.getParameter("userid"));
		CustumerDAO custumerDAO = new CustumerDAO();
		Custumer custumer = custumerDAO.getCustumer(userid);
		request.setAttribute("custumer", custumer);
		
		UserDAO userDAO = new UserDAO();
		Users user = userDAO.getUser(userid);
		request.setAttribute("user", user);
		
		
		RequestDispatcher dispatcher =
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/custumerIdAdmin.jsp");
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
