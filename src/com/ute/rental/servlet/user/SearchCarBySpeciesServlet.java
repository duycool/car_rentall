package com.ute.rental.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class SearchCarBySpeciesServlet
 */
@WebServlet(name = "searchCarBySpecies", urlPatterns = { "/searchCarBySpecies" })
public class SearchCarBySpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCarBySpeciesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String species = request.getParameter("species");
		//String species = MethodDAO.ParseSpecies(speciesStr);		
		SpeciesCarDAO spCarDAO = new SpeciesCarDAO();
		SpeciesCar speciesCar = spCarDAO.getSpeciesByName(species);
		CarDAO cardao = new CarDAO();		
		ArrayList<Car>	listcar = cardao.getSpeciesCar(speciesCar.getSpeciesId());
		request.setAttribute("listcar", listcar);						
		RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/homeuser.jsp");
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
