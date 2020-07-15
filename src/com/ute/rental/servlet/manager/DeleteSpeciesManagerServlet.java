package com.ute.rental.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class DeleteSpeciesManagerServlet
 */
@WebServlet(name = "deleteSpeciesManager", urlPatterns = { "/deleteSpeciesManager" })
public class DeleteSpeciesManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSpeciesManagerServlet() {
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
		dao.deleteSpecies(id);
		response.sendRedirect(request.getContextPath() + "/listspeciesManager");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
