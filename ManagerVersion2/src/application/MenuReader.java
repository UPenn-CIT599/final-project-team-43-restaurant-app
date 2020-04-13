package application;

import java.util.ArrayList;

public class MenuReader extends FileReader{
	private ArrayList<Drink> drinks;
	private ArrayList<Taco> tacos;
	private ArrayList<SideDish> sides;
	
	/**
	 * Constructor takes default FileReader constructor and
	 * Declared local variable ArrayLists to contain various
	 * MenuItem subclasses
	 */
	public MenuReader() {
		drinks = new ArrayList<Drink>();
		tacos = new ArrayList<Taco>();
		sides = new ArrayList<SideDish>();
	}	
	
	/**
	 * putData method goes through CSV file data, check to see if
	 * data is Drink, Taco, or Side, creates the appropriate MenuItem
	 * and adds it to one of the ArrayLists
	 */
	@Override
	public void putData(String[] columnInfo) {
		// TODO Auto-generated method stub
		
	}

}
