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
 * This class keeps track of the orders for the customers
 * 
 * @author yangliu
 *
 */

public class CustomerOrder {

	// an instance of the order class is associated with only one customer
	private Customer customer;
	private int orderID;
	private double totalPrice;

	private boolean delivery;
	private String estimatedTimeOfDelivery;

	private HashMap<Taco, Integer> tacoItemToOrderQuantity;
	private HashMap<Drink, Integer> drinkItemToOrderQuantity;
	private HashMap<SideDish, Integer> sideDishItemToOrderQuantity;

	private HashMap<Customer, Taco> customerToTacoOrdersForDineIn;
	private HashMap<Customer, Drink> customerToDrinkOrdersForDineIn;
	private HashMap<Customer, SideDish> customerToSideDishOrdersForDineIn;

	private HashMap<Customer, Taco> customerToTacoOrdersForDelivery;
	private HashMap<Customer, Drink> customerToDrinkOrdersForDelivery;
	private HashMap<Customer, SideDish> customerToSideDishOrdersForDelivery;

	/**
	 * Constructor for Orders
	 * 
	 * @param customer the customer who is ordering
	 * @param delivery set true if order is delivery; set false if order is dine in
	 */
	public CustomerOrder(Customer customer, boolean delivery) {

		// order object contains the customer and boolean value for delivery
		this.setCustomer(customer);
		this.setDelivery(delivery);

		// order items for delivery are in a separate hashmap from dine in
		if (delivery == true) {
			for (Taco taco : customer.getTacoOrders()) {
				customerToTacoOrdersForDelivery.put(customer, taco);
			}
			for (Drink drink : customer.getDrinkOrders()) {
				customerToDrinkOrdersForDelivery.put(customer, drink);
			}
			for (SideDish sideDish : customer.getSideDishOrders()) {
				customerToSideDishOrdersForDelivery.put(customer, sideDish);
			}
		} else if (delivery == false) {
			for (Taco taco : customer.getTacoOrders()) {
				customerToTacoOrdersForDineIn.put(customer, taco);
			}
			for (Drink drink : customer.getDrinkOrders()) {
				customerToDrinkOrdersForDineIn.put(customer, drink);
			}
			for (SideDish sideDish : customer.getSideDishOrders()) {
				customerToSideDishOrdersForDineIn.put(customer, sideDish);
			}
		}
	}

	/**
	 * This method writes the customer order to CustomerOrders.csv for dine-in
	 * orders
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method writes the customer order to CustomerOrders.csv for delivery
	 * orders
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
	 * This method calculates the total price of all orders for a given customer
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
	 * This method returns the monetary value that the customer has remaining after
	 * making an order purchase
	 * 
	 * @param orderCost Cost of the order
	 * @param customerFunds Initial funds of the customer
	 * @return the customer's available balance
	 */
	public static double makePurchase(double orderCost, double customerFunds) {
		return customerFunds - orderCost;
	}

	/**
	 * Getter for customer
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Setter for customer
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Getter for total price
	 * 
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Setter for total price
	 * 
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Getter for estimated time of delivery
	 * 
	 * @return
	 */
	public String getEstimatedTimeOfDelivery() {
		return estimatedTimeOfDelivery;
	}

	/**
	 * Setter for estimated time of delivery
	 * 
	 * @param estimatedTimeOfDelivery
	 */
	public void setEstimatedTimeOfDelivery(String estimatedTimeOfDelivery) {
		this.estimatedTimeOfDelivery = estimatedTimeOfDelivery;
	}

	/**
	 * Getter for the taco item to quantity hashmap
	 * 
	 * @return
	 */
	public HashMap<Taco, Integer> getTacoItemToOrderQuantity() {
		return tacoItemToOrderQuantity;
	}

	/**
	 * Getter for the drink item to quantity hashmap
	 * 
	 * @return
	 */
	public HashMap<Drink, Integer> getDrinkItemToOrderQuantity() {
		return drinkItemToOrderQuantity;
	}

	/**
	 * Getter for the side dish item to quantity hashmap
	 * 
	 * @return
	 */
	public HashMap<SideDish, Integer> getSideDishItemToOrderQuantity() {
		return sideDishItemToOrderQuantity;
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
	 * @param delivery true for delivery; false for dine in
	 */
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

}
