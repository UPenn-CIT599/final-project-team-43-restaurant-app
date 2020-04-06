package application;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class monitors inventory items of the restaurant
 * 
 * @author yinjiezhang
 *
 */
public class Inventory {

	// InventoryItem are variables from InventoryItem class, Doubles are amount of
	// those items
	private HashMap<InventoryItem, Double> inventory;

	/**
	 * constructor
	 * 
	 * @param itemList
	 */
	public Inventory(ArrayList<InventoryItem> itemList) {

		inventory = new HashMap<>();

		for (InventoryItem inventoryItem : itemList) {
			double amount = inventoryItem.getOnHand();
			inventory.put(inventoryItem, amount);
		}
	}

	/**
	 * This method sorts inventory HashMap by item amount from least to most
	 * 
	 * @param inventory
	 */
	public void sort(HashMap<InventoryItem, Double> inventory) {

	}

	/**
	 * This method gives alert to those items may be out of stock soon
	 * 
	 * @param inventory
	 * @return item
	 */
	public InventoryItem alertOfOutOfStock(HashMap<InventoryItem, Double> inventory) {
		InventoryItem item;

		return item;
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
