package com.ute.rental.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class CreateSpeciesServlet
 */
@WebServlet(name = "createspecies", urlPatterns = { "/createspecies" })
public class CreateSpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSpeciesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/createSpecies.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String speciesStr = request.getParameter("name");
		SpeciesCar car = new SpeciesCar();
		car.setNameSpecies(speciesStr);
		SpeciesCarDAO dao = new SpeciesCarDAO();
		dao.AddSpecies(car);	
		response.sendRedirect(request.getContextPath() + "/listspecies");	
	}
}
