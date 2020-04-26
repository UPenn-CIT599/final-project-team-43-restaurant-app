package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerOrderTest {

	/**
	 * This test method checks the calculation of the total price of an arbitrary
	 * quantity of each food item
	 */
	@Test
	void testCalculateTotalPrice1() {
		int beefTQty = 2;
		int chickenTQty = 1;
		int veggieTQty = 0;
		int nachosQty = 1;
		int tortillaQty = 0;
		int riceBeansQty = 2;
		int drPepperQty = 1;
		int spkWaterQty = 1;
		int pepsiQty = 1;
		int pacificoQty = 0;

		double totalPrice = CustomerOrder.calculateTotalPrice(beefTQty, chickenTQty, veggieTQty, nachosQty, tortillaQty,
				riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty);

		assertEquals(28.7, totalPrice, "Incorrect, value should be 28.7");
	}

	/**
	 * This test method checks if the correct total price is calculated if every
	 * food item is set to the maximum quantity available for purchase
	 */
	@Test
	void testCalculateTotalPrice2() {
		int beefTQty = 5;
		int chickenTQty = 5;
		int veggieTQty = 5;
		int nachosQty = 5;
		int tortillaQty = 5;
		int riceBeansQty = 5;
		int drPepperQty = 5;
		int spkWaterQty = 5;
		int pepsiQty = 5;
		int pacificoQty = 5;

		double totalPrice = CustomerOrder.calculateTotalPrice(beefTQty, chickenTQty, veggieTQty, nachosQty, tortillaQty,
				riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty);

		assertEquals(166.0, totalPrice, "Incorrect, value should be 166.0");
	}

	
	/**
	 * This test method checks if the correct total price is calculated if every
	 * food item is set to the minimum quantity available for purchase
	 */
	@Test
	void testCalculateTotalPrice3() {
		int beefTQty = 0;
		int chickenTQty = 0;
		int veggieTQty = 0;
		int nachosQty = 0;
		int tortillaQty = 0;
		int riceBeansQty = 0;
		int drPepperQty = 0;
		int spkWaterQty = 0;
		int pepsiQty = 0;
		int pacificoQty = 0;

		double totalPrice = CustomerOrder.calculateTotalPrice(beefTQty, chickenTQty, veggieTQty, nachosQty, tortillaQty,
				riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty);

		assertEquals(0.0, totalPrice, "Incorrect, value should be 0.0");
	}

}
