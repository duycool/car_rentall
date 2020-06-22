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
 * Servlet implementation class ListCartidServlet
 */
@WebServlet(name = "listCartid", urlPatterns = { "/listCartid" })
public class ListCartidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCartidServlet() {
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
		int id_car = Integer.parseInt(idStr);
		HttpSession session = request.getSession();
		session.setAttribute("id_car", id_car);				
		PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
		PromotionDAO proDao = new PromotionDAO();						
		String name = "Giảm Giá : ";
		String vnd = "VNÐ";
		String giatheongay = "Giá Theo Ngày ||  ";
		String giatheogio = "Giá Theo Giờ || ";
		MethodDAO methodDAO = new MethodDAO();
		if(MethodDAO.checkPromotion(id_car)) {
			PromotionDetails promotionDetails = proDetailsDAO.getPromotionDetailsByidCar(id_car);
			Promotion promotion = proDao.getPromotion(promotionDetails.getIdpromotion());
			request.setAttribute("promotion", promotion);
			String giabandau = "Giá Ban Ðầu : ";
			String giagiam = "Giá Sau Khi Giảm : ";
			String vndsale = "VNÐ";
			String giatheongaysale = "Giá Theo Ngày : ";
			String giatheogiosale = "Giá Theo Giờ : ";
															
			request.setAttribute("name", name);
			session.setAttribute("id_car", id_car);
			CarDAO dao = new CarDAO();
			Car car = dao.getCarJoinSpeciesAndManu(id_car);
			car.setNameSpecies(MethodDAO.ConvertNameSpecies(car.getNameSpecies()));
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
							
			CommentDAO cDao = new CommentDAO();
			ArrayList<Comment> listComment = cDao.getCommentById(id_car);
			request.setAttribute("listComment", listComment);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/listCarId.jsp");
			dispatcher.forward(request, response);
		}else {
			CarDAO dao = new CarDAO();
			Car car = dao.getCarJoinSpeciesAndManu(id_car);
			car.setNameSpecies(MethodDAO.ConvertNameSpecies(car.getNameSpecies()));
			session.setAttribute("quantity", car.getQuantity());
			request.setAttribute("car", car);
			int  pricebt = car.getPrice();
			int  pricehourbt = car.getPricehour();
			
			request.setAttribute("vnd", vnd);
			request.setAttribute("pricebt", pricebt);
			request.setAttribute("pricehourbt", pricehourbt);
			request.setAttribute("giatheongay", giatheongay);
			request.setAttribute("giatheogio", giatheogio);
			
			CommentDAO cDao = new CommentDAO();
			ArrayList<Comment> listComment = cDao.getCommentById(id_car);
			request.setAttribute("listComment", listComment);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/listCarId.jsp");
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

}
