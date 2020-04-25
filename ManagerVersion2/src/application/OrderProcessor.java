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
	KitchenOrder order;
	// Menu menu;
	Inventory inventory;
	private EmployeeList empList = new EmployeeList("Employee List.csv");
	// private CSVReader reader;
	private Boolean isComplete;
	private String paymentMethod;
	private String completedTime;
	private EmployeeControl employee;

	public OrderProcessor(KitchenOrder currentOrder) throws FileNotFoundException {
		Inventory inventory = new Inventory();
		// Menu menu = new Menu();
		KitchenOrder order = new KitchenOrder();
		order = currentOrder;
		// this.employee = empList.assignEmployeeToCustomer();

		this.inventory = inventory;
		this.order = order;
		// this.empList = empList;
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
		// String employeeName = this.employee.getName();
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
		String transRecord;
		transRecord = createTransactionRecord();
		writeTransactionRecord(transRecord);
		//writeInventory(this.inventory);
	}

	public String createTransactionRecord() {
		String record;
		record = (this.order.getOrderId() + "," + this.order.getCustomerId() + "," + this.order.getServiceType() + ","
				+ this.order.getOrderDate() + "," + this.order.getOrderTime() + ","
				+ this.order.getQuantitiesAsString().get("bfTacoQty") + ","
				+ this.order.getQuantitiesAsString().get("chkTacoQty") + ","
				+ this.order.getQuantitiesAsString().get("vegTacoQty") + ","
				+ this.order.getQuantitiesAsString().get("nachosQty") + ","
				+ this.order.getQuantitiesAsString().get("chipsQty") + ","
				+ this.order.getQuantitiesAsString().get("beansQty") + ","
				+ this.order.getQuantitiesAsString().get("drPQty") + ","
				+ this.order.getQuantitiesAsString().get("spklWtrQty") + ","
				+ this.order.getQuantitiesAsString().get("pepsiQty") + ","
				+ this.order.getQuantitiesAsString().get("beerQty") + "," + this.order.getTotalBill() + ","
				+ this.isComplete + "," + this.completedTime + "," + "employeeName goes here" + ","
				+ this.paymentMethod);
		System.out.println(record);
		return record;
	}

	public static String createInventoryUpdate(InventoryItem item) {
		InventoryItem  product = item;
		String inventoryRecord = (product.getItemID() + "," + product.getItemName() + "," + product.getPackSize()+ "," + product.getUnits() + "," + product.getVendorName() + "," + product.getPackPrice() + "," + product.getOnHand() + "," + product.getCalorie());
		return inventoryRecord;
	}
		
	
		
	public static void writeTransactionRecord(String record) {
		String transRecord = record;
		try {
			Scanner in = new Scanner("TransactionRecord.csv");
			FileWriter fw = new FileWriter("TransactionRecord.csv", true);
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

	public static void writeInventory(Inventory inventory) {
		Inventory inv = inventory;
		String inventoryRecord;
		try {
			Scanner in = new Scanner("Inventory.csv");
			FileWriter fw = new FileWriter("Inventory.csv");
			BufferedWriter bw = new BufferedWriter(fw);

			in.nextLine();
			bw.newLine();
			for (InventoryItem item : inv.getInventory()) {
				inventoryRecord = createInventoryUpdate(item);
				bw.write(inventoryRecord);
			}
			bw.flush();
			bw.close();
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
