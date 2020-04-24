package application;

import java.util.ArrayList;
/**
 * Class to contain ArrayLists of different menu items
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
	 * @param fileName name of .csv file with menu items and ingredients
	 * @param inventory ArrayList of InventoryItems
	 */
	public void populateMenu(String fileName, Inventory inventory) {
		MenuReader reader = new MenuReader();
		reader.inventory = inventory;
		reader.readFile(fileName);
		this.drinks = reader.getDrinks();
		this.tacos = reader.getTacos();
		this.sides = reader.getSideDishes();
	
		for (Drink drink : this.drinks) {
			drink.setCost();
			drink.setPrice();
		}
		for (Taco taco : this.tacos) {
			taco.setCost();
			taco.setPrice();
		}
		for (SideDish side : this.sides) {
			side.setCost();
			side.setPrice();
		}
	}
		//getter returns Drink objects
		public ArrayList<Drink> getDrinks() {
			return drinks;
		}
		//getter returns Taco objects
		public ArrayList<Taco> getTacos() {
			return tacos;
		}
		//getter returns SideDish objects
		public ArrayList<SideDish> getSides() {
			return sides;
		}
	
	
	/*
	public static void main(String[] args) {
		Inventory inv = new Inventory();
		inv.populateInventory("Inventory.csv");
		Menu menu = new Menu();
		menu.populateMenu("MenuList.csv", inv);
		for (Taco taco : menu.tacos) {
			System.out.println(taco.description + " $" + taco.price);
		}
		for (Drink drink: menu.drinks) {
			System.out.println(drink.description + " $" + drink.price);
		}
		for (SideDish side : menu.sides) {
			System.out.println(side.description + " $" + side.price);
		}
	}
	*/
}
