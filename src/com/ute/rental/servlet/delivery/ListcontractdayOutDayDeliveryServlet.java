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

import com.ute.rental.bo.Contractday;
import com.ute.rental.bo.Staff;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.MethodDAO;

/**
 * Servlet implementation class ListcontractdayOutDayDeliveryServlet
 */
@WebServlet(name = "listcontractdayOutDayDelivery", urlPatterns = { "/listcontractdayOutDayDelivery" })
public class ListcontractdayOutDayDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListcontractdayOutDayDeliveryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String title = "Hợp Đồng Hết Hạn";
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("staff");
		int idstaff = staff.getStaffid();
		ContractDayDAO contractDayDAO = new  ContractDayDAO();
		ArrayList<Contractday> listContractday = MethodDAO.listContractdayTorankParse(contractDayDAO.getAllcontractOutDateStaff(idstaff,"delivered"));
		request.setAttribute("listContractday", listContractday);
		request.setAttribute("title",title);
		RequestDispatcher dispatcher = 
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/delivery/listContractdayOutDate.jsp");
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
