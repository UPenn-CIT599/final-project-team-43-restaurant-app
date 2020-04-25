package application;

import java.util.ArrayList;

/**
 * Class to contain ArrayLists of different menu items
 * 
 * @author porth
 *
 */
public class Menu {
	ArrayList<Drink> drinks;
	ArrayList<Taco> tacos;
	ArrayList<SideDish> sides;

	/**
	 * Constructor initializes empty ArrayLists to be filled by MenuReader
	 */
	public Menu() {
		this.drinks = new ArrayList<Drink>();
		this.tacos = new ArrayList<Taco>();
		this.sides = new ArrayList<SideDish>();
	}

	/**
	 * Method to construct MenuReader and fill Menu ArrayLists with menu items
	 * 
	 * @param fileName  name of .csv file with menu items and ingredients
	 * @param inventory ArrayList of InventoryItems
	 */
	public void populateMenu(String fileName, Inventory inventory) {
		MenuReader reader = new MenuReader();
		reader.inventory = inventory;
		reader.readFile(fileName);
		this.drinks = reader.getDrinks();
		this.tacos = reader.getTacos();
		this.sides = reader.getSideDishes();
		// calculate cost, price and calorie count for each item and store in variables
		for (Drink drink : this.drinks) {
			drink.setCost();
			drink.setPrice();
			drink.setCalories();
		}
		for (Taco taco : this.tacos) {
			taco.setCost();
			taco.setPrice();
			taco.setCalories();
		}
		for (SideDish side : this.sides) {
			side.setCost();
			side.setPrice();
			side.setCalories();
		}
	}

	// getter returns Drink objects
	public ArrayList<Drink> getDrinks() {
		return drinks;
	}

	// getter returns Taco objects
	public ArrayList<Taco> getTacos() {
		return tacos;
	}

	// getter returns SideDish objects
	public ArrayList<SideDish> getSides() {
		return sides;
	}
}
