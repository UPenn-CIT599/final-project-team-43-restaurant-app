package application;

import java.util.ArrayList;
/**
 * Class for preparation of a single taco.
 *
 * @author porth
 *g
 */
public class Taco {

	private InventoryItem shell;
	private InventoryItem filling;
	private ArrayList<InventoryItem> garnish;
	private InventoryItem sauce;
	private double price;
	
	public Taco (InventoryItem shell, InventoryItem filling, ArrayList<InventoryItem> garnish, InventoryItem sauce){
		this.shell = shell;
		this.filling = filling;
		this.garnish = garnish;
		this.sauce = sauce;
		this.price = 0.00;
	}

	public InventoryItem getShell() {
		return shell;
	}

	public InventoryItem getFilling() {
		return filling;
	}

	public ArrayList<InventoryItem> getGarnish() {
		return garnish;
	}

	public InventoryItem getSauce() {
		return sauce;
	}

	public double getPrice() {
		return price;
	}
	
	
}
