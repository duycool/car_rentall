package com.ute.rental.servlet.delivery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.SpeciesContract;
import com.ute.rental.bo.Staff;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.SpeciesContractDAO;

/**
 * Servlet implementation class DeliveryContractdayServlet
 */
@WebServlet(name = "deliveryContractday", urlPatterns = { "/deliveryContractday" })
public class DeliveryContractdayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryContractdayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String speContractidStr = request.getParameter("speContractid");
		int speContractid = Integer.parseInt(speContractidStr);
		HttpSession session = request.getSession();
		session.setAttribute("speContractid", speContractid);
		//request.setAttribute("speContractid", speContractid);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/createContractDelivery.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int speContractid = (int) session.getAttribute("speContractid");
		Staff staff = (Staff) session.getAttribute("staff");
		int staffid = staff.getStaffid();
		String status = request.getParameter("status");
		ContractDayDAO contractDayDAO = new ContractDayDAO();
		if(status.equals("delivery")) {	
			String action = "busy";						
			contractDayDAO.UpdateStatusContractdayDelivery(speContractid,status);	
			contractDayDAO.updateStaffAndContractDelivery(speContractid, action,staffid,status);
			response.sendRedirect(request.getContextPath() + "/homeStaffDelivery");
		}else {	
			String action = "normal";			
			contractDayDAO.UpdateStatusContractdayDelivery(speContractid,status);			
			contractDayDAO.updateStaffAndContractDelivery(speContractid, action,staffid,status);
//			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/homeDelevery.jsp");
//			dispatcher.forward(request, response);
			response.sendRedirect(request.getContextPath() + "/homeStaffDelivery");
		}
	}

}
