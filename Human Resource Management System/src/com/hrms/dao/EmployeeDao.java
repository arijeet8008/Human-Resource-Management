package com.hrms.dao;

import com.hrms.exceptions.EmployeeException;
import com.hrms.model.Employee;

public interface EmployeeDao {

	public String registerEmployee(Employee employee) throws EmployeeException;
	
}
