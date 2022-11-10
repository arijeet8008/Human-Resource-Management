package com.hrms.usecases;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exceptions.EmployeeException;
import com.hrms.model.Employee;

public class GetEmployeeDetailsByID {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID :");
		int eid = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			
			Employee employee = dao.getEmployeeDetailsById(eid);
			
			System.out.println("Employee Name : "+employee.getEname());
			System.out.println("Employee Email : "+employee.getEmail());
			System.out.println("Employee Password : "+employee.getPassword());
			System.out.println("Employee Department ID : "+employee.getEmpdid());
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}

	}

}
