package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class monitors the customer aspect of our restaurant application
 * 
 * @author yangliu
 */

public class Customer {

	String customerID;

	private double availableFunds; // Funds that the customer has available to spend

	private String reservationID; // the customer's reservationID set upon making reservation
	private String reservationDate;
	private String reservationTime;

	private Menu menu;

	private static Customer customer = new Customer();

	private CustomerReviews review;

	/**
	 * Constructor for the customer class. Customer is given a random amount of
	 * money to spend ($30 - $40)
	 */
	public Customer() {
		availableFunds = Math.round(10 * Math.random() + 30);
	}

	/**
	 * returns available funds to be spent by the customer
	 * 
	 * @return available funds of the customer
	 */
	public double getAvailableFunds() {
		return availableFunds;
	}

	/**
	 * sets the available funds of the customer
	 * 
	 * @param availableFunds the amount of funds to set
	 */
	public void setAvailableFunds(double availableFunds) {
		this.availableFunds = availableFunds;
	}


	/**
	 * Getter for the review that the customer gave
	 * 
	 * @return
	 */
	public CustomerReviews getReview() {
		return review;
	}

	/**
	 * Setter for the review that the customer gave
	 * 
	 * @param review
	 */
	public void setReview(CustomerReviews review) {
		this.review = review;
	}

	public static Customer getCustomer() {
		return customer;
	}

	public Menu getMenu() {
		return menu;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getReservationID() {
		return reservationID;
	}

	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}



	//Writes reservation to CustomerOrders.csv
	public static void writeReservation(String customerID, String reservationID, String date, String time) {
		try {
			Scanner in = new Scanner("CustomerOrders.csv");
			FileWriter fw = new FileWriter("CustomerOrders.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);

			int lineNumber = CSVReader.readNumberOfLines("CustomerOrders.csv") + 10000;

			in.nextLine();
			bw.newLine();

			while (in.hasNextLine()) {
				in.nextLine();
				bw.newLine();
			}
			bw.write(lineNumber + "," + customerID + "," + "Dine in" + "," + "," + "," + reservationID + "," + date
					+ "," + time + "," + "," + "," + "," + "," + "," + "," + "," + "," + "," + "," + ",");
			bw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method calculates a Customer's remaining funds after making a purchase
	 * @param totalCost total cost of all food items
	 * @param availableFunds available funds of the customer
	 * @return the remaining funds of the customer
	 */
	public static double deductFunds(double availableFunds, double totalCost) {
		return availableFunds - totalCost;
	}
	
	
	
}
