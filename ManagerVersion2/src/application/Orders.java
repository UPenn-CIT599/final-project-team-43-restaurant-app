package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Orders {
	/**
	 * @author yangliu
	 */
	private HashMap<Taco, Integer> tacoItemToOrderQuantity;
	private HashMap<Drink, Integer> drinkItemToOrderQuantity;
	private HashMap<SideDish, Integer> sideDishItemToOrderQuantity;

	private HashMap<Customer, Taco> customerTacosToOrdersForPickup;
	private HashMap<Customer, Drink> customerDrinkToOrdersForPickup;
	private HashMap<Customer, SideDish> customerToSideDishOrdersForPickup;

	private HashMap<Customer, Taco> customerTacosToOrdersForDelivery;
	private HashMap<Customer, Drink> customerDrinkToOrdersForDelivery;
	private HashMap<Customer, SideDish> customerToSideDishOrdersForDelivery;

	/**
	 * Constructor for Orders
	 * 
	 * @param customer the customer who is ordering
	 * @param delivery set true if order is delivery; set false if order is pickup
	 */
	public Orders(Customer customer, boolean delivery) {

	}

	
	
	// Need method below to assign quantity to each item that the customer ordered

}
