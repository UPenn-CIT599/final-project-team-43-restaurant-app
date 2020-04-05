package application;


public class CustomerReviews {

	private int scoreOutOfFive;
	private String messageReview;

	/**
	 * Constructor for customer reviews
	 */
	public CustomerReviews() {
	}

	/**
	 * Saves the customer's review
	 * 
	 * @param scoreOutOfFive Customer's review of 1-5
	 * @param messageReview  Customer's message review
	 */
	public void giveReview(int scoreOutOfFive, String messageReview) {
		
		if (scoreOutOfFive <= 5 && scoreOutOfFive >= 1) {
			this.scoreOutOfFive = scoreOutOfFive;
			this.messageReview = messageReview;
		}
		
	}

	public int getScoreOutOfFive() {
		return scoreOutOfFive;
	}

	public void setScoreOutOfFive(int scoreOutOfFive) {
		this.scoreOutOfFive = scoreOutOfFive;
	}

	public String getMessageReview() {
		return messageReview;
	}

	public void setMessageReview(String messageReview) {
		this.messageReview = messageReview;
	}
	
	
	

}
