package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This class has information of one inventory item
 * 
 * @author yinjiezhang
 *
 */
public class InventoryItem {

	private SimpleStringProperty itemID;
	private SimpleStringProperty itemName;

	private SimpleDoubleProperty calorie;
	private SimpleDoubleProperty unitPrice;
	private SimpleStringProperty units;

	private SimpleDoubleProperty packSize;
	private SimpleDoubleProperty packPrice;
	private SimpleDoubleProperty onHand;
	private SimpleDoubleProperty reorderPoint;
	private SimpleStringProperty vendorName;

	/**
	 * constructor
	 * 
	 * @param itemID   unique identifier supplied by vendor
	 * @param name     item description
	 * @param calorie  calories per unit
	 * @param units    relevant unit size, i.e ounces, each, bunch
	 * @param packSize units in a package (or minimum order size)
	 * @param price    price per package
	 * @param onHand   quantity on hand
	 * @param vendor   vendor name
	 */
	/*
	 * Constructor takes inventory data fields as arguments
	 */

	public InventoryItem(String itemID, String name, double calorie, String units, double packSize, double price,
			double onHand, String vendor) {
		this.itemID = new SimpleStringProperty(itemID);
		this.itemName = new SimpleStringProperty(name);

		this.calorie = new SimpleDoubleProperty(calorie);
		this.units = new SimpleStringProperty(units);

		this.packSize = new SimpleDoubleProperty(packSize);
		this.packPrice = new SimpleDoubleProperty(price);
		this.onHand = new SimpleDoubleProperty(onHand);
		this.vendorName = new SimpleStringProperty(vendor);
		// set unit price to pack size divided by units per pack
		this.unitPrice = new SimpleDoubleProperty(Math.round(price / packSize * 100) / 100.0);
		// set reorder point to 20% of pack size
		this.reorderPoint = new SimpleDoubleProperty(Math.round(packSize * .20 * 100) / 100.0);

	}

	// getter for itemId
	public String getItemID() {
		return itemID.get();
	}

	// setter for itemId
	public void setItemID(String itemID) {
		this.itemID = new SimpleStringProperty(itemID);
	}

	// getterforItemName
	public String getItemName() {
		return itemName.get();
	}

	// setter for itemName
	public void setItemName(String itemName) {
		this.itemName = new SimpleStringProperty(itemName);
	}

	// getter for caloies per unit
	public double getCalorie() {
		return calorie.get();
	}

	// setter for calories per unit
	public void setCalorie(double calorie) {
		this.calorie = new SimpleDoubleProperty(calorie);
	}

	// getter for unitPrice
	public double getUnitPrice() {
		return unitPrice.get();
	}

	// setter for unitPrice
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = new SimpleDoubleProperty(unitPrice);
	}

	// getter for units
	public String getUnits() {
		return units.get();
	}

	// setter for units
	public void setUnits(String units) {
		this.units = new SimpleStringProperty(units);
	}

	// getter for packSize
	public double getPackSize() {
		return packSize.get();
	}

	// setter for packSize
	public void setPackSize(double packSize) {
		this.packSize = new SimpleDoubleProperty(packSize);
	}

	// getter for packPrice
	public double getPackPrice() {
		return packPrice.get();
	}

	// setter for packPrice
	public void setPackPrice(double packPrice) {
		this.packPrice = new SimpleDoubleProperty(packPrice);
	}

	// getter for onHand
	public double getOnHand() {
		return onHand.get();
	}

	// setter for onHand
	public void setOnHand(double onHand) {
		this.onHand = new SimpleDoubleProperty(onHand);
	}

	// method to reduce onHand quantity as orders are filled
	public void reduceOnHand(double amount) {

		this.onHand = new SimpleDoubleProperty(this.onHand.get() - amount);
	}

	// getter for reorderPoint
	public double getReorderPoint() {
		return reorderPoint.get();
	}

	// setter for reorderPoint
	public void setReorderPoint(double reorderPoint) {
		this.reorderPoint = new SimpleDoubleProperty(reorderPoint);
	}

	// getter for vendorName
	public String getVendorName() {
		return vendorName.get();
	}

	// setter for vendorName
	public void setVendorName(String vendorName) {
		this.vendorName = new SimpleStringProperty(vendorName);
	}

}
