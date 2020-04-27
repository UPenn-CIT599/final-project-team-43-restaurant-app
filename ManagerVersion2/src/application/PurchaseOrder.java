package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Class to represent a vendor order for a particular InventoryItem
 * 
 * @author porth
 *
 */
public class PurchaseOrder {
	private InventoryItem itemToBuy;
	private String orderDate;
	private int unitsPurchased;
	private double orderQty;
	private double cost;

	/*
	 * Constructor creates Purchase Order and initializes various instance variables
	 */
	public PurchaseOrder(InventoryItem item, int noUnits) {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		this.itemToBuy = item;
		this.unitsPurchased = noUnits;
		this.orderDate = date.format(now);
		this.cost = this.itemToBuy.getPackPrice() * this.unitsPurchased;
		this.orderQty = this.itemToBuy.getPackSize() * this.unitsPurchased;
	}

	/**
	 * Method to create a string to write to the PurchaseOrder.csv file
	 * 
	 * @return
	 */
	public String createOrderRecord() {
		String record;
		record = (this.getOrderDate() + "," + this.itemToBuy.getVendorName() + "," + this.itemToBuy.getItemID() + ","
				+ this.itemToBuy.getItemName() + "," + Integer.toString(this.getUnitsPurchased()) + ","
				+ Double.toString(this.itemToBuy.getOnHand()) + "," + Double.toString(this.getCost()));
		return record;
	}

	/**
	 * Method to append purchase order record to end of PurchaseOrders.csv.csv file
	 * 
	 * @param record a String of comma separated transaction details
	 */
	public void writePurchaseOrder(String record) {
		String transRecord = record;
		try {
			Scanner in = new Scanner("PurchaseOrders.csv");
			FileWriter fw = new FileWriter("PurchaseOrders.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);

			in.nextLine();
			bw.newLine();

			while (in.hasNextLine()) {
				in.nextLine();
				bw.newLine();
			}
			bw.write(transRecord);
			bw.flush();
			bw.close();
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getter for vendor name
	public InventoryItem getItemToBuy() {
		return itemToBuy;
	}

	// getter for order date
	public String getOrderDate() {
		return orderDate;
	}

	// getter for unitsPurchased
	public int getUnitsPurchased() {
		return unitsPurchased;
	}

	// setter for unitsPurchased
	public void setUnitsPurchased(int unitsPurchased) {
		this.unitsPurchased = unitsPurchased;
	}

	// getter for cost of product ordered
	public double getCost() {
		return cost;
	}

	// getter for orderQty
	public double getOrderQty() {
		return orderQty;
	}

}
