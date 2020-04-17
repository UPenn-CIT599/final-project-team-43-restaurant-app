package application;

import java.util.ArrayList;

/**
 * This class monitors the customer aspect of our restaurant application
 * 
 * @author yangliu
 */

public class Customer {
	
	String customerID;

	private double availableFunds; // Funds that the customer has available to spend
	
	private Menu menu;
	
	private static Customer customer = new Customer();
	
	
	private ArrayList<Taco> tacoOrders; // All taco orders for the customer
	private ArrayList<Drink> drinkOrders; // All drink orders for the customer
	private ArrayList<SideDish> sideDishOrders; // All side dish orders for the customer
	
	
	
	
	private CustomerReviews review;

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
	 * Getter of the list of tacos that the customer ordered
	 * @return
	 */
	public ArrayList<Taco> getTacoOrders() {
		return tacoOrders;
	}

	/**
	 * Setter of the list of tacos that the customer ordered
	 * @param tacoOrders
	 */
	public void setTacoOrders(ArrayList<Taco> tacoOrders) {
		this.tacoOrders = tacoOrders;
	}

	/**
	 * Getter for the list of drinks that the customer ordered
	 * @return
	 */
	public ArrayList<Drink> getDrinkOrders() {
		return drinkOrders;
	}

	/**
	 * Setter for the list of drinks that the customer ordered
	 * @param drinkOrders
	 */
	public void setDrinkOrders(ArrayList<Drink> drinkOrders) {
		this.drinkOrders = drinkOrders;
	}

	/**
	 * Getter for the list of side dishes that the customer ordered
	 * @return
	 */
	public ArrayList<SideDish> getSideDishOrders() {
		return sideDishOrders;
	}

	/**
	 * Setter for the list of side dishes that the customer ordered
	 * @param sideDishOrders
	 */
	public void setSideDishOrders(ArrayList<SideDish> sideDishOrders) {
		this.sideDishOrders = sideDishOrders;
	}

	/**
	 * Getter for the review that the customer gave
	 * @return
	 */
	public CustomerReviews getReview() {
		return review;
	}

	/**
	 * Setter for the review that the customer gave
	 * @param review
	 */
	public void setReview(CustomerReviews review) {
		this.review = review;
	}

	public static Customer getCustomer() {
		return customer;
	}
	
	

	public Menu getMenu() {
		return menu;
	}



	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/**
	 * Adds items in the cart to the customer's order.
	 * 
	 * @param items the list of items to add
	 */
	public void addToOrder(ArrayList<Taco> tacosInCart, ArrayList<Drink> drinksInCart,
			ArrayList<SideDish> sideDishesInCart) {
		this.tacoOrders = tacosInCart;
		this.drinkOrders = drinksInCart;
		this.sideDishOrders = sideDishesInCart;
	}
	
	
	

	/**
	 * Saves the customer's review
	 * 
	 * @param scoreOutOfFive Customer's review of 1-5
	 * @param messageReview  Customer's message review
	 */
	public void giveReview(int scoreOutOfFive, String messageReview) {
		if (scoreOutOfFive <= 5 && scoreOutOfFive >= 1) {
			this.review.setScoreOutOfFive(scoreOutOfFive);
			this.review.setMessageReview(messageReview);
		}

	}

}
