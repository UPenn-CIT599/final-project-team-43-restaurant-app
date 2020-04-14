package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerReviews {
	/**
	 * Class for customer reviews
	 * 
	 * @author yangliu
	 */

	private int scoreOutOfFive;
	private String messageReview;

	/**
	 * Constructor for customer reviews
	 */
	public CustomerReviews() {
	}

	/**
	 * Getter for the customer's numerical score review (1-5)
	 * @return int value of 1-5
	 */
	public int getScoreOutOfFive() {
		return scoreOutOfFive;
	}

	/**
	 * Setter for the customer's numerical score review (1-5)
	 * @param scoreOutOfFive
	 */
	public void setScoreOutOfFive(int scoreOutOfFive) {
		this.scoreOutOfFive = scoreOutOfFive;
	}

	/**
	 * Getter for the customer's message review
	 * @return
	 */
	public String getMessageReview() {
		return messageReview;
	}

	/**
	 * Setter for the customer's message review
	 * @param messageReview
	 */
	public void setMessageReview(String messageReview) {
		this.messageReview = messageReview;
	}
	
	
	
	/**
	 * Adds the customer review into the restaurantreviews.csv file.  All reviews are 
	 * stored in this file and will not be overwritten upon successive calls of this method.
	 */
	public void addReview() {

		try {
			Scanner in = new Scanner("restaurantreviews.csv");
			FileWriter fw= new FileWriter("restaurantreviews.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			in.nextLine();
			bw.newLine();
			while (in.hasNextLine()) {
				in.nextLine();
				bw.newLine();
				
			}
			bw.write(Integer.toString(scoreOutOfFive) + "," + messageReview);
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//Below is the test for add review. 
	/*
	
	public static void main(String[] args) {

		Customer a = new Customer();
		CustomerReviews review = new CustomerReviews();
		review.setMessageReview("Test review");
		review.setScoreOutOfFive(5);
		a.setReview(review);
		a.getReview().addReview();
		
	}
	
*/
	
	
}
