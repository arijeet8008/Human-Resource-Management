package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.exceptions.DepartmentException;
import com.hrms.model.Department;
import com.hrms.utility.DBUtill;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public String addDepartments(Department department) throws DepartmentException {
		
		String result = "Not Inserted.....";
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into department(did,dname) values(?,?)");
			
			ps.setInt(1, department.getDid());
			ps.setString(2, department.getDname());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				result = "Department Added Sucessfully........";
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		
		return result;
		
	}

	@Override
	public List<Department> getAllDepartmentDetails() throws DepartmentException {
		
		List<Department> departments = new ArrayList<>();
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from department");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int did = rs.getInt("did");
				String dname = rs.getString("dname");
				
				departments.add(new Department(did, dname));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		
		if(departments.size() == 0)
			throw new DepartmentException("No Employee Data Found");
		
		return departments;
		
	}

	@Override
	public String updateDepartments(Department department) throws DepartmentException {
		
		String result = "Updated Sucessfully";
		
		try (Connection conn = DBUtill.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update department set dname = ? where did = ?");
			
			ps.setString(1,department.getDname() );
			ps.setInt(2, department.getDid());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				result = "Department Updated Sucessfully.......";
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		
		return result;
		
	}

}
