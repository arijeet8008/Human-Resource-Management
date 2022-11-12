package com.hrms.usecases;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exceptions.EmployeeException;

public class TransferEmployeeDepartmnet {

//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter Employee ID :");
//		int edid = sc.nextInt();
//		
//		System.out.println("Enter Employee Department ID :");
//		int empdid = sc.nextInt();
//		
//		EmployeeDao dao = new EmployeeDaoImpl();
//		
//		try {
//			String result = dao.transferEmployee(edid, empdid);
//			System.out.println(result);
//		} catch (EmployeeException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
	
	
	public static void transferEmployee() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID :");
		int edid = sc.nextInt();
		
		System.out.println("Enter Employee Department ID :");
		int empdid = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String result = dao.transferEmployee(edid, empdid);
			System.out.println(result);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
