package com.hrms.usecases;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exceptions.EmployeeException;

public class UpdateEmployeePassword {

//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter Employee Id :");
//		int eid = sc.nextInt();
//		
//		System.out.println("Enter Employee New Password :");
//		String password = sc.next();
//		
//		EmployeeDao dao = new EmployeeDaoImpl();
//		
//		try {
//			String result = dao.updateEmployeepPassword(eid, password);
//			System.out.println(result);
//		} catch (EmployeeException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}

	public static void updatePassword() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id :");
		int eid = sc.nextInt();
		
		System.out.println("Enter Employee New Password :");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String result = dao.updateEmployeepPassword(eid, password);
			System.out.println(result);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
