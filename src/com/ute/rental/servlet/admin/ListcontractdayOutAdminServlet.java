package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.bo.*;

/**
 * Servlet implementation class ListcontractdayOutAdminServlet
 */
@WebServlet(name = "listcontractdayOutAdmin", urlPatterns = { "/listcontractdayOutAdmin" })
public class ListcontractdayOutAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListcontractdayOutAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String title = "HỢP ĐỒNG QUÁ HẠN";
		ContractDayDAO contractDayDAO = new ContractDayDAO();
		ArrayList<Contractday> listContractday = MethodDAO.listContractdayParse(contractDayDAO.getAllcontractDayOutAdmin());
		request.setAttribute("listContractday", listContractday);
		request.setAttribute("title", title);
		RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/listContracdaytorank.jsp");
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
