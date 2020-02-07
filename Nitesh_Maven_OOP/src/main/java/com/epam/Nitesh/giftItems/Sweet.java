package com.epam.Nitesh.giftItems;

import java.util.ArrayList;

import com.epam.Nitesh_Maven_OOP.Gift;

public class Sweet extends Gift{
	
	public Sweet() {
		chocolates = new ArrayList<Chocolate>();
		candies = new ArrayList<Candie>();
	}
	
	public void addChocolates(ArrayList<Chocolate> chocolates) {
		this.chocolates = chocolates;
	}
	
	public void addCandies(ArrayList<Candie> candies) {
		this.candies = candies;
	}
	
	public void addTotalWeight(double weight) {
		this.totalWeight += weight;
	}
	
	public void addTotalCost(double cost) {
		this.totalCost += cost;
	}
	
	public ArrayList<Chocolate> getChocolates() {
		return chocolates;
	}
	
	public ArrayList<Candie> getCandies() {
		return candies;
	}
	
	double getCost() {
		return cost;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public double getTotalWeight() {
		return totalWeight;
	}
	
	public void printChocolates() {
		for(Chocolate choco: chocolates) {
			System.out.println(choco.toString());
		}
	}
	
	public void printCandies() {
		for(Candie candie: candies) {
			System.out.println(candie.toString());
		}
	}
}
