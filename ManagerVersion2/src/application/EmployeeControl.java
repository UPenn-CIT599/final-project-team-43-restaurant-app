package application;
import java.util.ArrayList;
import java.util.Random;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * This class monitors all the employees of the restaurant
 * @author yinjiezhang
 *
 */
public class EmployeeControl {

	private SimpleStringProperty name;
	private SimpleIntegerProperty attendanceHours;
	private SimpleIntegerProperty salary;
	private SimpleBooleanProperty onDuty;
	
	
	
	
	private ArrayList<EmployeeControl> employeeList = new ArrayList<>();
	
	
	
	/**
	 * constructor
	 * @param name
	 * @param attendanceHours
	 * @param salary
	 * @param onDuty
	 */
	public EmployeeControl(String name, int attendanceHours, int salary, boolean onDuty) {
		super();
		this.name = new SimpleStringProperty(name);
		this.attendanceHours = new SimpleIntegerProperty(attendanceHours);
		this.salary = new SimpleIntegerProperty(salary);
		this.onDuty = new SimpleBooleanProperty(onDuty);
	
	}

	

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public Integer getAttendanceHours() {
		return attendanceHours.get();
	}

	public void setAttendanceHours(Integer attendanceHours) {
		this.attendanceHours = new SimpleIntegerProperty(attendanceHours);
	}

	public Integer getSalary() {
		return salary.get();
	}

	public void setSalary(Integer salary) {
		this.salary = new SimpleIntegerProperty(salary);
	}

	public Boolean getOnDuty() {
		return onDuty.getValue();
	}

	public void setOnDuty(Boolean onDuty) {
		this.onDuty = new SimpleBooleanProperty(onDuty);
	}

	public ArrayList<EmployeeControl> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<EmployeeControl> employeeList) {
		this.employeeList = employeeList;
	}



	/**
	 * This method randomly generate employees for the application, when in practical use, 
	 * it can be input by manager 
	 * @return employee all the informations about one employee
	 */
	public static EmployeeControl employeeGenerator() {
		EmployeeControl employee;
		
		Random rd = new Random();
		
		String name;
		int attendanceHours;
		int salary;
		boolean onDuty;
		
		attendanceHours = rd.nextInt(160);
		salary = rd.nextInt(3600);
		onDuty = rd.nextBoolean();
		
		//creating random name without any API, like Faker
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		final int N = 7;//random name with 7 char long
		for(int i = 0; i < N; i++) {
			sb.append(alphabet.charAt(rd.nextInt(alphabet.length())));
		}
		name = sb.toString();
		
		employee = new EmployeeControl(name, attendanceHours, salary, onDuty);
		
		return employee;
	}
}
