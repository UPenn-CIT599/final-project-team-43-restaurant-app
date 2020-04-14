package application;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class monitors inventory items of the restaurant
 * @author yinjiezhang, porth
 * 
 *
 */
public class Inventory {

	//InventoryItems are objects of InventoryItem class
	private ArrayList<InventoryItem> inventory;
	
	/**
	 * constructor initializes inventory ArrayList by reading from file
	 * constructor
	 * 
	 * @param itemList
	 */

	public Inventory(String fileName) {
		
		this.inventory = new ArrayList<InventoryItem>();
		InventoryReader reader = new InventoryReader();
		reader.readFile("inventory_small_csv");
		this.inventory = reader.getInventoryList();

	}
	
	
	/**
	 * Method to iterate over inventory to find items in need of reorder.
	 * If onHand quantity is less than the reorderPoint the item is added
	 * to the list of items to order.
	 * @return ArrayList itemsToOrder
	 */
	public ArrayList<InventoryItem> createProductOrder() {
		
		ArrayList<InventoryItem> itemsToOrder = new ArrayList<InventoryItem>();
		for(InventoryItem product : this.inventory) {
			if (product.getReorderPoint() > product.getOnHand()){
					itemsToOrder.add(product);				
			}			
		}
		return itemsToOrder;
	}
	
	
	public void addItem(String name, int amount) {
	}	

	/**
	 * This method sorts inventory HashMap by item amount from least to most
	 * 
	 * @param inventory
	 */
	public void sort(HashMap<InventoryItem, Double> inventory) {
	}

	/**
	 * This method adds item to the inventory list
	 * 
	 * @param item
	 */
	public void addItem(InventoryItem item) {

	}

	/**
	 * This method deletes item from inventory list
	 * 
	 * @param item
	 */
	public void deleteItem(InventoryItem item) {

	}
}
