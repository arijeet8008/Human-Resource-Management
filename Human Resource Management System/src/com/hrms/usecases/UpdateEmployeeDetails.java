package com.hrms.usecases;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exceptions.EmployeeException;
import com.hrms.model.Employee;

public class UpdateEmployeeDetails {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID :");
		int eid = sc.nextInt();
		
		System.out.println("Enter Employee Name :");
		String name = sc.next();
		
		System.out.println("Enter Employee Email :");
		String email = sc.next();
		
		System.out.println("Enter Employee Password :");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		Employee employee = new Employee();
		employee.setEid(eid);
		employee.setEname(name);
		employee.setEmail(email);
		employee.setPassword(password);
		
		try {
			String result = dao.updateEmployeeDetails(employee);
			System.out.println(result);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
