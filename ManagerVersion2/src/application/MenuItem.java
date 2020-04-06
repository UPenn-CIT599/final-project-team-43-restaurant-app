package application;

import java.util.ArrayList;

/**
 * 
 * @author yangliu
 *
 */
public class MenuItem {
	
	//instance variables consist of arraylists of the different food class items
	private ArrayList<Taco> tacos;
	private ArrayList<Drink> drink;
	private ArrayList<SideDish> sideDish;
	
	
	public MenuItem() {
		
	}
	
	public void addDrink(String description) {
		String invId;
		Drink newDrink = new Drink(description, invId);
		For (item : inventory)
		drink.add(newDrink);
	}
	

}
