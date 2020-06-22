package com.ute.rental.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Car;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.PromotionDAO;
import com.ute.rental.dao.PromotionDetailsDAO;

/**
 * Servlet implementation class SearchCarByPromotionServlet
 */
@WebServlet(name = "searchCarByPromotion", urlPatterns = { "/searchCarByPromotion" })
public class SearchCarByPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCarByPromotionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String titleStr = request.getParameter("title");
		PromotionDAO dao = new PromotionDAO();
		String title = MethodDAO.ParsePhantram(titleStr);
		int idpromotion = dao.getPromotionByTitle(title);		
		PromotionDetailsDAO promotionDetailsDAO = new PromotionDetailsDAO();				
		//List<PromotionDetails> listDetails = promotion.getPromotionDetails();	
		ArrayList<Car> listcarId = promotionDetailsDAO.getListIdCarPromotion(idpromotion);	
		ArrayList<Car> listcar = new ArrayList<Car>();
		for(Car car : listcarId) {
			listcar.add(car);
		}
		request.setAttribute("listcar",listcar);
		RequestDispatcher dispatcher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/homeuser.jsp");
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
