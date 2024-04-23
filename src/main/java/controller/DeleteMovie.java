package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;

@WebServlet("/delete-movie")
public class DeleteMovie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		MovieDao dao = new MovieDao();
		dao.deleteMovie(id);
		resp.getWriter().print("<h1 align='center' style='color:green'>Movie Removed Success</h1>");
		req.getRequestDispatcher("home.html").include(req, resp);
	}
}


//using error page we can handle error in two ways
//
//-Based on error code
//-Based Exception type
//
//
//ERROR PAGE 
//-404=Not Found
//500=Intenal Server error
//405=method not avialable /mismatch

//cookies
//cookies is a piece of information stored in the broweser 
//In java we can create cookie by 
//Cookie cookie=new Cookie("key",value);
//
//How to send the cookie
//-res.addCookie(cookie)
//
//-How to recive the cookie
//req.getCookie();-we can have more than  one values-return type -multiple
//
//-DrawBack of cookies
//-cookies can hold only just String information 
//-it can be used only in the case of send.redirect
//
//
//Note-
//-cookie can be mainly use for client side session,Tracking