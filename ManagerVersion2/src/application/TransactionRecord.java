package application;
import java.util.ArrayList;
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
	
	
	
	
	
	
	
	
}
