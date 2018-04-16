package com.dinesh.parkingsystem.textParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.dinesh.parkingsystem.model.Car;
import com.dinesh.parkingsystem.utill.Util;


public class TextParser {

	protected ArrayList<Integer> availableSlotList;
	protected Map<String, Car> mapCar;
    protected Map<String, String> mapRegNumber;
    protected Map<String, ArrayList<String>> mapDetailSlot;
    protected int lotSize = 0;
    
    public void createParkingLot(String lotSize) {
        this.lotSize= Integer.parseInt(lotSize);
        this.availableSlotList = new ArrayList<Integer>() {};
        for (int i=1; i<= this.lotSize; i++) {
            availableSlotList.add(i);
        }
        this.mapCar = new HashMap<String, Car>();
        this.mapRegNumber = new HashMap<String, String>();
        this.mapDetailSlot = new HashMap<String, ArrayList<String>>();
        System.out.println("Created parking lot with " + lotSize + " slots");
        System.out.println();
    }
    
    public void createParkingDetails(String regNumber, String color) {
        if (this.lotSize == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.mapCar.size() == this.lotSize) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(availableSlotList);
            String slot = availableSlotList.get(0).toString();
            Car car = new Car(regNumber, color);
            this.mapCar.put(slot, car);
            this.mapRegNumber.put(regNumber, slot);
            if (this.mapDetailSlot.containsKey(color)) {
                ArrayList<String> regNoList = this.mapDetailSlot.get(color);
                this.mapDetailSlot.remove(color);
                regNoList.add(regNumber);
                this.mapDetailSlot.put(color, regNoList);
            } else {
                ArrayList<String> regNoList = new ArrayList<String>();
                regNoList.add(regNumber);
                this.mapDetailSlot.put(color, regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlotList.remove(0);
        }
    }
    
    public void createLeave(String slotNumber) {
        if (this.lotSize == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.mapCar.size() > 0) {
            Car carToLeave = this.mapCar.get(slotNumber);
            if (carToLeave != null) {
                this.mapCar.remove(slotNumber);
                this.mapCar.remove(carToLeave.getRegNo());
                ArrayList<String> regNoList = this.mapDetailSlot.get(carToLeave.getColor());
                if (regNoList.contains(carToLeave.getRegNo())) {
                    regNoList.remove(carToLeave.getRegNo());
                }
                // Add the Lot No. back to available slot list.
                this.availableSlotList.add(Integer.parseInt(slotNumber));
                System.out.println("Slot number " + slotNumber + " is free");
                System.out.println();
            } else {
                System.out.println("Slot number " + slotNumber + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }

	public void createStatus() {
	        if (this.lotSize == 0) {
	            System.out.println("Sorry, parking lot is not created");
	            System.out.println();
	        } else if (this.mapCar.size() > 0) {
	            // Print the current status.
	            System.out.println("Slot No.\t Registration No \tColor");
	            Car car;
	            for (int i = 1; i <= this.lotSize; i++) {
	                String key = Integer.toString(i);
	                if (this.mapCar.containsKey(key)) {
	                    car = this.mapCar.get(key);
	                    System.out.println(i + "\t" + car.getRegNo() + "\t" + car.getColor());
	                }
	            }
	            System.out.println();
	        } else {
	            System.out.println("Parking lot is empty");
	            System.out.println();
	        }
	}
	
	public void searchDetsilsForAllCarsOfColour(String color) {
        if (this.lotSize == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.mapDetailSlot.containsKey(color)) {
            ArrayList<String> regNoList = this.mapDetailSlot.get(color);
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                if (!(i==regNoList.size() - 1)){
                    System.out.print(regNoList.get(i) + ",");
                } else {
                    System.out.print(regNoList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
	
	 public void searchAllSlotFromColor(String color) {
	        if (this.lotSize == 0) {
	            System.out.println("Sorry, parking lot is not created");
	            System.out.println();
	        } else if (this.mapDetailSlot.containsKey(color)) {
	            ArrayList<String> regNoList = this.mapDetailSlot.get(color);
	            ArrayList<Integer> slotList = new ArrayList<Integer>();
	            System.out.println();
	            for (int i=0; i < regNoList.size(); i++) {
	                slotList.add(Integer.valueOf(this.mapRegNumber.get(regNoList.get(i))));
	            }
	            Collections.sort(slotList);
	            for (int j=0; j < slotList.size(); j++) {
	                if (!(j == slotList.size() - 1)) {
	                    System.out.print(slotList.get(j) + ",");
	                } else {
	                    System.out.print(slotList.get(j));
	                }
	            }
	            System.out.println();
	        } else {
	            System.out.println("Not found");
	            System.out.println();
	        }
	    }
	
	 public void searchAllSlotFromRegNo(String regNo) {
	        if (this.lotSize == 0) {
	            System.out.println("Sorry, parking lot is not created");
	            System.out.println();
	        } else if (this.mapRegNumber.containsKey(regNo)) {
	            System.out.println(this.mapRegNumber.get(regNo));
	        } else {
	            System.out.println("Not found");
	            System.out.println();
	        }
	    }
	 
	 public void parseFile(String file) {
	        File inputFile = new File(file);
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(inputFile));
	            String line;
	            try {
	                while ((line = br.readLine()) != null) {
	                	//
	                	String[] values = line.split(" ");
	                	if("create_parking_lot".equalsIgnoreCase(values[0])) {
					    	
	                		if(values.length==2 && Util.isInteger(values[1])) {
			    				//create a lot
			    				createParkingLot(values[1]);
			    				
			    				
			    				while(true) {
			    					
			    					String parking;
			    					if((parking = br.readLine()) != null) {

			    					String [] parkingArray = parking.split(" ");
				    				if("park".equalsIgnoreCase(parkingArray[0])) {
				    					//create a parking
				    					createParkingDetails(parkingArray[1], parkingArray[2]);
				    				}else if("leave".equalsIgnoreCase(parking.split(" ")[0])) {
				    					//create a leave
				    					createLeave(parkingArray[1]);
				    					
				    				}else if("status".equalsIgnoreCase(parking.split(" ")[0])) {
				    					//create a leave
				    					createStatus();
				    					
				    				}else if("registration_numbers_for_cars_with_colour".equalsIgnoreCase(parking.split(" ")[0])) {
				    					//create a leave
				    					searchDetsilsForAllCarsOfColour(parkingArray[1]);;
				    					
				    				}else if("slot_numbers_for_cars_with_colour".equalsIgnoreCase(parking.split(" ")[0])) {
				    					//create a leave
				    					searchAllSlotFromColor(parkingArray[1]);;
				    					
				    				}else if("slot_number_for_registration_number".equalsIgnoreCase(parking.split(" ")[0])) {
				    					//create a leave
				    					searchAllSlotFromRegNo(parkingArray[1]);;
				    					
				    				}
			    				 }
			    				}
			    				
			    			}
			    		}
	                	
	                	///
	                   
	                }
	            } catch (IOException ex) {
	                System.out.println("Error in reading the input file.");
	                ex.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found in the path specified.");
	            e.printStackTrace();
	        }
	    }
	 
}
