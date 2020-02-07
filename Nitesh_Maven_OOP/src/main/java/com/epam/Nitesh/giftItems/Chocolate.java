package com.epam.Nitesh.giftItems;

public class Chocolate extends Sweet implements Comparable<Chocolate>{

	public Chocolate(String name, double cost, double weight) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
	}
	
	public Chocolate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Chocolate o) {
		return (this.getCost() < o.getCost() ? -1 :
            (this.getCost() == o.getCost() ? 0 : 1));
	}
	
	@Override
	public String toString() {
        return "Chocolate { " +
                "Name = '" + name + '\'' +
                ", Cost = ₹" + cost +
                " /-, Weight = " + weight + " grams };";
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
