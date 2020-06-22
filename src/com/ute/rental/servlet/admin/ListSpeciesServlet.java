package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class ListSpeciesServlet
 */
@WebServlet(name = "listspecies", urlPatterns = { "/listspecies" })
public class ListSpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSpeciesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeciesCarDAO speciesCarDAO = new SpeciesCarDAO();	
		ArrayList<SpeciesCar> listspecies = speciesCarDAO.getAllSpecies();
		request.setAttribute("listspecies", listspecies);
		
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listSpeciesAdmin.jsp");
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
