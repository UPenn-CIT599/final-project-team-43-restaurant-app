package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

public class InventoryReader {

	private ArrayList<InventoryItem> inventoryList;
	

	/**
	 * Constructor takes filename of csv file as parameter
	 * 
	 * @param filename
	 */
	public InventoryReader(String filename) {
		File file = new File(filename);
		inventoryList = new ArrayList<InventoryItem>();

		// read file
		try {
			Scanner scan = new Scanner(file);
			scan.nextLine();
			while (scan.hasNextLine()) {
				String itemRow = scan.nextLine();
				// System.out.println(itemRow);
				String[] columnInfo = itemRow.split(",");
				/*
				 * column 0 for itemId (store as String) column 1 for name (store as
				 * String) column 2 for packSize (store as Double) column 3 for units(store as
				 * String) column 4 for vendor (store as String) column 5 for
				 * packPrice (store as Double) column 6 for onHand (store
				 * as Double) column 7 for calories
				 * (store as Integer) 
				 */
				// write data to new InventoryItem object in ArrayList
			
					String itemId = columnInfo[0];
					String name = columnInfo[1];
					double packSize = Double.parseDouble(columnInfo[2]);
					String units = columnInfo[3];
					String vendor = columnInfo[4];
					double price = Double.parseDouble(columnInfo[5]);
					double onHand = Double.parseDouble(columnInfo[6]);
					int calories = Integer.parseInt(columnInfo[7]);
					InventoryItem item = new InventoryItem(itemId, name, packSize, units, vendor, price, onHand,
							calories);
					inventoryList.add(item);
			}

			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * getter returns ArrayList of Flight objects
	 * 
	 * @return
	 */
	public ArrayList<InventoryItem> getInventoryList() {
		return inventoryList;
	}
}
