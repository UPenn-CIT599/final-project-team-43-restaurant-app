package application;


import java.util.HashMap;


/**
 * This class keeps track of the orders for the customers
 * 
 * @author yangliu
 *
 */

public class Orders {


	private Customer customer;
	private double totalPrice;
	private String estimatedTimeOfDelivery;

	private HashMap<Taco, Integer> tacoItemToOrderQuantity;
	private HashMap<Drink, Integer> drinkItemToOrderQuantity;
	private HashMap<SideDish, Integer> sideDishItemToOrderQuantity;

	private HashMap<Customer, Taco> customerTacosToOrdersForPickup;
	private HashMap<Customer, Drink> customerDrinkToOrdersForPickup;
	private HashMap<Customer, SideDish> customerSideDishToOrdersForPickup;

	private HashMap<Customer, Taco> customerTacosToOrdersForDelivery;
	private HashMap<Customer, Drink> customerDrinkToOrdersForDelivery;
	private HashMap<Customer, SideDish> customerSideDishToOrdersForDelivery;

	/**
	 * Constructor for Orders
	 * 
	 * @param customer the customer who is ordering
	 * @param delivery set true if order is delivery; set false if order is pickup
	 */
	public Orders(Customer customer, boolean delivery) {

		//order object contains the customer
		this.setCustomer(customer);

		//order items for delivery are in a separate hashmap from pickup
		if (delivery == true) {
			for (Taco taco : customer.getTacoOrders()) {
				customerTacosToOrdersForDelivery.put(customer, taco);
			}
			for (Drink drink : customer.getDrinkOrders()) {
				customerDrinkToOrdersForDelivery.put(customer, drink);
			}
			for (SideDish sideDish : customer.getSideDishOrders()) {
				customerSideDishToOrdersForDelivery.put(customer, sideDish);
			}
		} else if (delivery == false) {
			for (Taco taco : customer.getTacoOrders()) {
				customerTacosToOrdersForPickup.put(customer, taco);
			}
			for (Drink drink : customer.getDrinkOrders()) {
				customerDrinkToOrdersForPickup.put(customer, drink);
			}
			for (SideDish sideDish : customer.getSideDishOrders()) {
				customerSideDishToOrdersForPickup.put(customer, sideDish);
			}
		}
	}

	// Need method below to assign quantity to each item that the customer ordered
	public void assignItemQuantity() {
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getEstimatedTimeOfDelivery() {
		return estimatedTimeOfDelivery;
	}

	public void setEstimatedTimeOfDelivery(String estimatedTimeOfDelivery) {
		this.estimatedTimeOfDelivery = estimatedTimeOfDelivery;
	}

	public HashMap<Taco, Integer> getTacoItemToOrderQuantity() {
		return tacoItemToOrderQuantity;
	}

	public HashMap<Drink, Integer> getDrinkItemToOrderQuantity() {
		return drinkItemToOrderQuantity;
	}

	public HashMap<SideDish, Integer> getSideDishItemToOrderQuantity() {
		return sideDishItemToOrderQuantity;
	}
	
	
	
	
	
}
