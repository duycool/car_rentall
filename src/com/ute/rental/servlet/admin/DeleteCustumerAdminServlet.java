package com.ute.rental.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Custumer;
import com.ute.rental.dao.CustumerDAO;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class DeleteCustumerAdminServlet
 */
@WebServlet(name = "deleteCustumerAdmin", urlPatterns = { "/deleteCustumerAdmin" })
public class DeleteCustumerAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustumerAdminServlet() {
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
		CustumerDAO dao = new CustumerDAO();		
		Custumer custumer = dao.getCustumer(userid);
		dao.deleteCustumer(custumer.getCustumerid());
		
		UserDAO userDAO = new UserDAO();
		userDAO.deleteUsers(userid);
		
		response.sendRedirect(request.getContextPath() + "/listCustumerAdmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
