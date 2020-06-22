package com.ute.rental.servlet.admin;

import java.io.File;
import java.io.IOException;

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
 * Servlet implementation class UpdateImagesServlet
 */
@WebServlet(name = "updateImages", urlPatterns = { "/updateImages" })
@MultipartConfig(fileSizeThreshold = 1024 *1024*2,
maxFileSize = 1024 *1024*10,
maxRequestSize = 1024 *1024*50)
public class UpdateImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateImagesServlet() {
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
		Part part =  request.getPart("uploadFile");
		
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\Laptop88\\git\\Carrental\\car_rentall\\WebContent\\images" +  File.separator + fileName;
		File fileSaveDir = new File(savePath);
		part.write(savePath+ File.separator);
		
		Car car = new Car();
		car.setId_car(id);
		car.setAvatar(fileName);
		car.setAvatar_sv(savePath);
		
		CarDAO dao = new CarDAO();
		dao.updateCarPicture(car);
		car = dao.getCar(id);
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
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
}
}
