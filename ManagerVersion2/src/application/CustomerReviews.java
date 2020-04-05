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
