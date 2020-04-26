package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuItemTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Inventory inventory = new Inventory();
		Menu menu = new Menu();
		inventory.populateInventory("Inventory.csv");
		menu.populateMenu("MenuList.csv", inventory);			
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
