package com.ute.rental.servlet.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class UpdateSpeciesManagerServlet
 */
@WebServlet(name = "updateSpeciesManager", urlPatterns = { "/updateSpeciesManager" })
public class UpdateSpeciesManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSpeciesManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idspecies = request.getParameter("id_species");
		int id = Integer.parseInt(idspecies);
		
		SpeciesCarDAO dao  = new  SpeciesCarDAO();
		SpeciesCar speciesCar = dao.getSpecies(id);
		request.setAttribute("speciesCar", speciesCar);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/updateSpeciesManager.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idspeciesStr = request.getParameter("idSpecies");
		String nameSpecies = request.getParameter("nameSpecies");
		int idspecies = Integer.parseInt(idspeciesStr);
		
		SpeciesCar sCar = new SpeciesCar();
		sCar.setSpeciesId(idspecies);
		sCar.setNameSpecies(nameSpecies);
				
		SpeciesCarDAO dao  = new SpeciesCarDAO();
		dao.updateSpecies(sCar);
		response.sendRedirect(request.getContextPath() + "/listspeciesManager");
	}

}
