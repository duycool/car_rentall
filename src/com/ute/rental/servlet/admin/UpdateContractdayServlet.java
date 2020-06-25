package com.ute.rental.servlet.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.Contract;
import com.ute.rental.bo.Contractday;
import com.ute.rental.bo.Custumer;
import com.ute.rental.bo.Staff;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.ContractDAO;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.CustumerDAO;
import com.ute.rental.dao.EmailUtility;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.StaffDAO;

/**
 * Servlet implementation class UpdateContractdayServlet
 */
@WebServlet(name = "updateContractday", urlPatterns = { "/updateContractday" })
public class UpdateContractdayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;     
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		//Read SMTP server Cài đặt tại web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
    public UpdateContractdayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			int staffid = Integer.parseInt(request.getParameter("staff"));
			int idcontract = Integer.parseInt(request.getParameter("idcontract"));
			String status = "delivery";
			
			Contractday contractday = new Contractday();
			contractday.setStaffid(staffid);
			contractday.setContractid(idcontract);	
			contractday.setStatus(status);
			HttpSession session = request.getSession();
			session.setAttribute("contractday", contractday);
			session.setAttribute("staffid", staffid);
			ContractDayDAO contractDayDAO = new  ContractDayDAO();
			contractday = contractDayDAO.getContractDay(idcontract);
			contractday.setDayhire(MethodDAO.ParseDateInDatabase(contractday.getDayhire()));
			request.setAttribute("contractday", contractday);
		
			RequestDispatcher dispatcher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CreateDeliveryDay.jsp");
			dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String datehireStr = request.getParameter("date");
		HttpSession session = request.getSession();
		ContractDayDAO contractDayDAO = new ContractDayDAO();
		CustumerDAO custumerDAO = new CustumerDAO();
		StaffDAO staffDAO = new StaffDAO();
		CarDAO carDAO = new  CarDAO();
		ContractDAO contractDAO = new ContractDAO();
		Contractday contractday1 = (Contractday) session.getAttribute("contractday");
		Contractday contractday = contractDayDAO.getContractDay(contractday1.getContractid());
		Contract contract = contractDAO.getContract(contractday.getContractid());
		Custumer custumer = custumerDAO.getCustumerByCustumerid(contract.getCustumerid());
		int staffid = (int) session.getAttribute("staffid");
		Staff staff = staffDAO.getStaffByidStaff(staffid);
		Car car = carDAO.getCar(contract.getId_car());
		String emailStaff = staff.getEmail();
		String emailCustumer = custumer.getEmail();
	
		try {
			Date date = MethodDAO.StringToDateHour(datehireStr);
			String hireday = new SimpleDateFormat("yyyy/MM/dd").format(date);
			contractday1.setDeliveryTime(hireday + " " + MethodDAO.TimeHientai());
			String subject = "Notification !";
			String contentStaff = "Giao Xe vào Ngày '"+MethodDAO.ParseDateInDatabase(contractday.getDayhire())+"'";
			String contentCustumer = "Xe '"+car.getNameCar()+"' bạn thuê  Vào Ngày '"+MethodDAO.ParseDateInDatabase(contractday.getDayhire())+"' Đã Được Duyệt"
					+ "	Vui lòng đợi ngày nhận xe";
			
			contractDayDAO.UpdateStatusContract(contractday1);
			
			try {
				EmailUtility.sendEmail(host, port, user, pass, emailStaff, subject,
						contentStaff);
				EmailUtility.sendEmail(host, port, user, pass, emailCustumer, subject,
						contentCustumer);
			} catch (Exception ex) {
				ex.printStackTrace();			
			} finally {
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("UTF-8");
				response.sendRedirect(request.getContextPath() + "/listcontractday");
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void main(String[] args) {
		
	}

}
