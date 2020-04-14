package application;

import java.util.ArrayList;

public class Menu {
	ArrayList<Drink> drinks;
	ArrayList<Taco> tacos;
	ArrayList<SideDish> sides;
	
	public Menu() {
		this.drinks = new ArrayList<Drink>();
		this.tacos = new ArrayList<Taco>();
		this.sides = new ArrayList<SideDish>();		
	}
	
	public void populateMenu(String fileName) {
		MenuReader reader = new MenuReader();
		reader.readFile(fileName);
		this.drinks = reader.getDrinks();
		this.tacos = reader.getTacos();
		this.sides = reader.getSideDishes();
		/*
		 * for (Drink drink : this.drinks) {
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
		*/
	}
	/*
	public static void main(String[] args) {
		Inventory inv = new Inventory();
		inv.populateInventory("Inventory.csv");
		Menu menu = new Menu();
		menu.populateMenu("MenuList.csv");
		for (Taco taco : menu.tacos) {
			System.out.println(taco.description + " $" + taco.price);
		}
	}*/
	
}
