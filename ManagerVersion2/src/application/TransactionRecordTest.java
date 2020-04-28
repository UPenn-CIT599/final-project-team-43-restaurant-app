package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Junit test for TransactionRecord class
 * 
 * @author yinjiezhang
 *
 */
class TransactionRecordTest {

	static TransactionRecord transactionRecord;

	@BeforeAll

	static void setUpBeforeClass() throws Exception {
		transactionRecord = new TransactionRecord("CustomerOrders.csv");

	}

	/**
	 * Test whether the array List generated from the csv file contains items
	 * excluding reservation items
	 */
	@Test
	void testTransactionRecord() {
		int arraySize = transactionRecord.getRealTimeTransactionRecord().size();
		int csvLength = 0;

		try {
			csvLength = CSVReader.readNumberOfLines("CustomerOrders.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(arraySize, csvLength - 2);

	}

}
