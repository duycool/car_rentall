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
import com.ute.rental.bo.*;

import com.ute.rental.bo.Staff;
import com.ute.rental.dao.ContractHourDAO;
import com.ute.rental.dao.MethodDAO;

/**
 * Servlet implementation class ListcontracthourDeliveryServlet
 */
@WebServlet(name = "listcontracthourDelivery", urlPatterns = { "/listcontracthourDelivery" })
public class ListcontracthourDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListcontracthourDeliveryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String status = request.getParameter("status");
		if(status.equals("Approved")) {
			String title = "Hợp Đồng Thuê Theo Giờ Đang Giao";	
			HttpSession session = request.getSession();
			Staff staff = (Staff) session.getAttribute("staff");
			ContractHourDAO dao = new ContractHourDAO();
			ArrayList<ContractHour> listcontracthour = MethodDAO.listContracthouParse(dao.getAllcontractHourByDelivery(staff.getStaffid(),status));
			request.setAttribute("listcontracthour", listcontracthour);
			request.setAttribute("title", title);
			RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/listcontractdHourDelivery.jsp");
			dispatcher.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			Staff staff = (Staff) session.getAttribute("staff");
			if(status.equals("delivery")) {
				String title = "Hợp Đồng Thuê Theo Giờ Đang Giao";			
				ContractHourDAO dao = new ContractHourDAO();
				ArrayList<ContractHour> listcontracthour = MethodDAO.listContracthouParse(dao.getAllcontractHourByDelivery(staff.getStaffid(),status));
				request.setAttribute("listcontracthour", listcontracthour);
				request.setAttribute("title", title);
				RequestDispatcher dispatcher = 
								this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/listcontractdHourDelivery.jsp");
				dispatcher.forward(request, response);
			}else if(status.equals("delivered")) {
				String title = "Hợp Đồng Thuê Theo Giờ Đã Giao";			
				ContractHourDAO dao = new ContractHourDAO();
				ArrayList<ContractHour> listcontracthour = MethodDAO.listContracthouParse(dao.getAllcontractHourByDelivery(staff.getStaffid(),status));
				request.setAttribute("listcontracthour", listcontracthour);
				request.setAttribute("title", title);
				RequestDispatcher dispatcher = 
								this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/listcontractdHourDelivery.jsp");
				dispatcher.forward(request, response);
			}else {
				String title = "Hợp Đồng Thuê Theo Giờ Đã Trả";			
				ContractHourDAO dao = new ContractHourDAO();
				ArrayList<ContractHour> listcontracthour = MethodDAO.listContracthouParse(dao.getAllcontractHourByDelivery(staff.getStaffid(),status));
				request.setAttribute("listcontracthour", listcontracthour);
				request.setAttribute("title", title);
				RequestDispatcher dispatcher = 
								this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/listcontractdHourDelivery.jsp");
				dispatcher.forward(request, response);
				}
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
