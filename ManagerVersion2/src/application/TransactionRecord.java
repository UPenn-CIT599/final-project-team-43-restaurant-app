package application;
import java.util.ArrayList;
import java.util.Random;
/**
 * This class has all the transaction records for the restaurant
 * @author yinjiezhang
 *
 */
public class TransactionRecord extends CSVReader {
	
	private ArrayList<TransactionItem> realTimeTransactionRecord = new ArrayList<>();
	
	/**
	 * constructor
	 * use readFile method from CSVReader parent class to generate realTimeTransactionRecord arraylist
	 * @param fileName
	 */
	public TransactionRecord(String fileName) {
		readFile(fileName);
	}

	public ArrayList<TransactionItem> getRealTimeTransactionRecord() {
		return realTimeTransactionRecord;
	}



	/**
	 * This putData method extends from CSVReader, can use information reading from "CustomerOrders.csv" to generate
	 * its own arraylist for manager system presenting
	 */
	@Override
	public void putData(String[] columnInfo) {
		String customerID = columnInfo[1];
		String date = columnInfo[3];
		String time = columnInfo[4];
		double transactionAmount = Double.parseDouble(columnInfo[15]);
		
		//creating random paymentMethod
		Random rd = new Random();
		String []banks = {"Visa", "Amex", "Discovery", "MasterCard"};
		String paymentMethod = banks[rd.nextInt(4)];
		
		TransactionItem transaction;
		transaction = new TransactionItem(customerID, date, time, transactionAmount, paymentMethod);
		
		realTimeTransactionRecord.add(transaction);
	}
	
	
}
