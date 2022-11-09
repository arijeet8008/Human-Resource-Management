package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
