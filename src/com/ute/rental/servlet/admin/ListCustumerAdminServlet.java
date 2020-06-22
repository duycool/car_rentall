package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Custumer;
import com.ute.rental.dao.CustumerDAO;

/**
 * Servlet implementation class ListCustumerAdminServlet
 */
@WebServlet(name = "listCustumerAdmin", urlPatterns = { "/listCustumerAdmin" })
public class ListCustumerAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustumerAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		CustumerDAO dao = new CustumerDAO();
		ArrayList<Custumer> listcustumer = dao.getAllCustumer();
		request.setAttribute("listcustumer", listcustumer);
		RequestDispatcher dispatcher = 
								this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listCustumerAdmin.jsp");
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
