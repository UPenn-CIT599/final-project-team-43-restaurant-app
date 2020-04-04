package application;
import java.util.ArrayList;
import java.util.Random;
/**
 * This class monitors all the employees of the restaurant
 * @author yinjiezhang
 *
 */
public class EmployeeControl {

	private String name;
	private int attendanceHours;
	private int salary;
	private boolean onDuty;
	
	/**
	 * constructor
	 * @param name
	 * @param attendanceHours
	 * @param salary
	 */
	public EmployeeControl(String name, int attendanceHours, int salary, boolean onDuty) {
		this.name = name;
		this.attendanceHours = attendanceHours;
		this.salary = salary;
		this.onDuty = onDuty;
	}
	
	private ArrayList<EmployeeControl> employeeList = new ArrayList<>();
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttendanceHours() {
		return attendanceHours;
	}

	public void setAttendanceHours(int attendanceHours) {
		this.attendanceHours = attendanceHours;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isOnDuty() {
		return onDuty;
	}

	public void setOnDuty(boolean onDuty) {
		this.onDuty = onDuty;
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
	public EmployeeControl employeeGenerator() {
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
