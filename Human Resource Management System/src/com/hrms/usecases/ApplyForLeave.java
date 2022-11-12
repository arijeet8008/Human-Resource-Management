package com.hrms.usecases;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exceptions.EmployeeException;

public class ApplyForLeave {

//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter Employee Id For Leave Request :");
//		int eid = sc.nextInt();
//		
//		System.out.println("Type -Applied- For Apply Leave Request  :");
//		String apply = sc.next();
//		
//		EmployeeDao dao = new EmployeeDaoImpl();
//		
//		try {
//			String result = dao.applyForLeave(eid, apply);
//			System.out.println(result);
//		} catch (EmployeeException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}

	public static void applyLeave() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id For Leave Request :");
		int eid = sc.nextInt();
		
		System.out.println("Type -Applied- For Apply Leave Request  :");
		String apply = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String result = dao.applyForLeave(eid, apply);
			System.out.println(result);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
