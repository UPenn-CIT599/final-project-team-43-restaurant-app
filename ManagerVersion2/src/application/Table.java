package application;
import java.util.ArrayList;
/**
 * This class monitors all the tables in the restaurant
 * @author yinjiezhang
 *
 */
public class Table {

	private int tableNumber;
	private boolean occupied;
	private boolean paid;
	private Order order; //Order class from customer 
	
	/**
	 * constructor
	 * @param num
	 * @param order
	 */
	public Table(int num, Order order) {
		this.tableNumber = num;
		this.order = order;
		occupied = false;
		paid = false;
	}
	
	private ArrayList<Table> tableList = new ArrayList<>();
	
	
	

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	
	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ArrayList<Table> getTableList() {
		return tableList;
	}

	public void setTableList(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
	
	
	
	
}
