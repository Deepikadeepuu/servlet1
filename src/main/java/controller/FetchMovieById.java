package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;

@WebServlet("/fetch-movies-id")
public class FetchMovieById extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("enter-id.html").forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int Id=Integer.parseInt(req.getParameter("id"));
		
		MovieDao dao= new MovieDao();
		List<MovieDao> list=dao.fetchMoviesById(Id);
		if(list.isEmpty()) {
			resp.getWriter().print("<h1 style='color:red' align='center'>No Movies Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
			
		}else {
			req.setAttribute("list",list);
			req.getRequestDispatcher("fetch.jsp").forward(req, resp);
		}
	}
}
