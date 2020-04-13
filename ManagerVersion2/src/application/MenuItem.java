package application;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author yangliu
 *
 */
public abstract class MenuItem {
	
	//instance variables consist of salePrice, cost, description, portionSize, and ingredients.
	private double price;
	private double cost;
	private String description;
	private HashMap<InventoryItem, Double> ingredients; 
	
	
	public MenuItem() {
		price = .00;
		cost = 0.00;
		description = "";
		ingredients = new HashMap<InventoryItem, Double>();
		
	}
	
	public void addItem(String description) {
	
	}
	
}
