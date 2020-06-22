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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.ManufacturerDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.SpeciesCarDAO;
import com.ute.rental.bo.*;
/**
 * Servlet implementation class CreateCarServlet
 */
@WebServlet(name = "createcar", urlPatterns = { "/createcar" })
@MultipartConfig(fileSizeThreshold = 1024 *1024*2,
maxFileSize = 1024 *1024*10,
maxRequestSize = 1024 *1024*50)
public class CreateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ManufacturerDAO manufacturerDAO = new ManufacturerDAO();	
		ArrayList<ManufacturerCar> listsmanu = manufacturerDAO.getAllManufac();
			
		request.setAttribute("listsmanu", listsmanu);

		SpeciesCarDAO speciesCarDAO = new SpeciesCarDAO();	
		ArrayList<SpeciesCar> listspecies = MethodDAO.listSpecies(speciesCarDAO.getAllSpecies());
		
		request.setAttribute("listspecies", listspecies);
		
		RequestDispatcher dispatcher =
				 this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/createCar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Part part =  request.getPart("uploadFile");
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\Laptop88\\git\\Carrental\\car_rentall\\WebContent\\images" +  File.separator + fileName;
	
		File fileSaveDir = new File(savePath);
		part.write(savePath+ File.separator);
		String namecar = request.getParameter("nameproduct");
		String speciesIdStr = request.getParameter("species");
		int speciesId = Integer.parseInt(speciesIdStr);
		String manufactIdStr = request.getParameter("manufact");
		int manufactId = Integer.parseInt(manufactIdStr);
		String quantityStr = request.getParameter("quantity");
		String still_existStr = request.getParameter("quantity");
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
		String seatnumber = request.getParameter("seatnumber");	
				
		Car car = new Car();
		car.setSpeciesID(speciesId);
		car.setManufacID(manufactId);
		car.setNameCar(namecar);
		car.setQuantity(quantity);
		car.setStill_exist(still_exist);
		car.setAvatar(fileName);
		car.setAvatar_sv(savePath);
		car.setPrice(price);
		car.setPricehour(pricehour);
		car.setStatus(status);
		car.setColor(color);
		car.setOunce(ounce);
		car.setChassisnumber(chassis);
		car.setSeatnumber(seatnumber);
		
		CarDAO dao = new CarDAO();
		dao.AddCar(car);
		response.sendRedirect(request.getContextPath() + "/listCaradmin");	
	}catch (Exception e) {
		String absurd = "absurd!";
		request.setAttribute("absurd",absurd);
		response.sendRedirect(request.getContextPath() + "/createcar");
	}
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
