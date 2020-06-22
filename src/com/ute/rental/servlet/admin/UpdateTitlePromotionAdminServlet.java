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
 * Servlet implementation class UpdateTitlePromotionAdminServlet
 */
@WebServlet(name = "updateTitlePromotionAdmin", urlPatterns = { "/updateTitlePromotionAdmin" })
public class UpdateTitlePromotionAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTitlePromotionAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idpromotion = Integer.parseInt(request.getParameter("idpromotion"));
		String title = request.getParameter("title");
		PromotionDAO dao = new PromotionDAO();
		Promotion promotion = new Promotion();
		promotion.setIdpromotion(idpromotion);
		promotion.setTitile(title);
		dao.updatePromotionByTitle(promotion);
		response.sendRedirect(request.getContextPath() + "/viewpromotionAdmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
