package com.gradedproject.q1;

class TechDepartment extends SuperDepartment {
	
	String departmentName() {
		return "Welcome to Tech Department";
	}
	
	String getTodaysWork() {
		return "Complete coding of module 1";
	}
	
	String getWorkDeadline() {
		System.out.println("Complete coding of Module 1");
		return "Complete by EOD";
		
	}
	
	String getTechStackInformation() {
		return "core java";
	}

}
