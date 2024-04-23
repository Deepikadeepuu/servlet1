package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter({"/fetch-movies","/delete-movie","/edit-movie","/fetch-movie-rating","/fetch-movie-genre","/fetch-movie-id","/fetch-movie-language","/fetch-movie-name","/insert-movie",})
public class MyLoginFiltter implements Filter
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		if(req.getSession().getAttribute("x")!=null) {
			chain.doFilter(request, response);
		}else {
			response.getWriter().print("<h1 align='center' style='color:red'>Invalid Session</h1>");
			req.getRequestDispatcher("Login.html").include(req, response);
		}
	}

}
