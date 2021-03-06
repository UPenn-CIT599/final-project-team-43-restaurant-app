package application;

import java.util.ArrayList;

/**
 * Class to read data from .csv file into an ArrayList of InventoryItem objects
 * Subclass of abstract class FileReader
 * 
 * @author porth, yinjiez
 *
 */
public class InventoryReader extends CSVReader {

	private ArrayList<InventoryItem> inventoryList = new ArrayList<>();

	/**
	 * Constructor creates default instance of FileReader with additional instance
	 * variable to store inventory items
	 */
	public InventoryReader(String fileName) {

		readFile(fileName);
	}

	/**
	 * getter returns ArrayList of InventoryItem objects
	 * 
	 * @return
	 */
	public ArrayList<InventoryItem> getInventoryList() {
		return inventoryList;
	}

	/**
	 * putData function creates new inventoryItems and initializes their fields with
	 * data from input file
	 */
	@Override
	public void putData(String[] columnInfo) {
		// TODO Auto-generated method stub
		/*
		 * column 0 for itemId (store as String) column 1 for name (store as String)
		 * column 2 for packSize (store as Double) column 3 for units(store as String)
		 * column 4 for vendor (store as String) column 5 for packPrice (store as
		 * Double) column 6 for onHand (store as Double) column 7 for calories (store as
		 * Integer)
		 */
		// write data to new InventoryItem object in ArrayList

		String itemId = columnInfo[0];
		String name = columnInfo[1];
		double packSize = Double.parseDouble(columnInfo[2]);
		String units = columnInfo[3];
		String vendor = columnInfo[4];
		double price = Double.parseDouble(columnInfo[5]);
		double onHand = Double.parseDouble(columnInfo[6]);
		double calories = Double.parseDouble(columnInfo[7]);
		InventoryItem item = new InventoryItem(itemId, name, calories, units, packSize, price, onHand, vendor);
		inventoryList.add(item);

	}

}
