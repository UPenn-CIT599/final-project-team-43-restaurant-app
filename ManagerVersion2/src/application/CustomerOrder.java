package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class is associated with the orders for our customers
 * 
 * @author yangliu
 *
 */

public class CustomerOrder {

	private Customer customer;

	private double totalPrice;

	private boolean delivery;

	/**
	 * This method writes the customer order to CustomerOrders.csv for dine-in
	 * orders
	 * 
	 * @param customerID the ID of the customer
	 * @param serviceType serviceType of the order (Dine-in or Delivery)
	 * @param orderDate Date of the order
	 * @param orderTime Time the order was placed (local time)
	 * @param beefTQty Quantity of beef tacos ordered
	 * @param chickenTQty Quantity of chicken tacos ordered
	 * @param veggieTQty Quantity of veggie tacos ordered
	 * @param nachosQty Quantity of nachos ordered
	 * @param tortillaQty Quantity of tortilas ordered
	 * @param riceBeansQty Quantity of rice and beans ordered
	 * @param drPepperQty Quantity of drPeppers ordered
	 * @param spkWaterQty Quantity of sparkling waters ordered
	 * @param pepsiQty Quantity of pepsis ordered
	 * @param pacificoQty Quantity of pacificos ordered
	 * @param totalCost Total cost of the order
	 */
	public static void writeOrderDineIn(String customerID, String serviceType, String orderDate, String orderTime,
			int beefTQty, int chickenTQty, int veggieTQty, int nachosQty, int tortillaQty, int riceBeansQty,
			int drPepperQty, int spkWaterQty, int pepsiQty, int pacificoQty, double totalCost) {

		try {
			Scanner in = new Scanner("CustomerOrders.csv");
			FileWriter fw = new FileWriter("CustomerOrders.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);

			int lineNumber = CSVReader.readNumberOfLines("CustomerOrders.csv") + 10000;

			in.nextLine();
			bw.newLine();

			while (in.hasNextLine()) {
				in.nextLine();
				bw.newLine();
			}
			bw.write(lineNumber + "," + customerID + "," + serviceType + "," + orderDate + "," + orderTime + "," + ","
					+ "," + "," + beefTQty + "," + chickenTQty + "," + veggieTQty + "," + nachosQty + "," + tortillaQty
					+ "," + riceBeansQty + "," + drPepperQty + "," + spkWaterQty + "," + pepsiQty + "," + pacificoQty
					+ "," + totalCost);
			bw.flush();
			bw.close();
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * This method writes the customer order to CustomerOrders.csv for delivery
	 * orders
	 * @param customerID the ID of the customer
	 * @param serviceType serviceType of the order (Dine-in or Delivery)
	 * @param orderDate Date of the order
	 * @param orderTime Time the order was placed (local time)
	 * @param beefTQty Quantity of beef tacos ordered
	 * @param chickenTQty Quantity of chicken tacos ordered
	 * @param veggieTQty Quantity of veggie tacos ordered
	 * @param nachosQty Quantity of nachos ordered
	 * @param tortillaQty Quantity of tortilas ordered
	 * @param riceBeansQty Quantity of rice and beans ordered
	 * @param drPepperQty Quantity of drPeppers ordered
	 * @param spkWaterQty Quantity of sparkling waters ordered
	 * @param pepsiQty Quantity of pepsis ordered
	 * @param pacificoQty Quantity of pacificos ordered
	 * @param totalCost Total cost of the order
	 * @param deliveryAddress The delivery address entered for the order
	 */
	public static void writeOrderDelivery(String customerID, String serviceType, String orderDate, String orderTime,
			int beefTQty, int chickenTQty, int veggieTQty, int nachosQty, int tortillaQty, int riceBeansQty,
			int drPepperQty, int spkWaterQty, int pepsiQty, int pacificoQty, double totalCost, String deliveryAddress) {
		try {
			Scanner in = new Scanner("CustomerOrders.csv");
			FileWriter fw = new FileWriter("CustomerOrders.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);

			int lineNumber = CSVReader.readNumberOfLines("CustomerOrders.csv") + 10000;

			in.nextLine();
			bw.newLine();

			while (in.hasNextLine()) {
				in.nextLine();
				bw.newLine();
			}
			bw.write(lineNumber + "," + customerID + "," + serviceType + "," + orderDate + "," + orderTime + "," + ","
					+ "," + "," + beefTQty + "," + chickenTQty + "," + veggieTQty + "," + nachosQty + "," + tortillaQty
					+ "," + riceBeansQty + "," + drPepperQty + "," + spkWaterQty + "," + pepsiQty + "," + pacificoQty
					+ "," + totalCost + "," + deliveryAddress);
			bw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method calculates the total price of all orders for the customer
	 * 
	 * @return the total value of all food items the customer ordered
	 */
	public static double calculateTotalPrice(int beefTQty, int chickenTQty, int veggieTQty, int nachosQty,
			int tortillaQty, int riceBeansQty, int drPepperQty, int spkWaterQty, int pepsiQty, int pacificoQty) {
		Inventory inv = new Inventory();
		inv.populateInventory("Inventory.csv");

		Menu menu = new Menu();
		menu.populateMenu("MenuList.csv", inv);

		double totalCost = 0;

		totalCost = beefTQty * menu.tacos.get(0).getPrice() + chickenTQty * menu.tacos.get(1).getPrice()
				+ veggieTQty * menu.tacos.get(2).getPrice() + nachosQty * menu.sides.get(0).getPrice()
				+ tortillaQty * menu.sides.get(1).getPrice() + riceBeansQty * menu.sides.get(2).getPrice()
				+ drPepperQty * menu.drinks.get(0).getPrice() + spkWaterQty * menu.drinks.get(1).getPrice()
				+ pepsiQty * menu.drinks.get(2).getPrice() + pacificoQty * menu.drinks.get(3).getPrice();

		return totalCost;
	}

	/**
	 * Getter for customer
	 * 
	 * @return customer object
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Setter for customer
	 * 
	 * @param customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Getter for total price
	 * 
	 * @return the total price of the order
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Setter for total price
	 * 
	 * @param totalPrice the total price to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Getter for isDelivery
	 * 
	 * @return true for delivery; false for dine in
	 */
	public boolean isDelivery() {
		return delivery;
	}

	/**
	 * Setter for isDelivery
	 * 
	 * @param delivery set true for delivery; false for dine in
	 */
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

}
