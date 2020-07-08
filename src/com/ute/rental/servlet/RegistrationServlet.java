package com.ute.rental.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

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
import com.ute.rental.dao.EmailUtility;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.Random;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(name = "registration", urlPatterns = { "/registration" })
public class RegistrationServlet extends HttpServlet {
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
	
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String nameuser = request.getParameter("name");
		String idcard =  request.getParameter("idcard");
		String datebirthStr = request.getParameter("datebirth");
		String address =  request.getParameter("address");
		String phone = request.getParameter("phone");		
		String passwords = MethodDAO.hashPass(request.getParameter("pass"));
		String roles =  request.getParameter("roles");
		String email = request.getParameter("email");
		
		
		String m = "Username exist!!";
		
		
		
		UserDAO userdao = new UserDAO();
		ArrayList<Users> list = userdao.getAllUsers();
		for(Users users : list) {
			if(users.getUsername().equals(email)) {
				request.setAttribute("mess",m);
				RequestDispatcher dispatcher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/registration.jsp");
				dispatcher.forward(request, response);
				break;
			}
			}
		
			//String passMahoa = MethodDAO.hashPass(passwords);
			
//			Users users = new Users();			
//			users.setUsername(username);
//			users.setPasswords(passwords);
//			users.setRoles(roles);
			
			Custumer custumer = new Custumer();
			custumer.setFullnName(nameuser);
			custumer.setIdcard(idcard);
			custumer.setDateBrith(datebirthStr);
			custumer.setEmail(email);
			custumer.setAddress(address);
			custumer.setPhoneNumber(phone);
			custumer.setPasswords(passwords);
			custumer.setRoles(roles);
			
			
			
			//userdao.AddUsersCustumer(users, custumer);
			//response.sendRedirect(request.getContextPath() + "/home");	
			
	
			String subject = "Code";
			int code = Random.ran();
			String codeStr=String.valueOf(code);
			String content = codeStr;
			String resultMessage = "Vui lòng Nhập Code";

			try {
				EmailUtility.sendEmail(host, port, user, pass, email, subject,
						content);
				resultMessage = "Vui lòng Nhập Code";
			} catch (Exception ex) {
				ex.printStackTrace();
				resultMessage = "There were an error: " + ex.getMessage();
			} finally {
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("UTF-8");
				HttpSession session = request.getSession();			
				session.setAttribute("custumer", custumer);
				session.setAttribute("content",content);
				request.setAttribute("message", resultMessage);
				//request.setAttribute("content",content);
				getServletContext().getRequestDispatcher("/WEB-INF/view/registrationCode.jsp").forward(request, response);
			}
			
			
	}

}
