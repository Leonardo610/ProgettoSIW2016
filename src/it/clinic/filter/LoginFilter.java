package it.clinic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/loginAdmin.jsp")
public class LoginFilter implements Filter {
	private ServletContext application;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if (session.getAttribute("username")!=null) { //se l'utente è già autenticato
			RequestDispatcher rd  = this.application.getRequestDispatcher("./admin.jsp");
			rd.forward(request, response);	
		}
		else {
			chain.doFilter(request, response);
		}
	}


	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.application = fConfig.getServletContext();
	}



}
