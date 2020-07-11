package com.ute.rental.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthencationFilter
 */
@WebFilter({ "/homeuser"})
public class AuthencationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthencationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpreq =(HttpServletRequest) request;
		HttpSession session = httpreq.getSession(false);
		HttpServletResponse httResponse = (HttpServletResponse) response;
		httResponse.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		//httResponse.setHeader("Cache-Control","no-store");
		httResponse.setHeader("Pragma","no-cache");
		httResponse.setHeader ("Expires", "0");
		if(session != null && session.getAttribute("user_current") != null) {
			chain.doFilter(request, response);
		}else {
			RequestDispatcher dispatcher = httpreq.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
