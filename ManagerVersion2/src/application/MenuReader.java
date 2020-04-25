package application;

import java.util.ArrayList;

public class MenuReader extends CSVReader{
	private Menu menu;
	Inventory inventory;
	/**
	 * Constructor takes default FileReader constructor and
	 * Declared local variable ArrayLists to contain various
	 * MenuItem subclasses
	 */
	public MenuReader() {
		menu = new Menu();
		inventory = new Inventory();
	}	
	
	/**
	 * putData method goes through CSV file data, check to see if
	 * data is Drink, Taco, or Side, creates the appropriate MenuItem
	 * and adds it to one of the ArrayLists
	 */
	@Override
	public void putData(String[] columnInfo) {
		// TODO Auto-generated method stub
		String itemType = columnInfo[0];
		String description = columnInfo[1];
		String inventoryId = "";
		
		double portion = 0.0;
		
		if(!columnInfo[0].contentEquals("")){
			//System.out.println(description);
			if(columnInfo[0].toLowerCase().contentEquals("drink")) {
				Drink item = new Drink();
				item.setDescription(description);
				for(int i = 3; i < columnInfo.length; i += 3) {
					inventoryId = columnInfo[i];
					portion = Double.parseDouble(columnInfo[i + 1]);
						for (InventoryItem product : inventory.getInventory()) {
								if(product.getItemID().contentEquals(inventoryId)) {
									//System.out.println(inventoryId);
										item.getIngredients().put(product, portion);
								}
						}					
				}
				menu.drinks.add(item);
			}
			else if(columnInfo[0].toLowerCase().contentEquals("taco")) {
				Taco item = new Taco();
				item.setDescription(description);
				for(int i = 3; i < columnInfo.length; i += 3) {
					inventoryId = columnInfo[i];
					portion = Double.parseDouble(columnInfo[i + 1]);
						for (InventoryItem product : inventory.getInventory()) {
								if(product.getItemID().contentEquals(inventoryId)) {
									//System.out.println(inventoryId);	
									item.getIngredients().put(product, portion);
								}
						}					
				}
				menu.tacos.add(item);
			}
		
			else if(columnInfo[0].contentEquals("SideDish")) {
				SideDish item = new SideDish();	
				item.setDescription(description);
				for(int i = 3; i < columnInfo.length; i += 3) {
					inventoryId = columnInfo[i];
					portion = Double.parseDouble(columnInfo[i + 1]);
						for (InventoryItem product : inventory.getInventory()) {
								if(product.getItemID().contentEquals(inventoryId)) {
									//System.out.println(inventoryId);
									item.getIngredients().put(product, portion);
								}
						}		
				}
				menu.sides.add(item);
			}
			else {
				System.out.println("Invalid MenuItem");
			}
		}
	}
	public Menu getMenu() {
		return menu;
	}
	
	public ArrayList<Drink> getDrinks() {
		return menu.drinks;
	}
	
	public ArrayList<Taco> getTacos(){
		return menu.tacos;
	}
	
	public ArrayList<SideDish> getSideDishes(){
		return menu.sides;
	}
	
	
}
