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
		reader.readFile("MenuList.csv");
		this.drinks = reader.getDrinks();
		this.tacos = reader.getTacos();
		this.sides = reader.getSideDishes();
	}
}
