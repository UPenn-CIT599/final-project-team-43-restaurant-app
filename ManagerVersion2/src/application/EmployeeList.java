package application;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * This class generate the employee list for the restaurant
 * @author yinjiezhang
 *
 */
public class EmployeeList extends CSVReader{
	
	private ArrayList<EmployeeControl> employeeList = new ArrayList<>();
	
	/**
	 * constructor
	 * use readFile method from CSVReader parent class to generate employeeList arraylist
	 * @param fileName
	 */
	public EmployeeList(String fileName) {
		readFile(fileName);
	}

	public ArrayList<EmployeeControl> getEmployeeList() {
		return employeeList;
	}
	
	/**
	 * This putData method extends from CSVReader, can use information reading from "Employee List.csv" to generate
	 * its own arraylist for manager system presenting
	 */
	@Override
	public void putData(String[] columnInfo) {
		String name = columnInfo[0];
		int attendanceHours = Integer.parseInt(columnInfo[1]);
		double salary = Double.parseDouble(columnInfo[2]);
		boolean onDuty = Boolean.parseBoolean(columnInfo[3]);
		
		
		EmployeeControl employee;
		employee = new EmployeeControl(name, attendanceHours, salary, onDuty);
		
		employeeList.add(employee);
	}
	
	/**
	 * initialize an employee list and write them in a Employee List.cvs file
	 */
	public void generateEmployeeList() {
		EmployeeControl employee1, employee2, employee3, employee4, employee5;
		employee1 = EmployeeControl.employeeGenerator(); 
		employee2 = EmployeeControl.employeeGenerator();
		employee3 = EmployeeControl.employeeGenerator();
		employee4 = EmployeeControl.employeeGenerator();
		employee5 = EmployeeControl.employeeGenerator();
		
		try {
			PrintWriter pw = new PrintWriter("Employee List.csv");
			pw.println("name" + "," + "attendanceHours" + "," + "salary" + "," + "onDuty");
			
			pw.println(employee1.getName()+ "," + String.valueOf(employee1.getAttendanceHours()) + "," + 
					String.valueOf(employee1.getSalary()) + "," + String.valueOf(employee1.getOnDuty()));
			pw.println(employee2.getName()+ "," + String.valueOf(employee2.getAttendanceHours()) + "," + 
					String.valueOf(employee2.getSalary()) + "," + String.valueOf(employee2.getOnDuty()));
			pw.println(employee3.getName()+ "," + String.valueOf(employee3.getAttendanceHours()) + "," + 
					String.valueOf(employee3.getSalary()) + "," + String.valueOf(employee3.getOnDuty()));
			pw.println(employee4.getName()+ "," + String.valueOf(employee4.getAttendanceHours()) + "," + 
					String.valueOf(employee4.getSalary()) + "," + String.valueOf(employee4.getOnDuty()));
			pw.println(employee5.getName()+ "," + String.valueOf(employee5.getAttendanceHours()) + "," + 
					String.valueOf(employee5.getSalary()) + "," + String.valueOf(employee5.getOnDuty()));
			
			pw.flush();
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * add new employee to the list and write into the employee List.csv 
	 * Then the new employee will show on the Employee GUI
	 */
	public static void addEmployee() {
		EmployeeControl employee = EmployeeControl.employeeGenerator();
		EmployeeList list = new EmployeeList("Employee List.csv");
		list.employeeList.add(employee);
		
		try {
			
			FileWriter fw = new FileWriter("Employee List.csv", true);
			
			
			fw.write("\n");
			fw.write(employee.getName()+ "," + String.valueOf(employee.getAttendanceHours()) + "," + 
				     String.valueOf(employee.getSalary()) + "," + String.valueOf(employee.getOnDuty()));
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Assign an available employee to the customer who just ordered
	 */
	public static void assignEmployeeToCustomer() {
		EmployeeList list = new EmployeeList("Employee List.csv");
		
		String customerID = Customer.getCustomer().getCustomerID();
		for(int i = 0; i < list.employeeList.size(); i++) {
			if(list.employeeList.get(i).getOnDuty() && list.employeeList.get(i).) {
				
				break;
			}
		}
	}
	
	/**
	 * run to initiate employee list
	 * @param args
	 
	public static void main(String[] args) {
		EmployeeList el = new EmployeeList();
		el.generateEmployeeList();
	}*/
	
	
	
	
}
