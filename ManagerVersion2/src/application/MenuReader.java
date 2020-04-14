package application;

import java.util.ArrayList;

public class MenuReader extends FileReader{
	private Menu menu;
	
	/**
	 * Constructor takes default FileReader constructor and
	 * Declared local variable ArrayLists to contain various
	 * MenuItem subclasses
	 */
	public MenuReader() {
		menu = new Menu();
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
		String inventoryId = columnInfo[3];
		Double portion = columnInfo[4];
		If(!columnInfo[0] = "");
			MenuItem item = new ItemType();
		for (item : Inventory.getInventory());
	}

}
