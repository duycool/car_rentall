package com.ute.rental.servlet.delivery;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.ContractHour;
import com.ute.rental.bo.Staff;
import com.ute.rental.dao.ContractHourDAO;
import com.ute.rental.dao.MethodDAO;

/**
 * Servlet implementation class ListcontracthourTorankDeliveryServlet
 */
@WebServlet(name = "listcontracthourTorankDelivery", urlPatterns = { "/listcontracthourTorankDelivery" })
public class ListcontracthourTorankDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListcontracthourTorankDeliveryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String title = "Hợp Đồng Đến Hạn";
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("staff");
		int idstaff = staff.getStaffid();
		ContractHourDAO contractHourDAO = new ContractHourDAO();
		ArrayList<ContractHour> listcontracthour = MethodDAO.listContracthouParse(contractHourDAO.getAllcontractHourTorankStaff(idstaff));
		request.setAttribute("listcontracthour", listcontracthour);
		request.setAttribute("title",title);
		RequestDispatcher dispatcher = 
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/listContractOutHour.jsp");
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
