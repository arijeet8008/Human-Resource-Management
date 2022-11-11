package com.hrms.application;

import java.util.Scanner;

import com.hrms.usecases.ApplyForLeave;
import com.hrms.usecases.GetEmployeeDetailsByID;
import com.hrms.usecases.UpdateEmployeeDetails;
import com.hrms.usecases.UpdateEmployeePassword;

public class EmployeeLink {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome Employee");
		System.out.println("=============");
		
		System.out.println("Press 1. For View Your Profile");
		System.out.println("=============");
		
		System.out.println("Press 2. For Update Your Profile");
		System.out.println("=============");
		
		System.out.println("Press 3. For Change Your Password");
		System.out.println("=============");
		
		System.out.println("Press 4. For Apply Leave Request");
		System.out.println("=============");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: {
			GetEmployeeDetailsByID.getFullProfileInfo();
			System.out.println();
			break;
		}
		case 2: {
			UpdateEmployeeDetails.updateProfile();
			System.out.println();
			break;
		}
		case 3: {
			UpdateEmployeePassword.updatePassword();
			System.out.println();
			break;
		}
		case 4: {
			ApplyForLeave.applyLeave();
			System.out.println();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
	}
	
}
