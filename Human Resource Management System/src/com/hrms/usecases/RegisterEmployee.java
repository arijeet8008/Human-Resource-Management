package com.hrms.usecases;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exceptions.EmployeeException;
import com.hrms.model.Employee;

public class RegisterEmployee {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Name :");
		String name = sc.next();
		
		System.out.println("Enter Employee Email :");
		String email = sc.next();
		
		System.out.println("Enter Employee Password :");
		String password = sc.next();
		
		System.out.println("Enter Employee Department ID :");
		int empdid = sc.nextInt();
		
		Employee employee = new Employee();
		employee.setEname(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setEid(empdid);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String result = dao.registerEmployee(employee);
			System.out.println(result);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
