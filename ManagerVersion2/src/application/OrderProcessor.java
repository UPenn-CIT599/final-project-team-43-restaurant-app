package application;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class OrderProcessor {
	private KitchenOrder order;
	private Inventory inventory;
	private EmployeesController employee;
	String fileName;
	Boolean isFilled;

	public OrderProcessor(String fName) {
		this.fileName = fName;
		this.inventory = inventory;
		this.order = order;
		this.employee = employee;
		this.isFilled = false;
	}

	public boolean fillOrder(KitchenOrder currentOrder) throws FileNotFoundException {
		double quantity = 0;
		double inventoryOut = 0;
		this.order.fetchOrder("CustomerOrder.csv");
		for (Taco tacoType : this.order.getTacoOrder().keySet()) {
		quantity = this.order.getTacoOrder().get(tacoType);
			for (InventoryItem item : tacoType.getIngredients().keySet()) {
				inventoryOut = quantity * tacoType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}

		for (Drink drinkType : this.order.getDrinkOrder().keySet()) {
			quantity = this.order.getDrinkOrder().get(drinkType);
			for (InventoryItem item : drinkType.getIngredients().keySet()) {
				inventoryOut = quantity * drinkType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}

		for (SideDish sideType : this.order.getSideOrder().keySet()) {
			quantity = this.order.getSideOrder().get(sideType);
			for (InventoryItem item : sideType.getIngredients().keySet()) {
				inventoryOut = quantity * sideType.getIngredients().get(item);
				item.reduceOnHand(inventoryOut);
			}
		}

		this.isFilled = true;
		return isFilled;
	}
}
