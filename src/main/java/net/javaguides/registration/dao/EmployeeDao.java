package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.javaguides.registration.model.Employee;
import net.javaguides.registration.model.User;

public class EmployeeDao {
	
	public int registerEmployee(Employee employee)throws ClassNotFoundException {
		
		String INSERT_USER_SQL = "INSERT INTO employee" + "(first_name,last_name,username,password,address,contact) VALUES "+"(?,?,?,?,?,?);";
		
		int result =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false","root","root")){
			
			PreparedStatement perparedstatement = connection.prepareStatement(INSERT_USER_SQL);
			//perparedstatement.setInt(1, 1);
			perparedstatement.setString(1, employee.getFirstname());
			perparedstatement.setString(2,employee.getLastname());
			perparedstatement.setString(3,employee.getUsername());
			perparedstatement.setString(4,employee.getPassword());
			perparedstatement.setString(5,employee.getAddress());
			perparedstatement.setString(6,employee.getContact());
			
			System.out.println(perparedstatement);
			result=perparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	//login database query
	public ResultSet loginUser(User user)throws ClassNotFoundException, SQLException{
		
		String LOGIN_QUERY="SELECT username,password from employee.employee where username="+"?"+"AND password="+"?"+";";
		
		ResultSet results = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false","root","root")){
			PreparedStatement perparedstatement = connection.prepareStatement(LOGIN_QUERY);
			perparedstatement.setString(1, user.getUsername());
			perparedstatement.setString(2,user.getPassword());
			System.out.println(perparedstatement);
			results=perparedstatement.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return results;
	}

}
