package application;

import java.util.HashMap;

/**
 * Abstract class for objects on the restaurant menu. Extended to Drink, Taco,
 * and SideDish classes.
 * 
 * @author porth
 *
 */
public abstract class MenuItem {
	/*
	 * instance variables consist of salePrice, cost, description, and a HashMap
	 * with ingredients as keys and portion sizes as values.
	 */
	double price;
	double cost;
	String description;
	double calories;
	HashMap<InventoryItem, Double> ingredients;
	int calorieCount;

	// constructor for MenuItem
	public MenuItem() {
		this.price = 0.00;
		this.cost = 0.00;
		this.setDescription("");
		this.ingredients = new HashMap<InventoryItem, Double>();
		this.calories = 0.00;
		this.calorieCount = 0;
	}

	/**
	 * iterates over ingredients in item, calculates unit price time portion for
	 * each and updates the total cost
	 */
	public void setCost() {
		cost = 0;
		for (InventoryItem ingredient : ingredients.keySet()) {
			cost += ingredient.getUnitPrice() * ingredients.get(ingredient);
		}
	}

	// getter for cost
	public double getCost() {
		return cost;
	}

	/**
	 * Method to calculate calorie content of a menu item
	 */
	public void setCalories() {
		calorieCount = 0;
		for (InventoryItem ingredient : ingredients.keySet()) {
			calories += ingredient.getCalorie() * ingredients.get(ingredient);
		}
		calorieCount = (int) Math.round(calories);
	}

	// getter for calorie content
	public int getCalories() {
		return calorieCount;
	}

	/**
	 * method to set price of a menu item by multiplying its cost by a multiplier
	 * prices are then rounded to the nearest $.25 (or $.95)
	 */
	public void setPrice() {
		final double costMultiplier = 4.5;
		price = cost * costMultiplier;
		int priceInCents = (int) (price * 100);
		int priceRemainder = priceInCents % 100;
		int dollars = priceInCents / 100;
		if (priceRemainder > 0 && priceRemainder <= 25) {
			price = dollars + 0.25;
		} else if (priceRemainder > 25 && priceRemainder <= 50) {
			price = dollars + 0.50;
		} else if (priceRemainder > 50 && priceRemainder <= 75) {
			price = dollars + .75;
		} else
			price = dollars + .95;
	}

	// getter for price
	public double getPrice() {
		return price;
	}

	// getter for Item description
	public String getDescription() {
		return description;
	}

	// setter for Item description
	public void setDescription(String description) {
		this.description = description;
	}

	// getter returns a HashMap of ingredients and portions
	public HashMap<InventoryItem, Double> getIngredients() {
		return ingredients;
	}
}
