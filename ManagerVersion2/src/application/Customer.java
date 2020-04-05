package application;

import java.util.ArrayList;

public class Customer {

	/**
	 * This class monitors the customer aspect of the application
	 */

	private double availableFunds;
	private ArrayList<String> Orders;

	/**
	 * Constructor for the customer class. Customer is given a random amount of
	 * money to spend ($30 - $40)
	 */
	public Customer() {
		availableFunds = Math.round(10 * Math.random() + 30);
	}

	/**
	 * returns available funds to be spent by the customer
	 * 
	 * @return available funds of the customer
	 */
	public double getAvailableFunds() {
		return availableFunds;
	}

	/**
	 * sets the available funds of the customer
	 * 
	 * @param availableFunds the amount of funds to set
	 */
	public void setAvailableFunds(double availableFunds) {
		this.availableFunds = availableFunds;
	}

	/**
	 * Returns the list of orders that the customer made
	 * 
	 * @return the list of orders that the customer made as an ArrayList
	 */
	public ArrayList<String> getOrders() {
		return Orders;
	}

	public void setOrders(ArrayList<String> orders) {
		Orders = orders;
	}

	/**
	 * Adds items to the customer's order.
	 * @param items the list of items to add
	 */
	public void addToOrder(ArrayList<String> items) {
		for (String item : items) {
			if (!Orders.contains(item)) {
				Orders.add(item);
			}
		}
	}

	public String giveReview() {
		// if order is delivered, prompt customer for a review in string format

	}

}
