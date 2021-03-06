package application;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * test for the createProductOrder method
 */
import java.util.ArrayList;

class InventoryTest {
	static Inventory inventory;
	@BeforeAll
	
	static void setUpBeforeClass() throws Exception {
		inventory = new Inventory();
		inventory.populateInventory("InventoryTestFile.csv");
		}


	@Test //checks to see if correct number of products are added to product order
	void testCreateProductOrder() {
		ArrayList<PurchaseOrder> order = inventory.createProductOrder();
		int numProducts = order.size();
		assertEquals(3, numProducts, "Incorrect number of products, expected 3");
	}
	
	//@ParameterizedTest //checks to see if correct number of products are added to productorder
	void testBuyProduct(InventoryItem product, int units) {
		InventoryItem testItem = null;
		ArrayList<InventoryItem> testInv = inventory.getInventory();
		for(InventoryItem item : testInv) {
			if (item.getItemID().contentEquals("2166R")){
				testItem = item;	
			}
		}
		double available = inventory.buyProduct(testItem, 10);
		assertEquals(12.2, available, "Incorrect quanity on hand, expected 12.2");
	}
	
}
