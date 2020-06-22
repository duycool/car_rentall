package com.ute.rental.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Custumer;
import com.ute.rental.bo.Users;
import com.ute.rental.dao.CustumerDAO;
import com.ute.rental.dao.EmailUtility;
import com.ute.rental.dao.Random;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class UpdateInfoUserServlet
 */
@WebServlet(name = "updateInfoUser", urlPatterns = { "/updateInfoUser" })
public class UpdateInfoUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;  
	
	public void init() {
		//Read SMTP server Cài đặt tại web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("id_user");
		
		UserDAO dao = new UserDAO();
		Users user = dao.getUser(userid);
		request.setAttribute("user", user);
		
		CustumerDAO custumerDAO = new CustumerDAO();
		Custumer custumer = custumerDAO.getCustumer(userid);
		request.setAttribute("custumer",custumer);
		RequestDispatcher dispacher = 
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/updateInforUser.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int cumtumerid = Integer.parseInt(request.getParameter("custumerid"));
		String nameuser = request.getParameter("name");
		String idcard = request.getParameter("idcard");
		String datebirth = request.getParameter("datebirth");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		Custumer custumer = new Custumer();
		custumer.setCustumerid(cumtumerid);
		custumer.setFullnName(nameuser);
		custumer.setIdcard(idcard);
		custumer.setDateBrith(datebirth);
		custumer.setAddress(address);
		custumer.setPhoneNumber(phone);
		custumer.setEmail(email);
		
		String subject = "Code Confirmation Infomation change";
		int Code = Random.ran();
		String contextStr = String.valueOf(Code);
		String content = contextStr;
		String message = "";
		try {
			EmailUtility.sendEmail(host, port, user, pass, email, subject, content);
			message = "please input Code Confirmation Infomation change";
		}catch (Exception e) {
			e.printStackTrace();
			message = "There were an email"  + e.getMessage();
		}finally {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			session.setAttribute("custumer", custumer);
			session.setAttribute("content", content);
			request.setAttribute("message", message);
			RequestDispatcher dispacher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/updateInforUserCode.jsp");
			dispacher.forward(request, response);
		}				
	}
}
