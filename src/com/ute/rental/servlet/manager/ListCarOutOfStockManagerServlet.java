package com.ute.rental.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Car;
import com.ute.rental.dao.CarDAO;

/**
 * Servlet implementation class ListCarOutOfStockManagerServlet
 */
@WebServlet(name = "listCarOutOfStockManager", urlPatterns = { "/listCarOutOfStockManager" })
public class ListCarOutOfStockManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCarOutOfStockManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDAO dao = new CarDAO();
		ArrayList<Car> listcar = dao.getAllCarOutOfStock();			
		request.setAttribute("listcar",listcar);	
		RequestDispatcher dispatcher =
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/listCarManager.jsp");
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
