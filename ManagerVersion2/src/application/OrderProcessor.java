package application;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class OrderProcessor {
	private KitchenOrder order;
	private Inventory inventory;


	private EmployeeControl employee;
	private CSVReader reader;
<<<<<<< HEAD



=======
>>>>>>> f294834e39ee72770b1c3b57550e8aef858a698d
	String fileName;
	Boolean isFilled;

	public OrderProcessor(String fName) {
		this.fileName = fName;
		this.inventory = inventory;
		this.order = order;
		this.employee = employee;
		this.isFilled = false;
	}
/**
 * Method calls fetchOrder to read most recent order from .csv file. It then goes through
 * MenuItems and associated quantities, removing enough product from inventory to fill the order.
 * It returns a boolean value notifying the caller that the order is processed.
 * @param currentOrder
 * @return
 * @throws FileNotFoundException
 */
	public boolean fillOrder(KitchenOrder currentOrder) throws FileNotFoundException {
		double quantity = 0;
		double inventoryOut = 0;
		this.order = order.fetchOrder("CustomerOrder.csv");
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

		this.isFilled = true;
		return isFilled;
	}
}
