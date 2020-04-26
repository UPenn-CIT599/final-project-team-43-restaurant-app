package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	/**
	 * This test method checks if the funds of the customer are set to some value
	 * between $30.0 and $40.0 by default
	 */
	@Test
	void testAvailableFunds() {

		Boolean betweenThirtyAndForty = false;

		double availableFunds = Customer.getCustomer().getAvailableFunds();

		if ((availableFunds >= 30) && (availableFunds <= 40)) {
			betweenThirtyAndForty = true;
		} else {
			betweenThirtyAndForty = false;
		}

		assertEquals(true, betweenThirtyAndForty, "Incorrect, available funds should be between 30.0 and 40.0");

	}

	/**
	 * This method checks if the proper amount of money is deducted after a customer
	 * makes a purchase
	 */
	@Test
	void testDeductFunds() {
		double costOfFood = 10.0;
		double availableFunds = 40.0;
		Customer.getCustomer().setAvailableFunds(availableFunds);
		double amountRemaining = Customer.deductFunds(availableFunds, costOfFood);
		assertEquals(30.0, amountRemaining, "Incorrect, amount remaining should be equal to 30.0");

	}

}
