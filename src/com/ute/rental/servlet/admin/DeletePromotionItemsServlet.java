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

import com.ute.rental.bo.Car;
import com.ute.rental.bo.Promotion;
import com.ute.rental.bo.PromotionDetails;
import com.ute.rental.dao.CarDAO;

/**
 * Servlet implementation class DeletePromotionItemsServlet
 */
@WebServlet(name = "deletePromotionItems", urlPatterns = { "/deletePromotionItems" })
public class DeletePromotionItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePromotionItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Promotion promotion = (Promotion) session.getAttribute("promotion");
			
		List<PromotionDetails> listDetails = promotion.getPromotionDetails();
		
		int id_car = Integer.parseInt(request.getParameter("id_car"));
		CarDAO carDAO = new  CarDAO();
		Car car = carDAO.getCar(id_car);	
		for(PromotionDetails prDetails : listDetails) {
			if(prDetails.getCar().getId_car() == car.getId_car()) {
				listDetails.remove(prDetails);
				break;
			}
		}
		response.sendRedirect(request.getContextPath() + "/promotionAdmin");
	}
		
				
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static void main(String[] args) {
		
		
	}
}
