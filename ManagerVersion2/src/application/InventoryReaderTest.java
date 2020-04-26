package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for InventoryReader class
 * 
 * @author yinjiezhang
 *
 */
class InventoryReaderTest {

	static InventoryReader inventoryReader;

	@BeforeAll

	static void setUpBeforeClass() throws Exception {
		inventoryReader = new InventoryReader("InventoryTest.csv");

	}

	/**
	 * Test whether the array List generated from the csv file contains same number
	 * of items
	 */
	@Test
	void testInventoryReader() {
		int arraySize = inventoryReader.getInventoryList().size();
		int csvLength = 0;

		try {
			csvLength = CSVReader.readNumberOfLines("InventoryTest.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(arraySize, csvLength - 1);
	}

}
