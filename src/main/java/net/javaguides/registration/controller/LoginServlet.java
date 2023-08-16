package net.javaguides.registration.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employee;
import net.javaguides.registration.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao employeedao =new EmployeeDao();
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u_name=request.getParameter("username");
		String P_word=request.getParameter("password");
		
		//System.out.println(u_name+"\n"+P_word);
		
		//Employee employee1 =new Employee();
		User user1=new User();
		
		user1.setUsername(u_name);
		user1.setPassword(P_word);
		ResultSet flag=null;
		try {
			flag=employeedao.loginUser(user1);
			System.out.println(flag);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String validate="Result set representing update count of -1";
		if(flag.toString().equals(validate)) {
			System.out.println("Login");
			request.getSession().invalidate();
			HttpSession newsession = request.getSession(true);
			newsession.setMaxInactiveInterval(300);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/memberArea.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("/WEB-INF/views/memberArea.jsp");
			//response.getWriter().print("<h1>You are succesfully login</h1>");
		}else {
			System.out.println("Login fail");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("/WEB-INF/views/login.jsp");
			//response.getWriter().print("<h1>Invalid user credential :( </h1>");
		}
		//doGet(request, response);
	}

}
