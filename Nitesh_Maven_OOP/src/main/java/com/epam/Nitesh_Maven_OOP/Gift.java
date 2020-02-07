package com.epam.Nitesh_Maven_OOP;

import java.util.ArrayList;
import com.epam.Nitesh.giftItems.Candie;
import com.epam.Nitesh.giftItems.Chocolate;

public abstract class Gift {
	protected String name;
	protected double cost;
	protected double weight;
	protected double totalWeight;
	protected double totalCost;
	protected ArrayList<Chocolate> chocolates;
	protected ArrayList<Candie> candies;
}
