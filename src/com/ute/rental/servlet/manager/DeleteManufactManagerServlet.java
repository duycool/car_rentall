package com.ute.rental.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.dao.ManufacturerDAO;

/**
 * Servlet implementation class DeleteManufactManagerServlet
 */
@WebServlet(name = "deleteManufactManager", urlPatterns = { "/deleteManufactManager" })
public class DeleteManufactManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteManufactManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idmanuStr = request.getParameter("id_manu");
		int idmanu = Integer.parseInt(idmanuStr);		
		ManufacturerDAO dao = new ManufacturerDAO();
		dao.deleteManu(idmanu);	
		response.sendRedirect(request.getContextPath() + "/listmanufactManager");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
