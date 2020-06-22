package com.ute.rental.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.Comment;
import com.ute.rental.bo.ManufacturerCar;
import com.ute.rental.bo.Promotion;
import com.ute.rental.bo.PromotionDetails;
import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.CommentDAO;
import com.ute.rental.dao.ManufacturerDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.PromotionDAO;
import com.ute.rental.dao.PromotionDetailsDAO;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet(name = "comment", urlPatterns = { "/comment" })
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int id_car = (int) session.getAttribute("id_car");
		int userid = (int) session.getAttribute("id_user");
		
		String fullname = (String) session.getAttribute("nameuser");
		String text = request.getParameter("textcomment");
		
		Comment comment = new Comment();
		comment.setId_car(id_car);
		comment.setIdUser(userid);
		comment.setNameuser(fullname);
		comment.setComment(text);
		
		CommentDAO cmdao = new CommentDAO();
		cmdao.insertComment(comment);
										
		PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
		PromotionDAO proDao = new PromotionDAO();				
		ArrayList<PromotionDetails> lisPromotionDetails = proDetailsDAO.getAllPromotionDetails();
		String name = "Giảm Giá : ";
		String vnd = "VNÐ";
		String giatheongay = "Giá Theo Ngày ||  ";
		String giatheogio = "Giá Theo Giờ || ";
		MethodDAO methodDAO = new MethodDAO();
		for(PromotionDetails details : lisPromotionDetails) {
			if(details.getId_car() == id_car) {
				Promotion promotion = proDao.getPromotion(details.getIdpromotion());
				request.setAttribute("promotion", promotion);
				String giabandau = "Giá Ban Ðầu : ";
				String giagiam = "Giá Sau Khi Giảm : ";
				String vndsale = "VNÐ";
				String giatheongaysale = "Giá Theo Ngày : ";
				String giatheogiosale = "Giá Theo Giờ : ";
																
				request.setAttribute("name", name);
				session.setAttribute("id_car", id_car);
				CarDAO dao = new CarDAO();
				Car car = dao.getCar(id_car);
				request.setAttribute("car", car);
				
				int price = car.getPrice();
				int pricehour = car.getPricehour();
				
				request.setAttribute("giabandau", giabandau);
				request.setAttribute("price", price);
				request.setAttribute("pricehour", pricehour);
				request.setAttribute("vndsale", vndsale);
				request.setAttribute("giatheongaysale", giatheongaysale);
				request.setAttribute("giatheogiosale", giatheogiosale);
				String title = promotion.getTitile();
				
				int priceSaleOff = methodDAO.moneySaleOff(title, price);
				int pricehourSaleOff = methodDAO.moneySaleOff(title, pricehour);
				
				request.setAttribute("giagiam", giagiam);
				request.setAttribute("priceSaleOff", priceSaleOff);
				request.setAttribute("pricehourSaleOff", pricehourSaleOff);
				
				session.setAttribute("priceSaleOff", priceSaleOff);
				session.setAttribute("pricehourSaleOff", pricehourSaleOff);
				
				SpeciesCarDAO spcDao = new SpeciesCarDAO();
				SpeciesCar speciesCar = spcDao.getSpecies(car.getSpeciesID());
				request.setAttribute("speciesCar", speciesCar);
				
				ManufacturerDAO maDao = new ManufacturerDAO();
				ManufacturerCar maCar = maDao.getManufac(car.getManufacID());
				request.setAttribute("maCar", maCar);
				
				CommentDAO cDao = new CommentDAO();
				ArrayList<Comment> listComment = cDao.getCommentById(id_car);
				request.setAttribute("listComment", listComment);
				
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/listCarId.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}		
		CarDAO dao = new CarDAO();
		Car car = dao.getCar(id_car);
		request.setAttribute("car", car);
		int  pricebt = car.getPrice();
		int  pricehourbt = car.getPricehour();
		
		request.setAttribute("vnd", vnd);
		request.setAttribute("pricebt", pricebt);
		request.setAttribute("pricehourbt", pricehourbt);
		request.setAttribute("giatheongay", giatheongay);
		request.setAttribute("giatheogio", giatheogio);
		
		SpeciesCarDAO spcDao = new SpeciesCarDAO();
		SpeciesCar speciesCar = spcDao.getSpecies(car.getSpeciesID());
		request.setAttribute("speciesCar", speciesCar);
		
		ManufacturerDAO maDao = new ManufacturerDAO();
		ManufacturerCar maCar = maDao.getManufac(car.getManufacID());
		request.setAttribute("maCar", maCar);
		
		CommentDAO cDao = new CommentDAO();
		ArrayList<Comment> listComment = cDao.getCommentById(id_car);
		request.setAttribute("listComment", listComment);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/listCarId.jsp");
		dispatcher.forward(request, response);	
	}

}
