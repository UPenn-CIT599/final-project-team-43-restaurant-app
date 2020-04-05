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
	private double onHand;
	private String vendorName;
	private double packSize;
	private double packPrice;
	private String itemID;
	private double reorderPoint;
	private String units;
	
	
	
	/**
	 * constructor
	 * @param name
	 * @param calorie
	 * @param packPrice
	 * @param onHand
	 * @param vendor
	 * @param packSize
	 * @param packPrice
	 * @param itemID
	 */
	public InventoryItem(String itemID, String name, double packSize, String units, String vendor, double price, double onHand, double calorie) {
		itemName = name;
		this.itemID = itemID;
		this.calorie = calorie;
		packPrice = price;
		this.onHand = onHand;
		this.vendorName = vendor;
		this.packSize = packSize;
		this.units = units;
		this.reorderPoint = packSize * .20;
		this.unitPrice = price / packSize;
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

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public double getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(double reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
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

	public double getOnHand() {
		return onHand;
	}

	public void setOnHand(double onHand) {
		this.onHand = onHand;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	
	
	
}
