package application;
import java.util.ArrayList;
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
	public EmployeeControl(String name, int attendanceHours, int salary) {
		this.name = name;
		this.attendanceHours = attendanceHours;
		this.salary = salary;
		this.onDuty = false;
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
	
	
}
