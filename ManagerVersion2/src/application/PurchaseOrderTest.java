package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * class to test the function of PurchaseOrder class via the replenishInventory
 * method
 * 
 * @author porth
 *
 */
class PurchaseOrderTest {
	static Inventory inventory;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		inventory = new Inventory();
		inventory.populateInventory("InventoryTestFile.csv");
	}

//tests whether the total cost of products ordered is correct
	@Test
	void testReplenishInventory() {
		double cost = inventory.replenishInventory(inventory.createProductOrder());
		assertEquals(28.16, .01, cost, "Incorrect cost, expected: 28.26");
	}

}
