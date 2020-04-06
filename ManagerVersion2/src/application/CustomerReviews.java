package application;

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

}
