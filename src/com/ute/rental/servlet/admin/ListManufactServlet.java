package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.dao.ManufacturerDAO;
import com.ute.rental.bo.*;
/**
 * Servlet implementation class ListManufactServlet
 */
@WebServlet(name = "listmanufact", urlPatterns = { "/listmanufact" })
public class ListManufactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListManufactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManufacturerDAO manufacturerDAO = new ManufacturerDAO();	
		ArrayList<ManufacturerCar> listsmanu = manufacturerDAO.getAllManufac();
		request.setAttribute("listsmanu", listsmanu);
		
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listManufactAdmin.jsp");
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
