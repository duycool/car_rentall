package com.ute.rental.servlet.admin;

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
 * Servlet implementation class CreateManufactServlet
 */
@WebServlet(name = "createManufact", urlPatterns = { "/createManufact" })
public class CreateManufactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateManufactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher  = 
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/createManufact.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String nameManufac = request.getParameter("name");
		ManufacturerCar manu = new ManufacturerCar();
		manu.setNameManufac(nameManufac);
		ManufacturerDAO dao = new ManufacturerDAO();
		dao.AddManufac(manu);	
		response.sendRedirect(request.getContextPath() + "/listmanufact");
	}

}
