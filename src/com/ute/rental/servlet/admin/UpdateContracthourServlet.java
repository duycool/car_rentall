package com.ute.rental.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.Contract;
import com.ute.rental.bo.ContractHour;
import com.ute.rental.bo.Custumer;
import com.ute.rental.bo.Staff;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.ContractDAO;
import com.ute.rental.dao.ContractHourDAO;
import com.ute.rental.dao.CustumerDAO;
import com.ute.rental.dao.EmailUtility;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.StaffDAO;

/**
 * Servlet implementation class UpdateContracthourServlet
 */
@WebServlet(name = "updateContracthour", urlPatterns = { "/updateContracthour" })
public class UpdateContracthourServlet extends HttpServlet {
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
    public UpdateContracthourServlet() {
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
		String status = "Approved";
		
		ContractHour contractHour = new ContractHour();
		contractHour.setStaffid(staffid);
		contractHour.setContractid(idcontract);	
		contractHour.setStatus(status);
		ContractHourDAO contractHourDAO = new ContractHourDAO();
		CustumerDAO custumerDAO = new CustumerDAO();
		StaffDAO staffDAO = new StaffDAO();
		CarDAO carDAO = new  CarDAO();
		ContractDAO contractDAO = new ContractDAO();
		
		ContractHour contractHour1 = contractHourDAO.getContractHour(idcontract);
		Contract contract = contractDAO.getContract(idcontract);
		Custumer custumer = custumerDAO.getCustumerByCustumerid(contract.getCustumerid());
		Staff staff = staffDAO.getStaffByidStaff(staffid);
		Car car = carDAO.getCar(contract.getId_car());
		String emailStaff = staff.getEmail();
		String emailCustumer = custumer.getEmail();

		try {			
			String subject = "Notification !";
			String contentStaff = "Giao Xe vào Ngày Dự Kiến Là'"+MethodDAO.ParseDateInDatabase(contractHour1.getDayhire())+"' Vui lòng Thực Hiện Đúng yêu cầu của cửa hàng";
			String contentCustumer = "Xe '"+car.getNameCar()+"' bạn thuê  Vào Ngày '"+MethodDAO.ParseDateInDatabase(contractHour1.getDayhire())+"' Đã Được Duyệt"
					+ "	Vui lòng đợi ngày nhận xe";
			
			contractHourDAO.UpdateStatusContracthour(contractHour);
			
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
				response.sendRedirect(request.getContextPath() + "/listcontracthour");
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
