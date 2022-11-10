package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Employee> allEmployeeDetails() throws EmployeeException {
		
		List<Employee> employees = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				String n = rs.getString("ename");
				String e = rs.getString("email");
				String p = rs.getString("password");
				int edid = rs.getInt("empdid");
				
				employees.add(new Employee(eid, n, e, p, edid));
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(employees.size() == 0)
			throw new EmployeeException("No Records Found");
		
		return employees;
		
	}

}
