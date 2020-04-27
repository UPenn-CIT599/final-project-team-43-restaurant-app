package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * This class monitors inventory items of the restaurant
 * 
 * @author yinjiezhang, porth
 * 
 *
 */
public class Inventory {

	// InventoryItems are objects of InventoryItem class
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
	 * 
	 * @param fileName
	 */
	public void populateInventory(String fileName) {
		// Initializes new InventoryReader
		InventoryReader reader = new InventoryReader(fileName);
		// calls reader methods to read file and fill ArrayList
		// reader.readFile(fileName);
		inventory = reader.getInventoryList();
	}

	// getter for inventory ArrayList
	public ArrayList<InventoryItem> getInventory() {
		return inventory;
	}

	/**
	 * Method to iterate over inventory to find items in need of reorder. If onHand
	 * quantity is less than the reorderPoint the item is added to the list of items
	 * to order, which is then sorted by vendor.
	 * 
	 * @return ArrayList itemsToOrder
	 */
	public ArrayList<PurchaseOrder> createProductOrder() {

		List<PurchaseOrder> itemsToOrder = new ArrayList<PurchaseOrder>();

		for (InventoryItem product : inventory) {
			if (product.getReorderPoint() > product.getOnHand()) {
				PurchaseOrder purchOrder = new PurchaseOrder(product, 1);
				itemsToOrder.add(purchOrder);
			}
		}
		Collections.sort(itemsToOrder,
				(item1, item2) -> item1.getItemToBuy().getVendorName().compareTo(item2.getItemToBuy().getVendorName()));

		return (ArrayList<PurchaseOrder>) itemsToOrder;
	}

	/**
	 * Helper method to update onHand quantity depleted products as they are replenished
	 * 
	 * @param product the InventoryItem on the associated PurchseOrder
	 * @param units  the number of packs of product being purchased (set to 1 by default)
	 * @return
	 */
	public double buyProduct(InventoryItem product, double unitsToBuy) {
		double orderQty = unitsToBuy;
		double available = product.getOnHand();
		available += orderQty;
		product.setOnHand(available);
		return available;
	}
	/**
	 * This method iterates over an ArrayList of PurchaseOrders and updates
	 * inventory levels to reflect the purchase. It also write the Purchase Orders
	 * to the PurchaseOrders.csv file and returns the total cost 
	 * of the list of PurchaseOrders
	 * @param itemsToOrder
	 * @return
	 */
	public double replenishInventory(ArrayList<PurchaseOrder> itemsToOrder) {
		double totalCost = 0;
		ArrayList<PurchaseOrder> orders = new ArrayList<PurchaseOrder>();
		orders = itemsToOrder;
		for (PurchaseOrder order : orders) {
			buyProduct(order.getItemToBuy(), order.getOrderQty());
			order.writePurchaseOrder(order.createOrderRecord());
			totalCost += order.getCost();
		}
		totalCost = Math.round(totalCost * 100.0) / 100.0;
		return totalCost;
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
