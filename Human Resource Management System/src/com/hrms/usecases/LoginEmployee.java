package com.hrms.usecases;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exceptions.EmployeeException;
import com.hrms.model.Employee;

public class LoginEmployee {

//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter Your Email :");
//		String email = sc.next();
//		
//		System.out.println("Enter Your Password :");
//		String password = sc.next();
//		
//		EmployeeDao dao = new EmployeeDaoImpl();
//		
//		try {
//			Employee employee = dao.loginEmployee(email, password);
//			System.out.println("Welcome : "+employee.getEname());
//		} catch (EmployeeException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
	
	public static void loginEmployee() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Email :");
		String email = sc.next();
		
		System.out.println("Enter Your Password :");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			Employee employee = dao.loginEmployee(email, password);
			System.out.println("Welcome : "+employee.getEname());
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
