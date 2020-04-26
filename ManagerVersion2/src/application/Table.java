package application;

/**
 * This class monitors one tables in the restaurant
 * 
 * @author yinjiezhang
 *
 */
public class Table {

	private boolean occupied;
	private boolean paid;

	/**
	 * constructor default status of a table is not occupied and not paid
	 */
	public Table() {
		occupied = false;
		paid = false;

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

}
