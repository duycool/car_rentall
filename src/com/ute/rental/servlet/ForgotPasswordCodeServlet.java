package com.ute.rental.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Users;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class ForgotPasswordCodeServlet
 */
@WebServlet(name = "forgotPasswordCode", urlPatterns = { "/forgotPasswordCode" })
public class ForgotPasswordCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordCodeServlet() {
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
		String codeinput = request.getParameter("codeinput");
		String code = (String) session.getAttribute("content");		
		if(code.equals(codeinput)) {		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/changepassforgot.jsp");
			dispatcher.forward(request, response);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			String result = "Incorrect Code !";	
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/ForgotPasswordCode.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String newpass = request.getParameter("passnew");
		String ConfirmPass = request.getParameter("ConfirmPassword");		
		if(newpass.equals(ConfirmPass)) {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			String result = "Đổi Mật Khẩu Thành công";
			String hashpass = MethodDAO.hashPass(newpass);
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("users");
			UserDAO userDAO = new UserDAO();
			Users users = new Users();
			users.setUserid(user.getUserid());
			users.setPasswords(hashpass);
			userDAO.updatePassUser(users);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/result.jsp");
			dispatcher.forward(request, response);
		}else {
			String message = "xác nhận pass không đúng";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/changepassforgot.jsp");
			dispatcher.forward(request, response);
		}
	}

}
