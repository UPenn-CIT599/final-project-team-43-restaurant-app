package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OrderProcessorTest {
	static Inventory inventory;
	static Menu menu;
	static MenuItem testDish;
	static KitchenOrder tester;
	static OrderProcessor testProcessor;
	static OrderReader rdr;

	@BeforeAll

	static void setUpBeforeClass() throws Exception {

		inventory = new Inventory();
		menu = new Menu();
		inventory.populateInventory("InventoryTestFile.csv");
		menu.populateMenu("MenuList.csv", inventory);
		tester = new KitchenOrder();
		testProcessor = new OrderProcessor(tester);

	}

	// test to verify that last line of .csv file is being read
	@Test
	void testFetch() throws FileNotFoundException {
		tester = tester.fetchOrder("CustomerOrdersTest.csv", menu);
		String orderId = tester.getOrderId();
		assertEquals("test", orderId, "Incorrect ID, expected: test");
	}
	
	// Test to verify that the proper amount of inventory is being reduced
	//by fillOrder method
	@Test
	void testFill() throws FileNotFoundException {
		double testQty = 0;
		testProcessor.fillOrder(tester);
		for (InventoryItem item : inventory.getInventory()) {
			if (item.getItemID().contentEquals("F2344")) {
				testQty = item.getOnHand();
			}
		}
		assertEquals(108, testQty, .01, "Incorrect Amount, expected; 109");
	}
	
	
	// Test to verify that the proper order quantities will be written
	//to the transaction record
		@Test
		void testTransactionRecord() throws FileNotFoundException {
			String testQty = null;
			testProcessor.fillOrder(tester);
			testQty = tester.getQuantitiesAsString().get("vegTacoQty");		
			assertEquals("3", testQty, "Incorrect Amount, expected; 3");
		}
	
	//Test to verify that orderCompleted boolean is being set to "true"
		void testOrderComplete() throws FileNotFoundException {
			testProcessor.fillOrder(tester);
			boolean isComplete = testProcessor.getIsComplete();
			assertEquals("true", isComplete, "Incorrect value, expected true");
		}
}