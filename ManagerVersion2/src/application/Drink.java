package application;
/**
 * Class for beverages to be sold through menu
 * @author porth
 *
 */
public class Drink {
	private String description;
	private String inventoryId;
	private double price;
	private double cost;
	/**
	 * Constructor to build new drink object from InventoryObject
	 * @param description
	 * @param inventoryId
	 */
	public Drink(String description, String inventoryId) {
		this.description = description;
		this.inventoryId = inventoryId;
		this.price = 1.75;
		this.cost = 0.00;
		
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
