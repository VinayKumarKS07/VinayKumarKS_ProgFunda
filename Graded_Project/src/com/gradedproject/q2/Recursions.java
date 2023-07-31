package com.gradedproject.q2;
import java.util.*;
public class Recursions {
    int powercalculation(int a ,int b) {
    	if(b==0) {
    		return 1;
    	}
    	return powercalculation(a,b-1)*a;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Recursions obj = new Recursions();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the base number X:");
		int a = sc.nextInt();
		System.out.print("Enter the power N=");
		int b = sc.nextInt();
		System.out.println(obj.powercalculation(a, b));		
		
		

	}

}
