package com.epam.Nitesh_Maven_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.epam.Nitesh.giftItems.Candie;
import com.epam.Nitesh.giftItems.Chocolate;
import com.epam.Nitesh.giftItems.Sweet;

public class GiftAnalysis {
	int noOfChocolates, noOfCandies;
	double cost, weight;
	String name;
	static Scanner scanner;
	
	GiftAnalysis() {
		scanner = new Scanner(System.in);
	}
	
	Sweet addDemoGift() {
		// New Demo Gift Added
		Sweet sweets = new Sweet();
		ArrayList<Chocolate> chocolates = new ArrayList<Chocolate>();
		ArrayList<Candie> candies = new ArrayList<Candie>();
		
		Chocolate c = new Chocolate("Cadbury Temptation", 85, 72);
		chocolates.add(c);
    	c = new Chocolate("Milkybar", 30, 20);
    	chocolates.add(c);
    	c = new Chocolate("Kreitens Almond Toffee", 220, 250);
    	chocolates.add(c);

        sweets.addChocolates(chocolates);
        
        Candie cd = new Candie("Dilkhush Orange Candy", 100, 150);
    	candies.add(cd);
    	cd = new Candie("Krey Mix Fruit", 30, 60);
    	candies.add(cd);
    	cd = new Candie("Kismi Parle", 50, 95);
    	candies.add(cd);

        sweets.addCandies(candies);
    	sweets.addTotalWeight(647);
    	sweets.addTotalCost(515);
        return sweets;
	}
	
	void addChocolates(Sweet sweets) {
		ArrayList<Chocolate> chocolates = new ArrayList<Chocolate>();
		
        System.out.println("Enter " + noOfChocolates + " chocolate Details (Name, Cost, weight(in grams))");
        
        for(int i = 0; i < noOfChocolates; i++) {
        	name = scanner.next();
        	cost = scanner.nextDouble();
        	weight = scanner.nextDouble();
        	sweets.addTotalWeight(weight);
        	sweets.addTotalCost(cost);
        	Chocolate c = new Chocolate(name, cost, weight);
        	chocolates.add(c);
        }
        sweets.addChocolates(chocolates);
	}
	
	
	void addCandies(Sweet sweets) {
		ArrayList<Candie> candies = new ArrayList<Candie>();
		
        System.out.println("Enter " + noOfCandies + " candie Details (Name, Cost(in rupees), weight(in grams))");
        
        for(int i = 0; i < noOfCandies; i++) {
        	name = scanner.next();
        	cost = scanner.nextDouble();
        	weight = scanner.nextDouble();
        	sweets.addTotalWeight(weight);
        	sweets.addTotalCost(cost);
        	Candie c = new Candie(name, cost, weight);
        	candies.add(c);
        }
        sweets.addCandies(candies);
	}
	
	Sweet addGift() {
		Sweet sweets = new Sweet();
        System.out.println("Enter Number of Chocolates(N) and Candies(M) in the Gift");
        noOfChocolates = scanner.nextInt();
        noOfCandies = scanner.nextInt();
        if(noOfChocolates > 0) {
            this.addChocolates(sweets);
        }
        if(noOfCandies > 0) {
	        this.addCandies(sweets);
        }
        return sweets;
	}
	
	void getChocolates(Sweet sweets, int type) {
		ArrayList<Chocolate> chocolates = sweets.getChocolates();
		
		switch(type) {
			case 1:
				Collections.sort(chocolates, Collections.reverseOrder());
				sweets.printChocolates();
				break;
			case 2:
				Collections.sort(chocolates);
				sweets.printChocolates();
				break;
			default:
				System.out.println("Invalid Choice...");
		}
		
	}
	
	void getCandies(Sweet sweets, int type) {
		ArrayList<Candie> candies = sweets.getCandies();
		switch(type) {
			case 1:
				Collections.sort(candies, Collections.reverseOrder());
				for(Candie candie: candies) {
					System.out.println(candie.toString());
				}
				break;
			case 2:
				Collections.sort(candies);
				for(Candie candie: candies) {
					System.out.println(candie.toString());
				}
				break;
			default:
				System.out.println("Invalid Choice...");
		}
		
	}
	
	void calRange(Sweet sweet, int type, int lower_bound, int upper_bound) {
		ArrayList<Chocolate> chocolates = sweet.getChocolates();
		ArrayList<Candie> candies = sweet.getCandies();
		
		switch(type) {
			case 1:
				// print all the chocolates and candies with cost X such that (lower_bound <= X <= upper_bound)
				int totalChocolatesCost = 0, totalCandiesCost = 0;
				System.out.println("	Chocolates in range [" + lower_bound + ", " + upper_bound + "] cost:\n");
				for(Chocolate choco: chocolates) {
					if(choco.cost >= lower_bound && choco.cost <= upper_bound) {
						System.out.println(choco.toString());
						totalChocolatesCost += choco.cost;
					}
				}
				if(totalChocolatesCost == 0) {
					System.out.println("No Chocolates in the given range ");
				}
				System.out.println("	Candies in range [" + lower_bound + ", " + upper_bound + "] cost:\n");
				for(Candie candie: candies) {
					if(candie.cost >= lower_bound && candie.cost <= upper_bound) {
						System.out.println(candie.toString());
						totalCandiesCost += candie.cost;
					}
				}
				if(totalCandiesCost == 0) {
					System.out.println("No Candies in the given range ");
				}
				if(totalCandiesCost > 0 && totalChocolatesCost > 0)
					System.out.println("Total Cost of Sweets = ₹" + String.valueOf(totalCandiesCost + totalChocolatesCost) + " /-\n");
				break;
			case 2:
				// print all the chocolates and candies with weight X such that (lower_bound <= X <= upper_bound) 
				int totalChocolatesWeight = 0, totalCandiesWeight = 0;
				System.out.println("	Chocolates in range [" + lower_bound + ", " + upper_bound + "] weight(in grams)\n");
				for(Chocolate choco: chocolates) {
					if(choco.weight >= lower_bound && choco.weight <= upper_bound) {
						System.out.println(choco.toString());
						totalChocolatesWeight += choco.weight;
					}
				}
				if(totalChocolatesWeight == 0) {
					System.out.println("No Chocolates in the given range ");
				}
				System.out.println("	Candies in range [" + lower_bound + ", " + upper_bound + "] weight(in grams):\n");
				for(Candie candie: candies) {
					if(candie.weight >= lower_bound && candie.weight <= upper_bound) {
						System.out.println(candie.toString());
						totalCandiesWeight += candie.weight;
					}
				}
				if(totalCandiesWeight == 0) 
					System.out.println("No Candies in the given range \n");
				if(totalCandiesWeight > 0 && totalChocolatesWeight > 0) 
					System.out.println("Total Weight of Sweets = " + String.valueOf(totalCandiesWeight + totalChocolatesWeight) + " grams\n");
				break;
			default:
				System.out.println("Invalid Choice...");
		}
	}
}
