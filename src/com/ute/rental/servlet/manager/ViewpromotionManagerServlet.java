package com.ute.rental.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Promotion;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.PromotionDAO;

/**
 * Servlet implementation class ViewpromotionManagerServlet
 */
@WebServlet(name = "viewpromotionManager", urlPatterns = { "/viewpromotionManager" })
public class ViewpromotionManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewpromotionManagerServlet() {
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
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/listpromotionManager.jsp");
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
