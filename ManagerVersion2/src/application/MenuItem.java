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
	public HashMap<InventoryItem, Double> ingredients; 
	
	
	public MenuItem(String description) {
	
	}
	

}
