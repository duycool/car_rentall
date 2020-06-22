package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.swing.internal.plaf.basic.resources.basic;
import com.ute.rental.bo.Car;
import com.ute.rental.bo.ManufacturerCar;
import com.ute.rental.bo.Promotion;
import com.ute.rental.bo.PromotionDetails;
import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.ManufacturerDAO;
import com.ute.rental.dao.PromotionDetailsDAO;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class AddPromotionServlet
 */
@WebServlet(name = "addPromotion", urlPatterns = { "/addPromotion" })
public class AddPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private CarDAO carDAO;

	@Override
	public void init() throws ServletException{
		carDAO  = new CarDAO();
		super.init();
	}
	
	
	
    public AddPromotionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");						
		int quantity = 1;
		int carid = Integer.parseInt(request.getParameter("id_car"));
		if(checklist(carid)) {			
			SpeciesCarDAO speciesCarDAO = new SpeciesCarDAO();
			ManufacturerDAO manufacdao = new ManufacturerDAO();
			//carid  = ;
			Car car = carDAO.getCar(carid);
			SpeciesCar speciesCar = speciesCarDAO.getSpecies(car.getSpeciesID());
			ManufacturerCar maCar  = manufacdao.getManufac(car.getManufacID());				
			if(checklist(carid)) {																			
				if(car != null && speciesCar != null && maCar != null) {
					if(request.getParameter("quantity") != null) {
						quantity = Integer.parseInt(request.getParameter("quantity"));
					}			
					HttpSession session = request.getSession();
					if(session.getAttribute("promotion")==null) {
						Promotion promotion =  new Promotion();
						List<PromotionDetails> listDetails = new ArrayList<PromotionDetails>();
						PromotionDetails promotionDetails = new PromotionDetails();
						promotionDetails.setQuantity(quantity);
						promotionDetails.setCar(car);
						promotionDetails.setSpeciesCar(speciesCar);
						promotionDetails.setManufacturerCar(maCar);
						listDetails.add(promotionDetails);
						promotion.setPromotionDetails(listDetails);
						session.setAttribute("promotion", promotion);				
					}else {
						Promotion promotion = (Promotion) session.getAttribute("promotion");
						List<PromotionDetails> lisDetails = promotion.getPromotionDetails();
						boolean check = false;
						for(PromotionDetails prDetails  : lisDetails) {
							if(prDetails.getCar().getId_car() == car.getId_car()) {
								prDetails.setQuantity(prDetails.getQuantity() + quantity);
								check = true;
							}
						}
						if(check == false) {
							PromotionDetails promotionDetails = new PromotionDetails();
							promotionDetails.setQuantity(quantity);
							promotionDetails.setCar(car);
							promotionDetails.setManufacturerCar(maCar);
							promotionDetails.setSpeciesCar(speciesCar);
							lisDetails.add(promotionDetails);
						}				
						session.setAttribute("promotion", promotion);					
					}
				}			
				response.sendRedirect(request.getContextPath() + "/listCaradmin");
			}else {				
				response.sendRedirect(request.getContextPath() + "/listCaradmin");
			}				
			}else {
				String message = "Xe này đã được thêm giảm giá";
				CarDAO dao = new CarDAO();
				request.setAttribute("message", message);
				ArrayList<Car> listcar = dao.getAllCar();			
				request.setAttribute("listcar",listcar);	
				RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listCarAdmin.jsp");
				dispatcher.forward(request, response);
			}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public boolean checklist(int carid) {
		PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
		ArrayList<PromotionDetails> listPromotionDetails = proDetailsDAO.getAllPromotionDetails();
		for(PromotionDetails promotionDetails : listPromotionDetails) {
			if(promotionDetails.getId_car() == carid) {
				return false;
			}
		}
		return true;
	}
}
