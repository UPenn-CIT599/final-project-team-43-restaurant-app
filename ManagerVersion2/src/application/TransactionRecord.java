package application;
import java.util.ArrayList;
import java.util.Random;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * This class has all the transaction records for the restaurant
 * @author yinjiezhang
 *
 */
public class TransactionRecord {
	
	private SimpleIntegerProperty date;
	private SimpleIntegerProperty time;
	private SimpleDoubleProperty transactionAmount;
	private SimpleStringProperty paymentMethod;
	
	/**
	 * constructor
	 * @param date
	 * @param time
	 * @param transactionAmount
	 * @param paymentMethod
	 */
	public TransactionRecord(int date, int time, double transactionAmount, String paymentMethod) {
		this.date = new SimpleIntegerProperty(date);
		this.time = new SimpleIntegerProperty(time);
		this.transactionAmount = new SimpleDoubleProperty(transactionAmount);
		this.paymentMethod = new SimpleStringProperty(paymentMethod);
	}
	
	private ArrayList<TransactionRecord> realTimeTransactionRecord = new ArrayList<>();

	public int getDate() {
		return date.get();
	}

	public int getTime() {
		return time.get();
	}

	public double getTransactionAmount() {
		return transactionAmount.get();
	}

	public String getPaymentMethod() {
		return paymentMethod.get();
	}

	public ArrayList<TransactionRecord> getRealTimeTransactionRecord() {
		return realTimeTransactionRecord;
	}
	
	
	/**
	 * This method randomly generate transactions for the application, when in practical use, 
	 * it should be input by customer 
	 * @return transaction all the informations about one transaction
	 */
	public static TransactionRecord transactionGenerator() {
		TransactionRecord transaction;
		
		Random rd = new Random();
		
		int date;
		int time;
		double transactionAmount;
		String paymentMethod;
		
		date = rd.nextInt(31);
		time = rd.nextInt(2459);
		transactionAmount = Math.round(rd.nextDouble() * 100.0)/100.0 + rd.nextInt(100);
		
		//creating random paymentMethod
		String []banks = {"Visa", "Amex", "Discovery", "MasterCard"};
		
		paymentMethod = banks[rd.nextInt(4)];
		
		transaction = new TransactionRecord(date, time, transactionAmount, paymentMethod);
		
		return transaction;
	}
	
	
	
	
	
	
}
