package com.hrms.application;

import java.util.Scanner;

import com.hrms.usecases.AcceptLeaveRequest;
import com.hrms.usecases.AddDepartments;
import com.hrms.usecases.PrintAllDepartments;
import com.hrms.usecases.PrintAllEmployeeDetails;
import com.hrms.usecases.RegisterEmployee;
import com.hrms.usecases.RejectLeaveRequest;
import com.hrms.usecases.TransferEmployeeDepartmnet;
import com.hrms.usecases.UpdateDepartments;

public class AdminLink {

//	public static void main(String[] args) {
	public static void loginAdmin() {
		
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Welcome Admin : +Arijeet");
			System.out.println("=============");
			
			System.out.println("Press 1. For Adding New Departments");
			System.out.println("=============");
			
			System.out.println("Press 2. view all Department ");
			System.out.println("=============");
			
			System.out.println("Press 3. Update The Department ");
			System.out.println("=============");
			
			System.out.println("Press 4. For Adding New Employees ");
			System.out.println("=============");
			
			System.out.println("Press 5. For View All Employee Profiles ");
			System.out.println("=============");
			
			System.out.println("Press 6. Transfer Employee To Other Department");
			System.out.println("=============");
			
			System.out.println("Press 7. Accept leaves Of Employess");
			System.out.println("=============");
			
			System.out.println("Press 8. Reject Leaves Of Employees");
			System.out.println("=============");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				AddDepartments.register();
				System.out.println();
				break;
			}
			case 2: {
				PrintAllDepartments.allDepartments();
				System.out.println();
				break;
			}
			case 3: {
				UpdateDepartments.updateDepartment();
				System.out.println();
				break;
			}
			case 4: {
				RegisterEmployee.addEmployee();
				System.out.println();
				break;
			}
			case 5: {
				PrintAllEmployeeDetails.viewAllProfiles();
				System.out.println();
				break;
			}
			case 6: {
				TransferEmployeeDepartmnet.transferEmployee();
				System.out.println();
				break;
			}
			case 7: {
				AcceptLeaveRequest.acceptLeave();
				System.out.println();
				break;
			}
			case 8: {
				RejectLeaveRequest.rejectleave();
				System.out.println();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		
	}
	
}
