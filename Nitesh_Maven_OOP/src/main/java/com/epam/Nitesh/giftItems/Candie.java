package com.epam.Nitesh.giftItems;


public class Candie extends Sweet implements Comparable<Candie>{
	
	public Candie(String name, double cost, double weight) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
	}
	
	public Candie() { }
	
	@Override
	public String toString() {
        return "Candy { " +
                "Name = '" + name + '\'' +
                ", Cost = ₹" + cost +
                " /-, Weight = " + weight + " grams };";
    }
	
	@Override
	public int compareTo(Candie o) {
		return (this.getCost() < o.getCost() ? -1 : 
            (this.getCost() == o.getCost() ? 0 : 1));
	}
	
	@Override
	public void addTotalWeight(double weight) {
		this.totalWeight += weight;
	}
	
	@Override
	public double getTotalWeight() {
		return this.totalWeight;
	}
	
	@Override
	public void addTotalCost(double weight) {
		this.totalCost += cost;
	}
	
	@Override
	public double getTotalCost() {
		return this.totalCost;
	}
}
