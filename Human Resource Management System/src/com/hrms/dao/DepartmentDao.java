package com.hrms.dao;

import com.hrms.exceptions.DepartmentException;
import com.hrms.model.Department;

public interface DepartmentDao {

	public String addDepartments(Department department) throws DepartmentException; 
	
}
