package net.javaguides.registration.controller;

import java.io.IOException;

import javax.el.ELResolver;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao employeedao =new EmployeeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//
		String firstname= request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		String usernamr= request.getParameter("username");
		String password= request.getParameter("password");
		String address= request.getParameter("address");
		String contact= request.getParameter("contact");
		
		Employee employee =new Employee();
		
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setUsername(usernamr);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);
		
		try {
			employeedao.registerEmployee(employee);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			ELResolver el;
			
			//request.setAttribute("variable", firstname);
			System.out.println(firstname);
//			response.getWriter().print("<h1>you are successfully login!!!</h1><br>"
//			+"<form action=\"<%=request.getContextPath()%>/LoginServlet\" method=\"get\">"
//			+"<button type=\"submit\">Login</button>"
//			+"</form>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
		dispatcher.forward(request, response);
		//doGet(request, response);
		}
	}

}
