package com.ute.rental.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Promotion;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.PromotionDAO;

/**
 * Servlet implementation class AddPromotionDBManagerServlet
 */
@WebServlet(name = "addPromotionDBManager", urlPatterns = { "/addPromotionDBManager" })
public class AddPromotionDBManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPromotionDBManagerServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String []  idcarArr = request.getParameterValues("idcar");	
		String starday = request.getParameter("starday");
		String endday = request.getParameter("endday");
		String title = request.getParameter("title");
		PromotionDAO promotionDAO = new PromotionDAO();
		Promotion promotion = new Promotion();
		//Car car = new Car();
		String stardaytime = starday;
		String enddaytime = endday;
		promotion.setStarday(stardaytime + " " + MethodDAO.TimeHientai());
		promotion.setEndDay(enddaytime + " " + MethodDAO.TimeHientai());
		promotion.setTitile(title);
		
		
	
		
		
		// idcarArr.toString().split(" ");
		//int idcar = AddPromotionDBServlet.idcar(idcarArr);	
		//car.setId_car(idcar);
		promotionDAO.AddPromotionDB(promotion, idcarArr);
		/*for(int i = 0 ; i < idcarArr.length ; i++) {
				int carid = Integer.parseInt(idcarArr[i]);
				car.setId_car(carid);					
		}*/
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/promotionManager");
	}

}
