package com.ute.rental.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Users;
import com.ute.rental.dao.EmailUtility;
import com.ute.rental.dao.Random;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet(name = "forgotPassword", urlPatterns = { "/forgotPassword" })
public class ForgotPasswordServlet extends HttpServlet {
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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
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
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/ForgotPassword.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("name");		
		if(email.contains("@gmail.com")) {
			UserDAO  userDAO = new UserDAO();
			Users users  = userDAO.findUsername(email);
			if(users == null) {
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("UTF-8");
				String message = "Mail này không tồn tại";
				request.setAttribute("message", message);		
				RequestDispatcher dispatcher = 
							this.getServletContext().getRequestDispatcher("/WEB-INF/view/ForgotPassword.jsp");
				dispatcher.forward(request, response);
			}
			if(users != null) {
				String subject = "Code Change Pass";
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
					session.setAttribute("users", users);
					request.setAttribute("message", resultMessage);
					session.setAttribute("content",content);
					getServletContext().getRequestDispatcher("/WEB-INF/view/ForgotPasswordCode.jsp").forward(request, response);
				}
			}
		}else {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			String message = "Nhập Tên Mail sai";
			request.setAttribute("message", message);		
			RequestDispatcher dispatcher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/ForgotPassword.jsp");
			dispatcher.forward(request, response);
		}
	}

}
