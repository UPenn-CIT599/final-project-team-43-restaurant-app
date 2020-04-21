package application;

/**
 * This class has information of one inventory item
 * 
 * @author yinjiezhang
 *
 */
public class InventoryItem {

	private String itemID;
	private String itemName;

	private double calorie;
	private double unitPrice;
	private String units;

	private double packSize;
	private double packPrice;
	private double onHand;
	private double reorderPoint;
	private String vendorName;

	/**
	 * constructor
	 * 
	 * @param itemID
	 * @param name
	 * @param calorie
	 * @param units
	 * @param packSize
	 * @param price
	 * @param onHand
	 * @param vendor
	 */
	public InventoryItem(String itemID, String name, double calorie, String units, double packSize, double price,
			double onHand, String vendor) {
		this.itemID = itemID;
		itemName = name;

		this.calorie = calorie;
		this.units = units;

		this.packSize = packSize;
		packPrice = price;
		this.onHand = onHand;
		this.vendorName = vendor;

		this.unitPrice = price / packSize;
		this.reorderPoint = packSize * .20;

	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
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

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public double getPackSize() {
		return packSize;
	}

	public void setPackSize(double packSize) {
		this.packSize = packSize;
	}

	public double getPackPrice() {
		return packPrice;
	}

	public void setPackPrice(double packPrice) {
		this.packPrice = packPrice;
	}

	public double getOnHand() {
		return onHand;
	}

	public void setOnHand(double onHand) {
		this.onHand = onHand;
	}
	//method to reduce onHand quantity as orders are filled 
	public void reduceOnHand(double amount) {
		this.onHand = this.onHand - amount;
	}

	public double getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(double reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

}
