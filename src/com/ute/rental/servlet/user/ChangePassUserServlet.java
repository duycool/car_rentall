package com.ute.rental.servlet.user;

import java.io.IOException;

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
import com.ute.rental.dao.UserDAO;

/**
 * Servlet implementation class ChangePassUserServlet
 */
@WebServlet(name = "changePassUser", urlPatterns = { "/changePassUser" })
public class ChangePassUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		int userid = Integer.parseInt(request.getParameter("iduser"));
		String pass = request.getParameter("passold");
		String passnew = MethodDAO.hashPass(request.getParameter("newpass"));
		UserDAO userDAO = new UserDAO();
		Users user = userDAO.getUser(userid);
		String passdatabase = user.getPasswords();
		String message = "Pass cũ không đúng vui lòng nhập lại";
		if(MethodDAO.checkHashPass(pass, passdatabase)) {
			user.setPasswords(passnew);
			user.setUserid(userid);
			userDAO.updatePassUser(user);
			response.sendRedirect(request.getContextPath() + "/homeuser");			
		}else {					
			request.setAttribute("user", user);
			request.setAttribute("message", message);
			CustumerDAO custumerDAO = new CustumerDAO();
			Custumer custumer = custumerDAO.getCustumer(userid);
			request.setAttribute("custumer",custumer);
			RequestDispatcher dispacher = 
						this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/updateInforUser.jsp");
			dispacher.forward(request, response);
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
