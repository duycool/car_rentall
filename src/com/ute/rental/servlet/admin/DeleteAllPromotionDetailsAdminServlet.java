package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Car;
import com.ute.rental.dao.PromotionDetailsDAO;

/**
 * Servlet implementation class DeleteAllPromotionAdminServlet
 */
@WebServlet(name = "deleteAllPromotionAdmin", urlPatterns = { "/deleteAllPromotionAdmin" })
public class DeleteAllPromotionDetailsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAllPromotionDetailsAdminServlet() {
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
		HttpSession session = request.getSession();
		int idpromotion = (int) session.getAttribute("idpromotiondelete");
		String [] idcar = request.getParameterValues("idcar");
		
		PromotionDetailsDAO dao = new PromotionDetailsDAO();
		try {
			dao.DeleteAllPromotion(idcar,idpromotion);
			PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
			ArrayList<Car> listcarId = proDetailsDAO.getListIdCarPromotion(idpromotion);	
			ArrayList<Car> listcar = new ArrayList<Car>();
			for(Car car : listcarId) {
				listcar.add(car);
			}
			request.setAttribute("listcar",listcar);
			RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listCarPromotionIdAdmin.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
	}

}
