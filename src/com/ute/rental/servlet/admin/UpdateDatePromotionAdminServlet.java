package com.ute.rental.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Promotion;
import com.ute.rental.dao.PromotionDAO;

/**
 * Servlet implementation class UpdateDatePromotionAdminServlet
 */
@WebServlet(name = "updateDatePromotionAdmin", urlPatterns = { "/updateDatePromotionAdmin" })
public class UpdateDatePromotionAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDatePromotionAdminServlet() {
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
		int idpromotion = Integer.parseInt(request.getParameter("idpromotion"));
		String starday = request.getParameter("starday");
		String endDay = request.getParameter("endday");
		PromotionDAO dao = new PromotionDAO();
		
		Promotion promotion = new Promotion();
		promotion.setIdpromotion(idpromotion);
		promotion.setStarday(starday);
		promotion.setEndDay(endDay);
		
		dao.updatePromotionByDay(promotion);
		
		response.sendRedirect(request.getContextPath() + "/viewpromotionAdmin");
	}

}
