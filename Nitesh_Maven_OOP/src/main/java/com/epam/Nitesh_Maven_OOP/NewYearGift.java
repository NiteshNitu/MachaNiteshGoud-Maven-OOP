package com.epam.Nitesh_Maven_OOP;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.epam.Nitesh.giftItems.Sweet;


public class NewYearGift {
	
    public static void main(String[] args) {
    	try {
	        Scanner scanner = new Scanner(System.in);
	        int choice = 0, type;
	        
	        System.out.println("<--! WELCOME TO EPAM NEW YEAR'S GIFT PROJECT !-->\n");
	        
	        GiftAnalysis gift = new GiftAnalysis();
	        ArrayList<Sweet> gifts = new ArrayList<Sweet>();
	        // Adding Demo Gifts
	        gifts.add(gift.addDemoGift());
	        
	        while(choice != 5) {
	        	
		        System.out.println(
		        		"Total weight of children's gift: " + getTotalWeight(gifts) + " grams\n"
		        		+ "Total Cost of childern's gift: ₹" + getTotalCost(gifts) + " /- \n\n"
		        		+ "			<--! MENU !-->\n"
		        		+"Enter 1 to add new gift :\n" 
		        		+ "Enter 2 to view all candies (high-low/low-high) cost :\n"
		        		+ "Enter 3 to view all chocolates (high-low/low-high) cost :\n"
		        		+ "Enter 4 to view items in specified cost range(X-Y) :\n"
		        		+ "Enter 5 to EXIT :\n"
		        		);
		        choice = scanner.nextInt();
		        if(choice == 5) {
		        	break;
		        }
		        switch(choice) {
		        	case 1:
		        		gifts.add(gift.addGift()); // goes to addGift() in GiftAnalysis Class
		        		break;
		        	case 2:
		        		System.out.println("Enter 1 to get High-Low Cost Candies\n"
		        							+ "Enter 2 to get Low-High Cost Candies");
		        		type = scanner.nextInt();
		        		for(Sweet sweet: gifts)
		        			gift.getCandies(sweet, type);  // goes to getCandies() in GiftAnalysis Class
		        		break;
		        	case 3:
		        		System.out.println("Enter 1 to get High-Low Cost Chocolates\n"
								+ "Enter 2 to get Low-High Cost Chocolates");
		        		type = scanner.nextInt();
		        		for(Sweet sweet: gifts) 
		        			gift.getChocolates(sweet, type); // goes to getChocolates() in GiftAnalysis Class
		        		break;
		        	case 4:
		        		System.out.println("Select range type:\n"
					        				+ "1. Cost\n"
					        				+ "2. Weight");
		        		type = scanner.nextInt();
		        		int lower_bound, upper_bound;
		        		System.out.println("Enter (lower bound & upper bound)");
		        		lower_bound = scanner.nextInt();
		        		upper_bound = scanner.nextInt();
		        		
		        		for(Sweet sweet: gifts)	
		        			gift.calRange(sweet, type, lower_bound, upper_bound);  // goes to calRange() in GiftAnalysis Class
		        		break;
		    		default:
		    			System.out.println("Please Choose a Valid Option...\n");
		        }
		     
		        System.out.println("\n=> Would You Like To Continue? (y/n)\n");
		        char cont = scanner.next().charAt(0);
		        if(cont == 'y' || cont == 'Y') {
		        	continue;
		        }
	        }
	    	System.out.println("Exited!!!");
	        scanner.close();
    	} catch(InputMismatchException e) {
    		System.out.println("InputMismatch Exception Occurred\n"
    				+ "Enter Valid Input to avoid Exception");
    	}
    	catch(Exception e) {
    		System.out.println("Exception " + e + " Occurred");
    	}
    }
    
    // returns the total weight of all the sweets
    public static double getTotalWeight(ArrayList<Sweet> sweets) {
    	double totalWeight = 0;
    	for(Sweet sweet: sweets) {
    		totalWeight += sweet.getTotalWeight();
    	}
    	return totalWeight;
    }
    
    // returns the total cost of all the sweets
    public static double getTotalCost(ArrayList<Sweet> sweets) {
    	double totalCost = 0;
    	for(Sweet sweet: sweets) {
    		totalCost += sweet.getTotalCost();
    	}
    	return totalCost;
    }
}
