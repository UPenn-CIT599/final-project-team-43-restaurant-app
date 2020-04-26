package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * JUnit test for EmployeeList class
 * @author yinjiezhang
 *
 */
class EmployeeListTest {
	static EmployeeList employeelist;

	@BeforeAll

	static void setUpBeforeClass() throws Exception {
		employeelist = new EmployeeList("Employee List.csv");

	}

	/**
	 * Test whether the array List generated from the csv file contains same number
	 * of items
	 */
	@Test
	void testEmployeeList() {
		int arraySize = employeelist.getEmployeeList().size();
		int csvLength = 0;

		try {
			csvLength = CSVReader.readNumberOfLines("Employee List.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(arraySize, csvLength - 1);
	}

	/**
	 * Test whether addEmployee method can add one employee to csv file when called
	 */
	@Test
	void testAddEmployee() {
		// EmployeeControl[]copyOfPreviousEmployeeList =
		// employeelist.getEmployeeList().toArray(new
		// EmployeeControl[employeelist.getEmployeeList().size()]);
		int previousArraySize = 0;
		try {
			previousArraySize = CSVReader.readNumberOfLines("Employee List.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EmployeeList.addEmployee();

		int addOneArraySize = 0;
		try {
			addOneArraySize = CSVReader.readNumberOfLines("Employee List.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(previousArraySize + 1, addOneArraySize);

	}

}
