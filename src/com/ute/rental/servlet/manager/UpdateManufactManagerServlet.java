package com.ute.rental.servlet.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.ManufacturerCar;
import com.ute.rental.dao.ManufacturerDAO;

/**
 * Servlet implementation class UpdateManufactManagerServlet
 */
@WebServlet(name = "updateManufactManager", urlPatterns = { "/updateManufactManager" })
public class UpdateManufactManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManufactManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idManu = request.getParameter("id_manu");
		int id = Integer.parseInt(idManu);
		
		ManufacturerDAO dao  = new  ManufacturerDAO();
		ManufacturerCar manufact = dao.getManufac(id);
		request.setAttribute("manufact", manufact);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/updateManu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idmanuStr = request.getParameter("idManufact");
		String nameManufact = request.getParameter("nameManufact");
		int idmanu = Integer.parseInt(idmanuStr);
		
		ManufacturerCar maCar = new ManufacturerCar();
		maCar.setManuFacID(idmanu);
		maCar.setNameManufac(nameManufact);
				
		ManufacturerDAO dao  = new ManufacturerDAO();
		dao.updateManu(maCar);
		response.sendRedirect(request.getContextPath() + "/listmanufactManager");
	}

}
