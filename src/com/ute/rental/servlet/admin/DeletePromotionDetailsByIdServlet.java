package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.PromotionDetails;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.PromotionDetailsDAO;

/**
 * Servlet implementation class DeletePromotionDetailsByIdServlet
 */
@WebServlet(name = "deletePromotionDetailsById", urlPatterns = { "/deletePromotionDetailsById" })
public class DeletePromotionDetailsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePromotionDetailsByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int carid = Integer.parseInt(request.getParameter("carid"));
		PromotionDetailsDAO promotionDetailsdao  = new PromotionDetailsDAO();		
		CarDAO carDAO = new CarDAO();
		Car car1 = carDAO.getCar(carid);
		promotionDetailsdao.deletePromotionDetailsByidCar(car1);
		HttpSession session = request.getSession();
		int idpromotion = (int) session.getAttribute("idpromotiondelete");
		//query ra lại promotiondetails để lấy cái idpromotion show ra lại các sản phẩm còn lại thuộc trong cái idpromotion
		//PromotionDetails promotionDetails = promotionDetailsdao.getPromotionDetailsByidCar(carid);
					
		ArrayList<Car> listcarId = promotionDetailsdao.getListIdCarPromotion(idpromotion);
		ArrayList<Car> listcar = new ArrayList<Car>();
		
		for(Car car : listcarId) {		
			listcar.add(car);					
		}
		request.setAttribute("listcar",listcar);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listCarPromotionIdAdmin.jsp");
		dispatcher.forward(request, response);	
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
