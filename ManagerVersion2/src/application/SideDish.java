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
	/**
	 * Constructor takes arguments of description and inventoryId
	 * @param description
	 * @param inventoryId
	 */
	public SideDish(String description, String inventoryId) {
		this.description = description;
		this.price = 0.00;
		this.cost = 0.00;
		this.inventoryId = inventoryId;
		this.quantity = 0.0;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
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
