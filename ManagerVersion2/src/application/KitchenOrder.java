package application;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class to create an order consisting of various MenuItems be reading a .csv file
 * @author porth
 *
 */
public class KitchenOrder {

	HashMap<Drink, Integer> drinkOrder;
	HashMap<Taco, Integer> tacoOrder;
	HashMap<SideDish, Integer> sideOrder;
	HashMap<String, String> quantitiesAsString;
	private String customerId;
	private String orderId;
	private String serviceType;
	private String orderDate;
	private String orderTime;
	private String reservationId;
	private String reservationTime;
	private String reservationDate;
	private String deliveryAddress;
	private double totalBill;

	/*
	 * Constructor initializes MenuItem HashMaps and other variables
	 */
	public KitchenOrder() {
		HashMap<Drink, Integer> drinkOrder = new HashMap<Drink, Integer>();
		HashMap<Taco, Integer> tacoOrder = new HashMap<Taco, Integer>();
		HashMap<SideDish, Integer> sideOrder = new HashMap<SideDish, Integer>();
		HashMap<String, String> quantitiesAsString = new HashMap<String, String>();
		this.tacoOrder = tacoOrder;
		this.drinkOrder = drinkOrder;
		this.sideOrder = sideOrder;
		this.quantitiesAsString = quantitiesAsString;
		this.customerId = customerId;
		this.orderId = orderId;
		this.serviceType = serviceType;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.reservationId = reservationId;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.deliveryAddress = deliveryAddress;
		this.totalBill = totalBill;
	}
	//getter for drink order
	public HashMap<Drink, Integer> getDrinkOrder() {
		return drinkOrder;
	}
	// setter for drink order
	public void setDrinkOrder(HashMap<Drink, Integer> drinkOrder) {
		this.drinkOrder = drinkOrder;
	}
	//getter for taco order
	public HashMap<Taco, Integer> getTacoOrder() {
		return tacoOrder;
	}
	//setter for taco order
	public void setTacoOrder(HashMap<Taco, Integer> tacoOrder) {
		this.tacoOrder = tacoOrder;
	}
	//getter for side dish order
	public HashMap<SideDish, Integer> getSideOrder() {
		return sideOrder;
	}
	//setter for side dish order
	public void setSideOrder(HashMap<SideDish, Integer> sideOrder) {
		this.sideOrder = sideOrder;
	}
	//getter for customerID
	public String getCustomerId() {
		return customerId;
	}
	//setter for customerId
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	//getter for orderId
	public String getOrderId() {
		return orderId;
	}
	//setter for orderId
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	//getter for serviceType
	public String getServiceType() {
		return serviceType;
	}
	//setter for serviceType
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	//getter for orderDate
	public String getOrderDate() {
		return orderDate;
	}
	//setter for orderDate
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	//getter for orderTime
	public LocalTime getOrderTime() {
		return LocalTime.parse(orderTime);
	}
	//setter for orderTime
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	//getter for reservationId
	public String getReservationId() {
		return reservationId;
	}
	//setter for reservationId
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	//getter for reservationDate
	public String getReservationDate() {
		return reservationDate;
	}
	//setter for reservationDate
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	//getter for reservationTime
	public String getReservationTime() {
		return reservationTime;
	}
	//setter for reservationTime
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	//getter for delivery address
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	//setter for delivery address
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	//getter for total bill
	public double getTotalBill() {
		return totalBill;
	}
	//setter for total bill
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	//getter for quantitiesAs String
	public HashMap<String, String> getQuantitiesAsString() {
		return quantitiesAsString;
	}
	//setter for quantitiesAsString
	public void setQuantitiesAsString(HashMap<String, String> quantitiesAsString) {
		this.quantitiesAsString = quantitiesAsString;
	}

	/**
	 * initializes new OrderReader and fetches customerOrder to fill by reading
	 * first order in "CustomerOrders.csv"
	 * 
	 * @param fName name of CustomerOrders file
	 * @throws FileNotFoundException
	 */
	public KitchenOrder fetchOrder(String fName, Menu menu) throws FileNotFoundException {
		OrderReader rdr = new OrderReader(menu);
		rdr.readOneLine(fName);
		KitchenOrder newOrder = new KitchenOrder();
		newOrder = rdr.getOrder();
		return newOrder;

	}

}

