package com.hrms.usecases;

import java.util.List;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exceptions.EmployeeException;
import com.hrms.model.Employee;

public class PrintAllEmployeeDetails {

//	public static void main(String[] args) {
//		
//		EmployeeDao dao = new EmployeeDaoImpl();
//		
//		try {
//			List<Employee> employee = dao.allEmployeeDetails();
//			
//			for (Employee e : employee) {
//				System.out.println("Employee ID : " +e.getEid());
//				System.out.println("Employee Name : "+e.getEname());
//				System.out.println("Employee Email : "+e.getEmail());
//				System.out.println("Employee Password : "+e.getPassword());
//				System.out.println("Employee Department ID : "+e.getEmpdid());
//				System.out.println("===================");
//			}
//			
//		} catch (EmployeeException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
	
	public static void viewAllProfiles() {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			List<Employee> employee = dao.allEmployeeDetails();
			
			for (Employee e : employee) {
				System.out.println("Employee ID : " +e.getEid());
				System.out.println("Employee Name : "+e.getEname());
				System.out.println("Employee Email : "+e.getEmail());
				System.out.println("Employee Password : "+e.getPassword());
				System.out.println("Employee Department ID : "+e.getEmpdid());
				System.out.println("===================");
			}
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
