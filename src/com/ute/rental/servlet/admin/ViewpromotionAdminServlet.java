package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.Promotion;
import com.ute.rental.bo.PromotionDetails;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.PromotionDAO;
import com.ute.rental.dao.PromotionDetailsDAO;

/**
 * Servlet implementation class ViewpromotionAdminServlet
 */
@WebServlet(name = "viewpromotionAdmin", urlPatterns = { "/viewpromotionAdmin" })
public class ViewpromotionAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewpromotionAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PromotionDAO proDao = new PromotionDAO();
		//lấy tất cả list promotion trong database ra
		ArrayList<Promotion> listpromotionok = proDao.getAllPromotionJoin();
		//tao listpromotion để nhận lại giá trị Parse kiểu ngày tháng năm.
		ArrayList<Promotion> listpromotion = new ArrayList<Promotion>();
		for(Promotion promotion : listpromotionok) {
			promotion.setStarday(MethodDAO.ParseDateInDatabase(promotion.getStarday()));
			promotion.setEndDay(MethodDAO.ParseDateInDatabase(promotion.getEndDay()));
			listpromotion.add(promotion);
		}		
		request.setAttribute("listpromotion", listpromotion);
		RequestDispatcher dispatcher =
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listpromotionAdmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
