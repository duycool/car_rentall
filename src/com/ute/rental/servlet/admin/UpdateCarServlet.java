package com.ute.rental.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.ManufacturerCar;
import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.ManufacturerDAO;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class UpdateCarServlet
 */
@WebServlet(name = "updateCar", urlPatterns = { "/updateCar" })
@MultipartConfig(fileSizeThreshold = 1024 *1024*2,
maxFileSize = 1024 *1024*10,
maxRequestSize = 1024 *1024*50)
public class UpdateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idCarStr = request.getParameter("id_car");
		int idcar = Integer.parseInt(idCarStr);
		CarDAO dao = new CarDAO();
		Car car = dao.getCar(idcar);
		
		request.setAttribute("car", car);
		
		SpeciesCarDAO speciesCarDAO = new SpeciesCarDAO();
		SpeciesCar speciesCar = speciesCarDAO.getSpecies(car.getSpeciesID());
		request.setAttribute("speciesCar",speciesCar);
		ArrayList<SpeciesCar> listSpecies = speciesCarDAO.getAllSpecies();
		request.setAttribute("listSpecies", listSpecies);
		
		ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
		ManufacturerCar maCar = manufacturerDAO.getManufac(car.getManufacID());
		request.setAttribute("maCar",maCar);
		ArrayList<ManufacturerCar> listmanu = manufacturerDAO.getAllManufac();
		request.setAttribute("listmanu", listmanu);
	
		RequestDispatcher dispatcher 
						= this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/updateCar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("idproduct");
		int id = Integer.parseInt(idStr);
		String namecar = request.getParameter("nameproduct");
		String quantityStr = request.getParameter("acmount");
		String still_existStr = request.getParameter("stillExist");
		String priceStr = request.getParameter("price");
		String pricehourStr = request.getParameter("pricehour");
		int still_exist = Integer.parseInt(still_existStr);
		int quantity = Integer.parseInt(quantityStr);
		int price = Integer.parseInt(priceStr);
		int pricehour = Integer.parseInt(pricehourStr);
		String status = request.getParameter("status");
		String color = request.getParameter("color");
		String ounce = request.getParameter("ounce");
		String chassis = request.getParameter("chassis");
		/*String speciesIdStr = request.getParameter("species");
		String manuIdStr = request.getParameter("manufact");
		int speciesId = Integer.parseInt(speciesIdStr);
		int manuid = Integer.parseInt(manuIdStr);*/
		
			Car car = new Car();
			car.setId_car(id);	
			car.setNameCar(namecar);
			car.setQuantity(quantity);
			car.setStill_exist(still_exist);		
			car.setPrice(price);
			car.setPricehour(pricehour);
			car.setStatus(status);
			car.setColor(color);
			car.setOunce(ounce);
			car.setChassisnumber(chassis);
			
			
			CarDAO dao = new CarDAO();
			dao.updateCar(car);
			
			/*Car car1 = new Car();
			car1.setId_car(id);
			car1.setSpeciesID(speciesId);
			dao.updateCarSpecies(car1);*/
			
			/*Car car2 = new Car();
			car2.setId_car(id);
			car2.setManufacID(manuid);
			dao.updateCarManu(car2);*/
			//get car by id
			car = dao.getCar(id);
			request.setAttribute("car", car);
			
			
			
			SpeciesCarDAO spcDao = new SpeciesCarDAO();
			
			
			//getSpecies by id request
			 SpeciesCar speciesCar = spcDao.getSpecies(car.getSpeciesID());
			request.setAttribute("speciesCar", speciesCar);
			
			ManufacturerDAO maDao = new ManufacturerDAO();
			  
		
			//getManufacturer by id request
			ManufacturerCar maCar = maDao.getManufac(car.getManufacID());
			request.setAttribute("maCar", maCar);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listCarIdAdmin.jsp");
			dispatcher.forward(request, response);	
	
	}
}


