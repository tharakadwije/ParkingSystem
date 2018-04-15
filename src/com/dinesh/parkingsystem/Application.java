package com.dinesh.parkingsystem;

import java.util.Scanner;

public class Application {
	 
	
	 public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);

		    
		    System.out.println("Welcome to the Parking System..");
		    System.out.println("Enter 1 to process with FILE MODE.. ");
		    System.out.println("Enter 2 to process INTERACTIVE MODE.. ");
		    System.out.println("Enter 0 to close the system.. ");
		    
		    while(true) {
		    	
			    String mode = scanner.next();
			    
			    if("1".equals(mode)) {
			    	System.out.println("You have selected FILE MODE");	
			    	
			    } else if("2".equals(mode)) {
			    	System.out.println("You have selected INTERACTIVE MODE");	
			    	
			    }else if("0".equals(mode)) {
			    	System.out.println("EXIT");
			    	break;
			    }else {
			    	System.out.println("Please try agian");	
			    }
		    	
		    	
		    	
		    }
		    
		 
	 }

}
