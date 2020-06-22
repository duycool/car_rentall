package com.ute.rental.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.dao.PromotionDAO;

/**
 * Servlet implementation class DeletePromotionAdminServlet
 */
@WebServlet(name = "deletePromotionAdmin", urlPatterns = { "/deletePromotionAdmin" })
public class DeletePromotionAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePromotionAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int idpromotion = Integer.parseInt(request.getParameter("idpromotion"));
		PromotionDAO dao = new PromotionDAO();	
		dao.deletePromotion(idpromotion);
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
