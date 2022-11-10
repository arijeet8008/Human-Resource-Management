package com.hrms.dao;

import java.util.List;

import com.hrms.exceptions.EmployeeException;
import com.hrms.model.Employee;

public interface EmployeeDao {

	public String registerEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> allEmployeeDetails() throws EmployeeException;
	
}
