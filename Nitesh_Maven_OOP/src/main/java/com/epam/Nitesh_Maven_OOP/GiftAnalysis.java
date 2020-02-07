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
		
    	Chocolate c = new Chocolate("Milkybar", 30, 20);
    	chocolates.add(c);
    	c = new Chocolate("Cadbury Temptation", 85, 72);
    	chocolates.add(c);
    	c = new Chocolate("Kreitens Almond Toffee", 220, 250);
    	chocolates.add(c);

        sweets.addChocolates(chocolates);
        
        Candie cd = new Candie("Dilkhush Orange Candy", 100, 150);
    	candies.add(cd);
    	cd = new Candie("Kismi Parle", 50, 95);
    	candies.add(cd);
    	cd = new Candie("Krey Mix Fruit", 30, 60);
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
		
		if(type == 1) {
			Collections.sort(chocolates, Collections.reverseOrder());
		}
		else {
			Collections.sort(chocolates);
		}
		sweets.printChocolates();
	}
	
	void getCandies(Sweet sweets, int type) {
		ArrayList<Candie> candies = sweets.getCandies();
		if(type == 1) {
			Collections.sort(candies, Collections.reverseOrder());
			for(Candie candie: candies) {
				System.out.println(candie.toString());
			}
		}
		else {
			Collections.sort(candies);
			for(Candie candie: candies) {
				System.out.println(candie.toString());
			}
		}
		
	}
	
	void calRange(Sweet sweet, int type, int lower_bound, int upper_bound) {
		ArrayList<Chocolate> chocolates = sweet.getChocolates();
		ArrayList<Candie> candies = sweet.getCandies();
		
		if(type == 1) {
			int totalCost = 0;
			System.out.println("	Chocolates in range [" + lower_bound + ", " + upper_bound + "] cost:	");
			for(Chocolate choco: chocolates) {
				if(choco.cost >= lower_bound && choco.cost <= upper_bound) {
					System.out.println(choco.toString());
					totalCost += choco.cost;
				}
			}
			System.out.println("	Candies in range [" + lower_bound + ", " + upper_bound + "] cost:");
			for(Candie candie: candies) {
				if(candie.cost >= lower_bound && candie.cost <= upper_bound) {
					System.out.println(candie.toString());
					totalCost += candie.cost;
				}
			}
			System.out.println("Total Cost of Sweets = ₹" + totalCost + " /-\n");
		}
		else {
			int totalWeight = 0;
			System.out.println("	Chocolates in range [" + lower_bound + ", " + upper_bound + "] weight(in grams)	");
			for(Chocolate choco: chocolates) {
				if(choco.weight >= lower_bound && choco.weight <= upper_bound) {
					System.out.println(choco.toString());
					totalWeight += choco.weight;
				}
			}
			System.out.println("	Candies in range [" + lower_bound + ", " + upper_bound + "] weight(in grams):\n");
			for(Candie candie: candies) {
				if(candie.weight >= lower_bound && candie.weight <= upper_bound) {
					System.out.println(candie.toString());
					totalWeight += candie.weight;
				}
			}
			System.out.println("Total Weight of Sweets = " + totalWeight + "grams\n");
		}
	}
}
