package application;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * This class monitors inventory items of the restaurant
 * @author yinjiezhang
 *
 */
public class Inventory {

	//InventoryItem are variables from InventoryItem class, Integer are amount of those items
	private HashMap<InventoryItem, Integer> inventory;
	
	/**
	 * constructor
	 * @param itemList
	 */
	public Inventory(ArrayList<InventoryItem> itemList) {
		
		inventory = new HashMap<>();
		
		for (InventoryItem inventoryItem : itemList) {
			int amount = inventoryItem.getAmount();
			inventory.put(inventoryItem, amount);
		}
	}
	
	
	
	
	
	public void sort(HashMap<InventoryItem, Integer> inventory) {
		
	}
	
	public Inventory alertOfOutOfStock() {
		
	}
	
	
	public void addItem(String name, int amount) {
		
	}


	public void deleteItem(String name, int amount) {
		
	}
}
