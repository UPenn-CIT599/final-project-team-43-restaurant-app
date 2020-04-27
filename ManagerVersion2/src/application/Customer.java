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
	private String reservationDate; // the customer's reservation date set upon making reservation
	private String reservationTime; // the customer's reservation time (local) set upon making reservation

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

	/**
	 * Getter for the customer
	 * 
	 * @return
	 */
	public static Customer getCustomer() {
		return customer;
	}

	/**
	 * Getter for the customer ID
	 * 
	 * @return customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * Setter for the customer ID
	 * 
	 * @param customerID customer ID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/**
	 * Getter for the reservation ID
	 * 
	 * @return reervationID
	 */
	public String getReservationID() {
		return reservationID;
	}

	/**
	 * Setter for reservationID
	 * 
	 * @param reservationID Reservation ID to set
	 */
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	/**
	 * Getter for the customer's reservation date
	 * 
	 * @return reservation date
	 */
	public String getReservationDate() {
		return reservationDate;
	}

	/**
	 * Setter for the customer's reservation date
	 * 
	 * @param reservationDate Reservation date to set
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * Getter for the customer's reservation time
	 * 
	 * @return reservationTime
	 */
	public String getReservationTime() {
		return reservationTime;
	}

	/**
	 * Setter for the customer's reservation time
	 * 
	 * @param reservationTime Reservation time to set
	 */
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	/**
	 * This method writes a reservation to CustomerOrder.csv
	 * 
	 * @param customerID    CustomerID String value
	 * @param reservationID ReservationID String value
	 * @param date          date of reservation
	 * @param time          time of reservation (local time)
	 */
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
	 * 
	 * @param totalCost      total cost of all food items
	 * @param availableFunds available funds of the customer
	 * @return the remaining funds of the customer
	 */
	public static double deductFunds(double availableFunds, double totalCost) {
		return availableFunds - totalCost;
	}

}
