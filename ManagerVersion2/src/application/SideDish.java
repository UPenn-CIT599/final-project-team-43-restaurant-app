package application;
/**
 * Class for sideDish menu items
 * @author porth
 *
 */
public class SideDish {
	private String description;
	private double price;
	private String inventoryId;
	private double quantity;
	private double cost;
	
	public SideDish(String description, String inventoryId) {
		this.description = description;
		this.price = 0.00;
		this.cost = cost;
		this.inventoryId = inventoryId;
		this.quantity = 0.0;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
