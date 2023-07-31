package com.gradedproject.q1;

class HrDepartment extends SuperDepartment {
	  
	String departmentName(){
		return "Welcome to HR Department";
	}
	
	String getTodaysWork() {
		String s = "Complete Your document Submission";
		return s;
	}
	
	String getWorkDeadLine() {
		System.out.println("Fill today's timesheet and mark your attendence");
		return "Complete by Eod";
	}
	 
	String doActivity() {
		return "team Lunch";
	}
	
	
	

}
