package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MenuItemTester {
	static Inventory inventory;
	static Menu menu;
	static MenuItem testDish;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		inventory = new Inventory();
		menu = new Menu();
		inventory.populateInventory("Inventory.csv");
		menu.populateMenu("MenuList.csv", inventory);			
		for (SideDish side : menu.getSides()) {
			if (side.description.contentEquals("Nachos")){
				testDish = side;
			}
		}
	}
 
	//test to see if MenuItem.setCost calculates the correct item cost
	@Test
	void testSetCost() {
		double testCost = testDish.getCost();
		assertEquals(1.074, testCost, .01, "Incorrect cost, expected 1.074");
	}
	//test to see if MenuItem.setPrice calculates the correct price
	@Test
	void testSetPrice() {
		double testPrice = testDish.getPrice();
		assertEquals(4.95, testPrice, "Incorrect price, expected 4.95");
	}
	// test to see if MenuItem.setCalories calculates the correct calorie count
	@Test
	void testSetCalories() {
		double testCalories = testDish.getCalories();
		assertEquals(592, testCalories, "Incorrect cost, expected 1.074");
	}
}
