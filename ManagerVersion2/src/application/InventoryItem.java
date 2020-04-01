package application;
/**
 * This class has information of one inventory item
 * @author yinjiezhang
 *
 */
public class InventoryItem {

	private String itemName;
	private double calorie;
	private double unitPrice;
	private int amount;
	private String supplyChannel;
	
	/**
	 * constructor
	 * @param name
	 * @param calorie
	 * @param price
	 * @param amount
	 * @param supplyChannel
	 */
	public InventoryItem(String name, double calorie, double price, int amount, String supplyChannel) {
		itemName = name;
		this.calorie = calorie;
		unitPrice = price;
		this.amount = amount;
		this.supplyChannel = supplyChannel;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getCalorie() {
		return calorie;
	}

	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSupplyChannel() {
		return supplyChannel;
	}

	public void setSupplyChannel(String supplyChannel) {
		this.supplyChannel = supplyChannel;
	}
	
	
	
	
}
