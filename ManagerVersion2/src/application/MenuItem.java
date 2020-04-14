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
	public double price;
	public double cost;
	public String description;
	
	private HashMap<InventoryItem, Double> ingredients; 
	
	
	public MenuItem() {
		price = .00;
		cost = 0.00;
		setDescription("");
		ingredients = new HashMap<InventoryItem, Double>();
		
	}
	
	public void setCost() {
		for (InventoryItem ingredient : ingredients.keySet()) {
			cost += ingredient.getUnitPrice() * ingredients.get(ingredient);
		}
	}
	
	public double getCost() {
			return cost;
		}
	
	public void setPrice() {
		final double costMultiplier = 4.5;
		price = cost * costMultiplier;
		int priceInCents = (int)(price * 100);
		int priceRemainder = priceInCents % 100;
		int dollars = priceInCents / 100;
		if (priceRemainder > 0 && priceRemainder<= 25) {
			price = dollars + 0.25;	
		}
		else if (priceRemainder > 25 && priceRemainder <= 50) {
			price = dollars + 0.50;
		}
		else if (priceRemainder >50 && priceRemainder <= 75) {
			price = dollars + .75;
		}
		else price = dollars + .95;
	}
	
	public double getPrice() {
		return price;
	}
		
		
	public void addItem(String description) {
	
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public HashMap<InventoryItem, Double> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<InventoryItem, Double> ingredients) {
		this.ingredients = ingredients;
	}

}
