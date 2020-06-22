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
import com.ute.rental.dao.CustumerDAO;

/**
 * Servlet implementation class UpdateInforUserCodeServlet
 */
@WebServlet(name = "updateInforUserCode", urlPatterns = { "/updateInforUserCode" })
public class UpdateInforUserCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInforUserCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//String  code = request.getParameter("code");
		String  inputCode = request.getParameter("codeinput");
		HttpSession session = request.getSession();
		Custumer custumer =  (Custumer) session.getAttribute("custumer");
		String code = (String) session.getAttribute("content");
		String result = "Incorrect Code !";
		if(code.equals(inputCode)) {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			CustumerDAO dao = new CustumerDAO();
			dao.updateCustumer(custumer);
			response.sendRedirect(request.getContextPath() + "/updateInfoUser");
		}else {
			//session.setAttribute("custumer", custumer);
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("content", code);
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = 
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/updateInforUserCode.jsp");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}

}
