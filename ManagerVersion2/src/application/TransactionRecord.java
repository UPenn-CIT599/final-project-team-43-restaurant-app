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
	private SimpleStringProperty time;
	private SimpleDoubleProperty transactionAmount;
	private SimpleStringProperty paymentMethod;
	
	/**
	 * constructor
	 * @param date
	 * @param time
	 * @param transactionAmount
	 * @param paymentMethod
	 */
	public TransactionRecord(int date, String time, double transactionAmount, String paymentMethod) {
		this.date = new SimpleIntegerProperty(date);
		this.time = new SimpleStringProperty(time);
		this.transactionAmount = new SimpleDoubleProperty(transactionAmount);
		this.paymentMethod = new SimpleStringProperty(paymentMethod);
	}
	
	private ArrayList<TransactionRecord> realTimeTransactionRecord = new ArrayList<>();

	public int getDate() {
		return date.get();
	}

	public String getTime() {
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
		String time;
		double transactionAmount;
		String paymentMethod;
		
		while(true) {
			date = rd.nextInt(31);
			if(date != 0) {
				break;
			}
		}
		time = "" + String.valueOf(rd.nextInt(24)) + ":" + String.valueOf(rd.nextInt(60));
		transactionAmount = Math.round(rd.nextDouble() * 100.0)/100.0 + rd.nextInt(100);
		
		//creating random paymentMethod
		String []banks = {"Visa", "Amex", "Discovery", "MasterCard"};
		
		paymentMethod = banks[rd.nextInt(4)];
		
		transaction = new TransactionRecord(date, time, transactionAmount, paymentMethod);
		
		return transaction;
	}
	
	
	
	
	
	
}
