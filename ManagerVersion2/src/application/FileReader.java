package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Abstract class to read data from CSV files
 * 
 * @author porth
 *
 */
public abstract class FileReader {

	public FileReader() {
	}
	
	/**
	 * abstract method putData to populate various data structures
	 * with values from the input file
	 * @param columnInfo
	 */
	public abstract void putData(String[] columnInfo);

	/**
	 * Read file method accepts name (path) of .csv file, 
	 * skips first line and processes file line by line, calling
	 * putData at each line
	 * @param filename
	 */
	public void readFile(String filename) {
		File file = new File(filename);
		try {
			Scanner scan = new Scanner(file);
			scan.nextLine();
			while (scan.hasNextLine()) {
				String itemRow = scan.nextLine();
				// System.out.println(itemRow);
				String[] columnInfo = itemRow.split(",");

				putData(columnInfo);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
