package com.ute.rental.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Custumer;
import com.ute.rental.bo.Violate;
import com.ute.rental.dao.CustumerDAO;
import com.ute.rental.dao.ViolateDAO;

/**
 * Servlet implementation class AddViolateAdminServlet
 */
@WebServlet(name = "addViolateAdmin", urlPatterns = { "/addViolateAdmin" })
public class AddViolateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddViolateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id_car = Integer.parseInt(request.getParameter("carid"));
		int custumerid = Integer.parseInt(request.getParameter("custumerid"));
		HttpSession session = request.getSession();
		session.setAttribute("id_car", id_car);
		session.setAttribute("custumerid", custumerid);
		CustumerDAO custumerDAO = new CustumerDAO();
		Custumer custumer = custumerDAO.getCustumerByCustumerid(custumerid);
		request.setAttribute("custumer",custumer);
		RequestDispatcher dispatcher = 
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/Addviolate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int id_car = (int) session.getAttribute("id_car");
		int custumerid  = (int) session.getAttribute("custumerid");
		CustumerDAO custumerDAO = new CustumerDAO();
		Custumer custumer = custumerDAO.getCustumerByCustumerid(custumerid);
		int price = Integer.parseInt(request.getParameter("price"));
		String reason  = request.getParameter("reason");
		Violate violate = new Violate();
		violate.setNameViolate(custumer.getFullnName());
		violate.setPriceViolate(price);
		violate.setReason(reason);
		violate.setId_car(id_car);
		violate.setCustumerid(custumerid);
		
		ViolateDAO dao = new ViolateDAO();
		dao.AddViolate(violate);
		
		response.sendRedirect(request.getContextPath() + "/listcontractViolateAdmin");
	}

}
