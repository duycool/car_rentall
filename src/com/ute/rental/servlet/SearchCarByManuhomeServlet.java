package com.ute.rental.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.ManufacturerCar;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.ManufacturerDAO;

/**
 * Servlet implementation class SearchCarByManuhomeServlet
 */
@WebServlet(name = "searchCarByManuhome", urlPatterns = { "/searchCarByManuhome" })
public class SearchCarByManuhomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCarByManuhomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String manu = request.getParameter("manu");
		
		ManufacturerDAO dao = new ManufacturerDAO();
		ManufacturerCar maCar = dao.getNameManufac(manu);
		
		
		CarDAO carDAO = new CarDAO();
		ArrayList<Car> listcar = carDAO.getManuCar(maCar.getManuFacID());
		request.setAttribute("listcar", listcar);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/homepage.jsp");
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
