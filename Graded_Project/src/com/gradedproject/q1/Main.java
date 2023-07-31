package com.gradedproject.q1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperDepartment S_Dept = new SuperDepartment();
		HrDepartment Hr_Dept = new HrDepartment();
		AdminDepartment Admin = new AdminDepartment();
		TechDepartment Tech = new TechDepartment();
		
		System.out.println(Admin.departmentName());
		System.out.println(Admin.getTodaysWork());
		System.out.println(Admin.getWorkDeadline());
		System.out.println(Admin.isTodayAHoliday());
		
		System.out.println();
		
	    System.out.println(Hr_Dept.departmentName());
	    System.out.println(Hr_Dept.doActivity());
	    System.out.println(Hr_Dept.getWorkDeadLine());
	    System.out.println(Hr_Dept.isTodayAHoliday());
	    
	    System.out.println();
	    
	    System.out.println(Tech.departmentName());
	    System.out.println(Tech.getWorkDeadline());
//	    System.out.println(Tech.departmentName());
	    System.out.println(Tech.getTechStackInformation());
	    System.out.println(Tech.isTodayAHoliday());
	}

}
