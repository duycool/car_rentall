package com.ute.rental.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.dao.CarDAO;

/**
 * Servlet implementation class DeleteCarManagerServlet
 */
@WebServlet(name = "deleteCarManager", urlPatterns = { "/deleteCarManager" })
public class DeleteCarManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCarManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCarStr = request.getParameter("id_car");
		int idcar = Integer.parseInt(idCarStr);		
		CarDAO dao  = new CarDAO();
		dao.deleteCar(idcar);
		response.sendRedirect(request.getContextPath() + "/listCarManager");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
