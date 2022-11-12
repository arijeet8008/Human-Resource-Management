package com.hrms.usecases;

import java.util.Scanner;

import com.hrms.dao.DepartmentDao;
import com.hrms.dao.DepartmentDaoImpl;
import com.hrms.exceptions.DepartmentException;
import com.hrms.model.Department;

public class UpdateDepartments {

//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter Department ID :");
//		int did = sc.nextInt();
//		
//		System.out.println("Enter Department Name :");
//		String dname = sc.next();
//		
//		Department department = new Department(did, dname);
//		
//		DepartmentDao dao = new DepartmentDaoImpl();
//		
//		try {
//			String res = dao.updateDepartments(department);
//			System.out.println(res);
//		} catch (DepartmentException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
	
	public static void updateDepartment() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Department ID :");
		int did = sc.nextInt();
		
		System.out.println("Enter Department Name :");
		String dname = sc.next();
		
		Department department = new Department(did, dname);
		
		DepartmentDao dao = new DepartmentDaoImpl();
		
		try {
			String res = dao.updateDepartments(department);
			System.out.println(res);
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
