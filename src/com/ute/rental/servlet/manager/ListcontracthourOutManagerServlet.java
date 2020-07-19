package com.ute.rental.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.dao.ContractHourDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.bo.*;

/**
 * Servlet implementation class ListcontracthourOutManagerServlet
 */
@WebServlet(name = "listcontracthourOutManager", urlPatterns = { "/listcontracthourOutManager" })
public class ListcontracthourOutManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListcontracthourOutManagerServlet() {
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
		ContractHourDAO contractHourDAO = new ContractHourDAO();
		ArrayList<ContractHour> listcontracthour = MethodDAO.listContracthouParse(contractHourDAO.getAllcontractHourOutAdmin());
		request.setAttribute("listcontracthour", listcontracthour);
		request.setAttribute("title", title);
		RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/manager/listContracthourtorankManager.jsp");
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
