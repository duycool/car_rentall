package com.ute.rental.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ute.rental.bo.Custumer;
import com.ute.rental.bo.Users;
import com.ute.rental.dao.CustumerDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.PromotionDAO;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("name");
		String passwords = (String) request.getParameter("pass");								
		UserDAO userdao = new UserDAO();
		Users users = new Users();
		if(username.contains("@gmail.com")) {
			 users  = userdao.findUsername(username);
		if (users == null) {
			request.setAttribute("message", "Mail khôn tồn tại !");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
			dispatcher.forward(request, response);
		} 
		String passdatabase  = users.getPasswords();		
		if(MethodDAO.checkHashPass(passwords, passdatabase)) {			
				HttpSession session = request.getSession();
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("UTF-8");
				//session.setAttribute("users", users);
				if (users.getRoles().equals("admin")) {
					session.setAttribute("userNameAdmin", users.getUsername());
					session.setAttribute("roles", users.getRoles());
					session.setAttribute("id_user", users.getUserid());
					response.setContentType("text/html;charset=UTF-8");
					//session.setAttribute("status", contract.getStatus());
					request.setCharacterEncoding("UTF-8");
					response.sendRedirect(request.getContextPath() + "/homeadmin");
				}else if(users.getRoles().equals("staffdelivery")) {
					session.setAttribute("userNameDelevery", users.getUsername());
					session.setAttribute("roles", users.getRoles());
					session.setAttribute("id_user", users.getUserid());
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
					response.sendRedirect(request.getContextPath() + "/homeStaffDelivery");
				}else if(users.getRoles().equals("staffmanage")) {
					session.setAttribute("userNameDelevery", users.getUsername());
					session.setAttribute("roles", users.getRoles());
					session.setAttribute("id_user", users.getUserid());
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
					response.sendRedirect(request.getContextPath() + "/homeStaffManage");				
				}else{
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
					session.setAttribute("user_current", users);
					session.setAttribute("username", users.getUsername());
					session.setAttribute("id_user", users.getUserid());	
					session.setAttribute("roles", users.getRoles());
					CustumerDAO dao = new CustumerDAO();
					//get custumer by userid
					Custumer custumer = dao.getCustumer(users.getUserid());
					session.setAttribute("custumerid", custumer.getCustumerid());
					session.setAttribute("nameuser", custumer.getFullnName());									
					session.setAttribute("address", custumer.getAddress());
					session.setAttribute("phone", custumer.getPhoneNumber());
					session.setAttribute("email", custumer.getEmail());
									
					response.sendRedirect(request.getContextPath() + "/homeuser");
				}
			}else {
				String message = "mật khẩu không đúng ";
				request.setAttribute("message",message);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
				dispatcher.forward(request, response);
			}
		}else {	
			String message = "không đúng mail";
			request.setAttribute("message",message);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
			dispatcher.forward(request, response);
		}
		}
	}


