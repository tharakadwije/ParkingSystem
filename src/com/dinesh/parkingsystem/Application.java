package com.dinesh.parkingsystem;

import java.util.Scanner;

import com.dinesh.parkingsystem.textParser.InputHandler;
import com.dinesh.parkingsystem.utill.Util;

public class Application {
	 
	
	 public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);

		    
		    System.out.println("Welcome to the Parking System..");
		    System.out.println("Enter 1 to process with FILE MODE.. ");
		    System.out.println("Enter 2 to process INTERACTIVE MODE.. ");
		    System.out.println("Enter 0 to close the system.. ");
		    System.out.println();
		    
		    while(true) {
		    	
			    String mode = scanner.next();
			    
			    if("1".equals(mode)) {
			    	System.out.println("You have selected FILE MODE");	
			    	System.out.println();
			    } else if("2".equals(mode)) {
			    	System.out.println("You have selected INTERACTIVE MODE");
			    	System.out.println();
			    	
			    	String input = scanner.nextLine();
			    	
			    	if(scanner.hasNext()) {
			    	String input1 = scanner.nextLine();

			    		if(input1!=null && !input1.equals("")) {
			    			String[] values = input1.split(" ");
			    		
				    		if(!"create_parking_lot".equalsIgnoreCase(values[0])) {
				    			System.out.println("Please try agian");
						    	System.out.println();
						    	
				    		}else{
				    			if(Util.isInteger(values[1])) {
				    				InputHandler.handleInteractiveMode(input1);
				    			}else {
				    			    System.out.println("Please try agian with correct slot");
							    	System.out.println();
				    			}
				    		}
			    		}else {
			    			System.out.println("Please try agian");
					    	System.out.println();
			    		}
			    /*	}else {
		    			System.out.println("Please try agian");
				    	System.out.println();
		    		}*/
			    	}
			    }else if("0".equals(mode)) {
			    	System.out.println("EXIT");
			    	break;
			    }else {
			    	System.out.println("Please try agian");
			    	System.out.println();
			    }
		    	
		    	
		    	
		    }
		    
		 
	 }

}
