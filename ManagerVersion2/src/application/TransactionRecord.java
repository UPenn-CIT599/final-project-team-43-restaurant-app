package application;
import java.util.ArrayList;
import java.util.Random;
/**
 * This class has all the transaction records for the restaurant
 * @author yinjiezhang
 *
 */
public class TransactionRecord {
	
	private int date;
	private int time;
	private double transactionAmount;
	private String paymentMethod;
	
	/**
	 * constructor
	 * @param date
	 * @param time
	 * @param transactionAmount
	 * @param paymentMethod
	 */
	public TransactionRecord(int date, int time, double transactionAmount, String paymentMethod) {
		this.date = date;
		this.time = time;
		this.transactionAmount = transactionAmount;
		this.paymentMethod = paymentMethod;
	}
	
	private ArrayList<TransactionRecord> realTimeTransactionRecord = new ArrayList<>();

	public int getDate() {
		return date;
	}

	public int getTime() {
		return time;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public ArrayList<TransactionRecord> getRealTimeTransactionRecord() {
		return realTimeTransactionRecord;
	}
	
	
	/**
	 * This method randomly generate transactions for the application, when in practical use, 
	 * it should be input by customer 
	 * @return transaction all the informations about one transaction
	 */
	public TransactionRecord transactionGenerator() {
		TransactionRecord transaction;
		
		Random rd = new Random();
		
		int date;
		int time;
		double transactionAmount;
		String paymentMethod;
		
		date = rd.nextInt(31);
		time = rd.nextInt(2459);
		transactionAmount = rd.nextDouble()+ rd.nextInt(100);
		
		//creating random paymentMethod
		String []banks = {"Visa", "Amex", "Discovery", "MasterCard"};
		
		paymentMethod = banks[rd.nextInt(4)];
		
		transaction = new TransactionRecord(date, time, transactionAmount, paymentMethod);
		
		return transaction;
	}
	
	
	
	
	
	
}
