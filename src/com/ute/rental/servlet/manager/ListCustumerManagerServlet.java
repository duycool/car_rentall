package com.ute.rental.servlet.manager;

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
 * Servlet implementation class ListCustumerManagerServlet
 */
@WebServlet(name = "listCustumerManager", urlPatterns = { "/listCustumerManager" })
public class ListCustumerManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustumerManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustumerDAO dao = new CustumerDAO();
		ArrayList<Custumer> listcustumer = dao.getAllCustumerJoin();
		request.setAttribute("listcustumer", listcustumer);
		RequestDispatcher dispatcher = 
								this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/listCustumerManager.jsp");
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
