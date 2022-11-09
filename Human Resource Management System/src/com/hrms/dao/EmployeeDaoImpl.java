package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hrms.exceptions.EmployeeException;
import com.hrms.model.Employee;
import com.hrms.utility.DBUtill;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(Employee employee) throws EmployeeException {
		
		String result = "Not Inserted.....";
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee(ename,email,password,empdid) values(?,?,?,?)");
			
			ps.setString(1, employee.getEname());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getPassword());
			ps.setInt(4, employee.getEid());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				result = "Employee Enrolled Sucessfully........";
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException();
		}
		
		return result;
		
	}

}
