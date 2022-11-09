package com.hrms.dao;

import java.util.List;

import com.hrms.exceptions.DepartmentException;
import com.hrms.model.Department;

public interface DepartmentDao {

	public String addDepartments(Department department) throws DepartmentException; 
	
	public List<Department> getAllDepartmentDetails() throws DepartmentException;
	
	public String updateDepartments(Department department) throws DepartmentException;
	
}
