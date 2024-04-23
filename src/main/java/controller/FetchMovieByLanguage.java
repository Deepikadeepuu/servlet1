package controller;

import dao.MovieDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch-movie-language")
public class FetchMovieByLanguage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("enter-language.html").forward(req, resp);
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String language=req.getParameter("language");
			
			MovieDao dao= new MovieDao();
			List<MovieDao> list=dao.FetchMovieByLanguage(language);
			if(list.isEmpty()) {
				resp.getWriter().print("<h1 style='color:red' align='center'>No Movies Found</h1>");
				req.getRequestDispatcher("home.html").include(req, resp);
				
			}else {
				req.setAttribute("list",list);
				req.getRequestDispatcher("fetch.jsp").forward(req, resp);
			}
		}
}

