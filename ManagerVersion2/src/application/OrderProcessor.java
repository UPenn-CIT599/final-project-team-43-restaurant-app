package application;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OrderProcessor {
	private KitchenOrder order;
	private Menu menu;
	private Inventory inventory;
	private EmployeeList empList = new EmployeeList("Employee List.csv");
	// private CSVReader reader;
	Boolean isComplete;
	private String paymentMethod;
	String[] banks = { "Visa", "Amex", "Discovery", "MasterCard" };
	String completedTime;
	private EmployeeControl employee;

	public OrderProcessor(KitchenOrder currentOrder) throws FileNotFoundException {

		this.employee = empList.assignEmployeeToCustomer();

		this.inventory = inventory;
		this.order = currentOrder;
		this.empList = empList;
		this.isComplete = false;
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Method goes through MenuItems in order and associated quantities, removing
	 * enough product from inventory to fill the order. It returns a boolean value
	 * if order is completed and calls writeTransactionRecord to write to
	 * TransactionRecord.csv
	 * 
	 * @param currentOrder
	 * @return
	 * @throws FileNotFoundException
	 */
	public void fillOrder() throws FileNotFoundException {
		double quantity = 0;
		double inventoryOut = 0;
		String employeeName = this.employee.getName();
		String[] banks = { "Visa", "Amex", "Discovery", "MasterCard", "Cash" };
		Random rd = new Random();
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime orderTime = this.order.getOrderTime();
		long secondsToAdd = 0;
		// iterates through taco types and quantities reducing associated inventoryItems
		for (Taco tacoType : this.order.getTacoOrder().keySet()) {
			quantity = this.order.getTacoOrder().get(tacoType);
			for (InventoryItem item : tacoType.getIngredients().keySet()) {
				inventoryOut = quantity * tacoType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}
		// iterates through drink types and quantities, reducing associated
		// inventoryItems
		for (Drink drinkType : this.order.getDrinkOrder().keySet()) {
			quantity = this.order.getDrinkOrder().get(drinkType);
			for (InventoryItem item : drinkType.getIngredients().keySet()) {
				inventoryOut = quantity * drinkType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}
		// iterates through side dishes and quantities, reducing associated Inventory
		// Items
		for (SideDish sideType : this.order.getSideOrder().keySet()) {
			quantity = this.order.getSideOrder().get(sideType);
			for (InventoryItem item : sideType.getIngredients().keySet()) {
				inventoryOut = quantity * sideType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}
		// adds random amount of time between 3 and 8 minutes to time of order
		secondsToAdd = 180 + rd.nextInt(300);
		this.completedTime = time.format(orderTime.plusSeconds(secondsToAdd));
		// assigns random paymentMethod to transaction
		this.paymentMethod = banks[rd.nextInt(5)];
		this.isComplete = true;
		// writeTransactionRecord(this.order, this.isComplete, this.completedTime,
		// employeeName, this.paymentMethod);
		writeTransactionRecord(this.order);
	}

	// public static void writeTransactionRecord(KitchenOrder order, Boolean
	// isComplete, String completedTime, String employeeName, String paymentMethod)
	// {
	public static void writeTransactionRecord(KitchenOrder order) {
		KitchenOrder writeOrder = order;
		try {
			Scanner in = new Scanner("TransactionRecord.csv");
			FileWriter fw = new FileWriter("TransactionRecord.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);

			int lineNumber = CSVReader.readNumberOfLines("TransactionRecord.csv") + 10000;

			in.nextLine();
			bw.newLine();

			while (in.hasNextLine()) {
				in.nextLine();
				bw.newLine();
			}
			bw.write(lineNumber + "," + order.getCustomerId() + "," + writeOrder.getServiceType() + ","
					+ writeOrder.getOrderDate() + "," + writeOrder.getOrderTime() + "," + "," + rdr.beefTacoQty + ","
					+ writeOrder.getTacoOrder().get(taco.getDescription()) + "," + writeOrder.getSideOrder().get(0) + ","
					+ writeOrder.getSideOrder().get(1) + "," + writeOrder.getSideOrder().get(2) + ","
					+ writeOrder.getDrinkOrder().get(0) + "," + writeOrder.getDrinkOrder().get(1) + ","
					+ writeOrder.getDrinkOrder().get(2) + "," + writeOrder.getDrinkOrder().get(3) + ","
					+ writeOrder.getTotalBill() + "," + isComplete + "," + completedTime + "," + "employee.getName()"
					+ "," + paymentMethod);
			bw.flush();
			bw.close();
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
