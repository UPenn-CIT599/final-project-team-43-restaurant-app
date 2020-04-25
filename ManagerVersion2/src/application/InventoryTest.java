package application;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * test for the createProductOrder method
 */
import java.util.ArrayList;

class InventoryTest {
	static Inventory inventory;
	@BeforeAll
	
	static void setUpBeforeClass() throws Exception {
		inventory = new Inventory();
		inventory.populateInventory("Inventory.csv");
		}


	@Test //checks to see if correct number of products are added to productorder
	void testCreateProductOrder() {
		ArrayList<InventoryItem> order = inventory.createProductOrder();
		int numProducts = order.size();
		assertEquals(3, numProducts, "Incorrect number of products, expected 3");
	}

}
