package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
	 * constructor initializes empty ArrayList of inventory items
	 * 
	 */

	public Inventory() {
		
		inventory = new ArrayList<InventoryItem>();
	}
	/**
	 * method to populate ArrayList of Inventory Items by reading from .csv File
	 * @param fileName
	 */
	public void populateInventory(String fileName) {
		//Initializes new InventoryReader
		InventoryReader reader = new InventoryReader(fileName);
		//calls reader methods to read file and fill ArrayList
		//reader.readFile(fileName);
		inventory = reader.getInventoryList();
		}
	
	public ArrayList<InventoryItem> getInventory() {
		return inventory;
	}

	/**
	 * Method to iterate over inventory to find items in need of reorder.
	 * If onHand quantity is less than the reorderPoint the item is added
	 * to the list of items to order, which is then sorted by vendor.
	 * @return ArrayList itemsToOrder
	 */
	public ArrayList<InventoryItem> createProductOrder() {
		
	List<InventoryItem> itemsToOrder = new ArrayList<InventoryItem>();
		for(InventoryItem product : inventory) {
			if (product.getReorderPoint() > product.getOnHand()){
					itemsToOrder.add(product);				
			}			
		}
		Collections.sort(
				itemsToOrder,
				(item1, item2) -> item1.getVendorName().compareTo(item2.getVendorName()));
		
		return (ArrayList<InventoryItem>) itemsToOrder;
	}
	
	/**
	 * Method to replenish depleted products
	 * @param product
	 * @param units
	 * @return
	 */
	public void buyProduct(InventoryItem product, int units) {
		double cost = product.getPackPrice() * units;
		double available = product.getOnHand();
		available += (product.getPackSize() * units);
		product.setOnHand(available);
	}
	
	public ArrayList<PurchaseOrder> replenishInventory() {
		double cost;
		ArrayList<PurchaseOrder> orders = new ArrayList<PurchaseOrder>();
		for (InventoryItem product : createProductOrder()){
			buyProduct(product, 1);
			
		
		}
	return orders;	
	}
	/**
	 * This method adds item to the inventory list
	 * 
	 * @param item
	 */
	public void addItem(InventoryItem item) {
		inventory.add(item);
	}

	/**
	 * This method deletes item from inventory list
	 * 
	 * @param item
	 */
	public void deleteItem(InventoryItem item) {
		inventory.remove(item);
	}
	
}
