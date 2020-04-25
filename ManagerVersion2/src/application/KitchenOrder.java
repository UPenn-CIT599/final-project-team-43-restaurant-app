package application;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.HashMap;

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

	public HashMap<Drink, Integer> getDrinkOrder() {
		return drinkOrder;
	}

	public void setDrinkOrder(HashMap<Drink, Integer> drinkOrder) {
		this.drinkOrder = drinkOrder;
	}

	public HashMap<Taco, Integer> getTacoOrder() {
		return tacoOrder;
	}

	public void setTacoOrder(HashMap<Taco, Integer> tacoOrder) {
		this.tacoOrder = tacoOrder;
	}

	public HashMap<SideDish, Integer> getSideOrder() {
		return sideOrder;
	}

	public void setSideOrder(HashMap<SideDish, Integer> sideOrder) {
		this.sideOrder = sideOrder;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public LocalTime getOrderTime() {
		return LocalTime.parse(orderTime);
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public HashMap<String, String> getQuantitiesAsString() {
		return quantitiesAsString;
	}

	public void setQuantitiesAsString(HashMap<String, String> quantitiesAsString) {
		this.quantitiesAsString = quantitiesAsString;
	}

	/**
	 * initializes new OrderReader and fetches customerOrder to fill by reading
	 * first order in "CustomerOrders.csv"
	 * 
	 * @param fName
	 * @throws FileNotFoundException
	 */
	public KitchenOrder fetchOrder(String fName, Menu menu) throws FileNotFoundException {
		OrderReader rdr = new OrderReader(menu);
		rdr.readOneLine(fName);
		KitchenOrder newOrder = new KitchenOrder();
		newOrder = rdr.getOrder();
		return newOrder;

	}

	public static void main(String[] args) throws FileNotFoundException {
		KitchenOrder currentOrder = new KitchenOrder();
		Inventory inventory = new Inventory();
		Menu menu = new Menu();
		inventory.populateInventory("Inventory.csv");
		menu.populateMenu("MenuList.csv", inventory);
		
		for (Taco taco : menu.tacos) {
			System.out.println(taco.description + " $" + taco.price);
		}
		for (Drink drink : menu.drinks) {
			System.out.println(drink.description + " $" + drink.price);
		}
		for (SideDish side : menu.sides) {
			System.out.println(side.description + " $" + side.price);
		}
		menu.populateMenu("MenuList.csv", inventory);
		for (Taco taco : menu.tacos) {
			System.out.println(taco.description + " $" + taco.price);
		}
		for (Drink drink : menu.drinks) {
			System.out.println(drink.description + " $" + drink.price);
		}
		for (SideDish side : menu.sides) {
			System.out.println(side.description + " $" + side.price);
		}
		currentOrder = currentOrder.fetchOrder("CustomerOrders.csv", menu);
		//System.out.println(currentOrder.serviceType);

		OrderProcessor processor = new OrderProcessor(currentOrder);
		processor.fillOrder();
		for(InventoryItem item : inventory.getInventory()) {
			if(item.getItemID().contentEquals("S8825")) {
				System.out.println(item.getOnHand());
			}
		}
		//processor.writeTransactionRecord(record);
		//System.out.println(processor.completedTime);
		//processor.writeTransactionRecord();

	}
	
}

