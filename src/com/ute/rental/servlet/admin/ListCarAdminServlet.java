package com.ute.rental.servlet.admin;

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
import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.ManufacturerDAO;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class ListCarAdminServlet
 */
@WebServlet(name = "listCaradmin", urlPatterns = { "/listCaradmin" })
public class ListCarAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCarAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDAO dao = new CarDAO();
		ArrayList<Car> listcar = dao.getAllCar();			
		request.setAttribute("listcar",listcar);	
		RequestDispatcher dispatcher =
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listCarAdmin.jsp");
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
