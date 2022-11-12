package com.hrms.application;

import java.util.Scanner;

import com.hrms.usecases.LoginEmployee;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome To Human Resource Management System");
		System.out.println("============");
		System.out.println("Press 1 for login as ADMIN");
		System.out.println("============");
		System.out.println("Press 2 for login as EMPLOYEE");
		System.out.println("============");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch (choice) {
		
		case 1: {
			
			System.out.println("Enter username");
			String username = sc.next();
			
			System.out.println("Enter password");
			String password = sc.next();
			
			if(username.equals("admin")  && password.equals("admin")) {
				AdminLink.loginAdmin();
			}		
			else
				System.out.println("Incorrect Username or Password");
			
			break;
		}
		
		case 2: {
			
			LoginEmployee.loginEmployee();
			break;
			
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
	}

}
