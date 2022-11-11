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

	@Override
	public String updateEmployeeDetails(Employee employee) throws EmployeeException {
		
		String result = "Incorrect Employee ID......";
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employee set ename=?,email=?,password=? where eid=?");
			
			ps.setString(1, employee.getEname());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getPassword());
			ps.setInt(4, employee.getEid());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				result = "Updated Sucessfully";
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return result;
		
	}

	@Override
	public Employee getEmployeeDetailsById(int eid) throws EmployeeException {
		
		Employee employee = null;
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid = ?");
			
			ps.setInt(1, eid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt("eid");
				String n = rs.getString("ename");
				String e = rs.getString("email");
				String p = rs.getString("password");
				int did = rs.getInt("empdid");
				
				employee = new Employee(id, n, e, p, did);
			}
			else
				throw new EmployeeException("Employe Doesnot Exist With ID : "+eid);
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
		
	}

	@Override
	public Employee loginEmployee(String username, String password) throws EmployeeException {
		
		Employee employee = null;
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where email=? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt("eid");
				String n = rs.getString("ename");
				String e = rs.getString("email");
				String p = rs.getString("password");
				int did = rs.getInt("empdid");
				
				employee = new Employee(id, n, e, p, did);				
			}
			
			else
				throw new EmployeeException("Incorrect Username or Password");
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
		
	}

	@Override
	public String updateEmployeepPassword(int eid, String password) throws EmployeeException {
		
		String message = "Incorrect Employee ID: "+eid;
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employee set password = ? where eid = ?");
			
			ps.setString(1, password);
			ps.setInt(2, eid);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				message = "Update Password Sucessfully";
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public String applyForLeave(int eid, String status) throws EmployeeException {
		
		String message = "Incorrect Employee ID: "+eid;
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into leave_request(eid,status) values(?,?)");
			
			ps.setInt(1, eid);
			ps.setString(2, status);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				message = "Insert Data Sucessfully";
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public String acceptLeave(int eid) throws EmployeeException {
		
		String message = "Incorrect Employee ID: "+eid;
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update leave_request set status = 'Approved' where eid = ?");
			
			ps.setInt(1, eid);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				message = "Leave Request Accepted...";
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String rejectLeave(int eid) throws EmployeeException {
		
		String message = "Incorrect Employee ID: "+eid;
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update leave_request set status = 'Rejected' where eid = ?");
			
			ps.setInt(1, eid);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				message = "Leave Request Rejected...";
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
		
	}

}
