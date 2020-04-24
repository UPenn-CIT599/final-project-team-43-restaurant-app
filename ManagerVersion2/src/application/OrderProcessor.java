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
	private Inventory inventory;
	private EmployeeList empList = new EmployeeList("Employee List.csv");
	//private CSVReader reader;
	Boolean isComplete;
	private EmployeeControl employee ;
	private String paymentMethod;		
	String []banks = {"Visa", "Amex", "Discovery", "MasterCard"};
	String completedTime;
	

	public OrderProcessor() throws FileNotFoundException {
		this.inventory = inventory;
		this.order = new KitchenOrder();
		this.order = order.fetchOrder("CustomerOrders.csv");
		this.empList = empList;
		this.isComplete = false;
		this.employee = employee;
		this.paymentMethod = paymentMethod;
	}
/**
 * Method calls fetchOrder to read most recent order from .csv file. It then goes through
 * MenuItems and associated quantities, removing enough product from inventory to fill the order.
 * It returns a boolean value notifying the caller that the order is processed.
 * @param currentOrder
 * @return
 * @throws FileNotFoundException
 */
	public void fillOrder() throws FileNotFoundException {
		double quantity = 0;
		double inventoryOut = 0;
		String []banks = {"Visa", "Amex", "Discovery", "MasterCard", "Cash"};
		Random rd = new Random();
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime orderTime = this.order.getOrderTime();
		long secondsToAdd = 0;
		//iterates through taco types and quantities reducing associated inventoryItems
		for (Taco tacoType : this.order.getTacoOrder().keySet()) {
		quantity = this.order.getTacoOrder().get(tacoType);
			for (InventoryItem item : tacoType.getIngredients().keySet()) {
				inventoryOut = quantity * tacoType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}
//iterates through drink types and quantities, reducing associated inventoryItems
		for (Drink drinkType : this.order.getDrinkOrder().keySet()) {
			quantity = this.order.getDrinkOrder().get(drinkType);
			for (InventoryItem item : drinkType.getIngredients().keySet()) {
				inventoryOut = quantity * drinkType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}
//iterates through side dishes and quantities, reducing associated Inventory Items
		for (SideDish sideType : this.order.getSideOrder().keySet()) {
			quantity = this.order.getSideOrder().get(sideType);
			for (InventoryItem item : sideType.getIngredients().keySet()) {
				inventoryOut = quantity * sideType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}
		secondsToAdd = 180 + rd.nextInt(300);
		orderTime = orderTime.plusSeconds(secondsToAdd);
		this.completedTime = time.format(orderTime);
		//this.employee = empList.assignEmployeeToCustomer();
		this.paymentMethod = banks[rd.nextInt(5)];
		this.isComplete = true;
		writeTransactionRecord(this.order, this.isComplete, this.completedTime, this.employee, this.paymentMethod);
		
	}
	
	public static void writeTransactionRecord(KitchenOrder order, Boolean isComplete, String completedTime, EmployeeControl employee, String paymentMethod) {
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
			bw.write(lineNumber + "," + writeOrder.getCustomerId() + "," + writeOrder.getServiceType() + "," + writeOrder.getOrderDate() + "," + writeOrder.getOrderTime() + "," + 
		 + "," + writeOrder.getTacoOrder().get(1) + "," + writeOrder.getTacoOrder().get(2) + "," + writeOrder.getSideOrder().get(0)+ "," + writeOrder.getSideOrder().get(1)
					+ "," + writeOrder.getSideOrder().get(2) + "," + writeOrder.getDrinkOrder().get(0) + "," + writeOrder.getDrinkOrder().get(1) + "," + writeOrder.getDrinkOrder().get(2) + "," + writeOrder.getDrinkOrder().get(3)
					+ "," + writeOrder.getTotalBill() + "," + isComplete + "," + completedTime + "," + "employee.getName()" + "," + paymentMethod);
			bw.flush();
			bw.close();
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args) throws FileNotFoundException {
		Inventory inventory = new Inventory();
		inventory.populateInventory("Inventory.csv");
		OrderProcessor processor = new OrderProcessor();
		processor.fillOrder();
		
	}*/
}

