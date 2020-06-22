package com.ute.rental.servlet.admin;

import java.io.IOException;

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
 * Servlet implementation class ListCarIdAdminServlet
 */
@WebServlet(name = "listCarIdAdmin", urlPatterns = { "/listCarIdAdmin" })
public class ListCarIdAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCarIdAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id_car");
		int id = Integer.parseInt(idStr);
		
		CarDAO dao = new CarDAO();
		Car car = dao.getCar(id);
		request.setAttribute("car", car);
		
		SpeciesCarDAO spcDao = new SpeciesCarDAO();
		SpeciesCar speciesCar = spcDao.getSpecies(car.getSpeciesID());
		request.setAttribute("speciesCar", speciesCar);
		
		ManufacturerDAO maDao = new ManufacturerDAO();
		ManufacturerCar maCar = maDao.getManufac(car.getManufacID());
		request.setAttribute("maCar", maCar);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listCarIdAdmin.jsp");
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
