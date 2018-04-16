package com.dinesh.parkingsystem;

import java.util.Scanner;
import com.dinesh.parkingsystem.textParser.TextParser;
import com.dinesh.parkingsystem.utill.Util;

public class Application {
	 
	
	 public static void main(String[] args) {
		 TextParser textParser = new TextParser();
		 if(0==args.length) {
		    Scanner scanner = new Scanner(System.in);
		    
		    System.out.println("Welcome to the Parking System..");
		    System.out.println("Enter 1 to process INTERACTIVE MODE.. ");
		    System.out.println("Enter 0 to close the system.. ");
		    System.out.println();
		    
		    while(true) {
		    	
			    String mode = scanner.next();
			    
			    if("1".equals(mode)) {
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
				    			if(values.length==2 && Util.isInteger(values[1])) {
				    				//create a lot
				    				textParser.createParkingLot(values[1]);
				    				
				    				while(true) {
				    					
					    				String parking = scanner.nextLine();
					    				String [] parkingArray = parking.split(" ");
					    				if("park".equalsIgnoreCase(parkingArray[0])) {
					    					//create a parking
					    					textParser.createParkingDetails(parkingArray[1], parkingArray[2]);
					    				}else if("leave".equalsIgnoreCase(parking.split(" ")[0])) {
					    					//create a leave
					    					textParser.createLeave(parkingArray[1]);
					    					
					    				}else if("status".equalsIgnoreCase(parking.split(" ")[0])) {
					    					//create a leave
					    					textParser.createStatus();
					    					
					    				}else if("registration_numbers_for_cars_with_colour".equalsIgnoreCase(parking.split(" ")[0])) {
					    					//create a leave
					    					textParser.searchDetsilsForAllCarsOfColour(parkingArray[1]);;
					    					
					    				}else if("slot_numbers_for_cars_with_colour".equalsIgnoreCase(parking.split(" ")[0])) {
					    					//create a leave
					    					textParser.searchAllSlotFromColor(parkingArray[1]);;
					    					
					    				}else if("slot_number_for_registration_number".equalsIgnoreCase(parking.split(" ")[0])) {
					    					//create a leave
					    					textParser.searchAllSlotFromRegNo(parkingArray[1]);;
					    					
					    				}else {
					    					System.out.println("Please try agian");
									    	System.out.println();
					    				}
				    				}
				    				
				    			}else {
				    			    System.out.println("Please try agian with correct slot");
							    	System.out.println();
				    			}
				    		}
			    		}else {
			    			System.out.println("Please try agian");
					    	System.out.println();
			    		}
			    	}
			    }else if("0".equals(mode)) {
			    	System.out.println("EXIT");
			    }else {
			    	System.out.println("Please try agian");
			    	System.out.println();
			    }
		    	
		    	
		    }
		    
	 }else if (1==args.length) {
		 textParser.parseFile(args[0]);
	 }
	 }

}