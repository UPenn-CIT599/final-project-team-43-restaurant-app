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
		this.itemID = new SimpleStringProperty(itemID);
		this.itemName = new SimpleStringProperty(name);

		this.calorie = new SimpleDoubleProperty(calorie);
		this.units = new SimpleStringProperty(units);

		this.packSize = new SimpleDoubleProperty(packSize);
		this.packPrice = new SimpleDoubleProperty(price);
		this.onHand = new SimpleDoubleProperty(onHand);
		this.vendorName = new SimpleStringProperty(vendor);

		this.unitPrice = new SimpleDoubleProperty(Math.round(price / packSize * 100)/100.0);
		this.reorderPoint = new SimpleDoubleProperty(Math.round(packSize * .20 * 100)/100.0);

	}

	public String getItemID() {
		return itemID.get();
	}

	public void setItemID(String itemID) {
		this.itemID = new SimpleStringProperty(itemID);
	}

	public String getItemName() {
		return itemName.get();
	}

	public void setItemName(String itemName) {
		this.itemName = new SimpleStringProperty(itemName);
	}

	public double getCalorie() {
		return calorie.get();
	}

	public void setCalorie(double calorie) {
		this.calorie = new SimpleDoubleProperty(calorie);
	}

	public double getUnitPrice() {
		return unitPrice.get();
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = new SimpleDoubleProperty(unitPrice);
	}

	public String getUnits() {
		return units.get();
	}

	public void setUnits(String units) {
		this.units = new SimpleStringProperty(units);
	}

	public double getPackSize() {
		return packSize.get();
	}

	public void setPackSize(double packSize) {
		this.packSize = new SimpleDoubleProperty(packSize);
	}

	public double getPackPrice() {
		return packPrice.get();
	}

	public void setPackPrice(double packPrice) {
		this.packPrice = new SimpleDoubleProperty(packPrice);
	}

	public double getOnHand() {
		return onHand.get();
	}

	public void setOnHand(double onHand) {
		this.onHand = new SimpleDoubleProperty(onHand);
	}
	//method to reduce onHand quantity as orders are filled 
	public void reduceOnHand(double amount) {
		
		this.onHand = new SimpleDoubleProperty(this.onHand.get() - amount);
	}

	public double getReorderPoint() {
		return reorderPoint.get();
	}

	public void setReorderPoint(double reorderPoint) {
		this.reorderPoint = new SimpleDoubleProperty(reorderPoint);
	}

	public String getVendorName() {
		return vendorName.get();
	}

	public void setVendorName(String vendorName) {
		this.vendorName = new SimpleStringProperty(vendorName);
	}

}
