package com.imcs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.imcs.constants.AppConstants;
import com.imcs.dto.EmployeeDTO;
import com.imcs.services.EmployeesInfo;

public class Tester {

	public static void main(String[] args) throws Exception {
		
		
		EmployeesInfo e = new EmployeesInfo();
		
//		e.addEmployeeInfo(204, "Santos", "Jaisi", "sJaisi@gmail.com");
//		e.removeEmployeeInfo("204");
//		e.updateEmployeeInfo("509", "Anuska", "Karki", "gorgeousanuska@gmail.com");
//		EmployeeDTO emp = e.getEmployeeInfo("509");
//		System.out.println(emp);
		
		
		List<EmployeeDTO> em = e.getAllEmployeeInfo();
		
		for (EmployeeDTO employeeDTO : em) {
			System.out.println(employeeDTO);
			System.out.println("********************");
		}	
	
	}

}
