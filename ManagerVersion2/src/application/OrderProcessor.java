package application;

import java.util.HashMap;

public class OrderProcessor {
	private CustomerOrder order;
	private Inventory inventory;
	private EmployeeControl employee;
	private CSVReader reader;
	String fileName;
	
	public OrderProcessor(String fName) {
		this.fileName = fName;	
		this.inventory = inventory;
		this.order = order;
		this.employee = employee;
		this
	}
public String fillOrder(CustomerOrder currentOrder);
	
	for (HashMap<Taco, Integer> tacoType : currentOrder.getTacos()) {
		double quantity = 0;
		double orderPrice = 0;
		for (Taco taco : tacoType.getTacos().getKeys()) {
			for (InventoryItem item : taco.getIngredients().getKeys()) {
				quantity = taco.get(taco) * item.get(item);
				reduceInventory(item.getItemID, quantity);
			}
		}
	}
}
