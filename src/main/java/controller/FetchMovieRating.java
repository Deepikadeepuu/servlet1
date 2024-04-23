package controller;


import dao.MovieDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch-movie-rating")
public class FetchMovieRating extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("enter-rating.html").forward(req, resp);
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			double rating=Double.parseDouble(req.getParameter("rating"));
			
			MovieDao dao= new MovieDao();
			List<MovieDao> list=dao.fetchMoviesByRating(rating);
			if(list.isEmpty()) {
				resp.getWriter().print("<h1 style='color:red' align='center'>No Movies Found</h1>");
				req.getRequestDispatcher("home.html").include(req, resp);
				
			}else {
				req.setAttribute("list",list);
				req.getRequestDispatcher("fetch.jsp").forward(req, resp);
			}
		}
}
