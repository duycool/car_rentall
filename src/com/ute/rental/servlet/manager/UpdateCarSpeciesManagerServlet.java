package com.ute.rental.servlet.manager;

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
 * Servlet implementation class UpdateCarSpeciesManagerServlet
 */
@WebServlet(name = "updateCarSpeciesManager", urlPatterns = { "/updateCarSpeciesManager" })
public class UpdateCarSpeciesManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarSpeciesManagerServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("idproduct");
		int id = Integer.parseInt(idStr);
		String speciesIdStr = request.getParameter("species");
		int speciesId = Integer.parseInt(speciesIdStr);
		Car car = new Car();
		car.setId_car(id);
		car.setSpeciesID(speciesId);
		
		CarDAO dao = new CarDAO();
		dao.updateCarSpecies(car);
		car = dao.getCar(id);
		request.setAttribute("car", car);
		
		SpeciesCarDAO spcDao = new SpeciesCarDAO();
		SpeciesCar speciesCar = spcDao.getSpecies(car.getSpeciesID());
		request.setAttribute("speciesCar", speciesCar);
		
		ManufacturerDAO maDao = new ManufacturerDAO();
		ManufacturerCar maCar = maDao.getManufac(car.getManufacID());
		request.setAttribute("maCar", maCar);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/listCaridManager.jsp");
		dispatcher.forward(request, response);
	}

}
