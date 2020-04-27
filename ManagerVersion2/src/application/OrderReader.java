package application;

import java.util.HashMap;
import java.util.ArrayList;


/**
 * Class to read CustomerOrder.csv to fill a new KitchenOrder object
 * with data from the file
 * @author porth
 *
 */
public class OrderReader extends CSVReader {
	KitchenOrder order;
	Menu menu;

	/*
	 * Constructor takes Menu as argument and creates a new KitchenOrder object
	 */
	public OrderReader(Menu currentMenu) {
		order = new KitchenOrder();
		menu = new Menu();
		menu = currentMenu;
	}
	
	//abstract method to populate KitchenOrder with data read from .csv
	@Override
	public void putData(String[] columnInfo) {
		// TODO Auto-generated method stub
		String orderId = columnInfo[0];
		String customerId = columnInfo[1];
		String serviceType = columnInfo[2];
		String orderDate = columnInfo[3];
		String orderTime = columnInfo[4];
		String reservationId = columnInfo[5];
		String reservationDate = columnInfo[6];
		String reservationTime = columnInfo[7];
		Integer bfTacoQty = Integer.parseInt(columnInfo[8]);
		Integer chkTacoQty = Integer.parseInt(columnInfo[9]);
		Integer vegTacoQty = Integer.parseInt(columnInfo[10]);
		Integer nachoQty = Integer.parseInt(columnInfo[11]);
		Integer chipsQty = Integer.parseInt(columnInfo[12]);
		Integer beansQty = Integer.parseInt(columnInfo[13]);
		Integer drPQty = Integer.parseInt(columnInfo[14]);
		Integer spklWtrQty = Integer.parseInt(columnInfo[15]);
		Integer pepsiQty = Integer.parseInt(columnInfo[16]);
		Integer beerQty = Integer.parseInt(columnInfo[17]);
		Double ttlPrice = Double.parseDouble(columnInfo[18]);
		String delivAddress;
		order.setOrderId(orderId);
		order.setCustomerId(customerId);
		order.setOrderDate(orderDate);
		order.setOrderTime(orderTime);
		order.setServiceType(serviceType);
		if (!reservationId.contentEquals("")){
			order.setReservationId(reservationId);
			order.setReservationDate(reservationDate);
			order.setReservationTime(reservationTime);
		}
		if (serviceType.toLowerCase().contentEquals("delivery")) {
			delivAddress = columnInfo[19];
			order.setDeliveryAddress(delivAddress);
		}
		for(Taco taco : menu.getTacos()) {
			
			if (taco.getDescription().contentEquals("Beef Taco")){
				order.tacoOrder.put(taco, bfTacoQty);
			}
			
			if (taco.getDescription().contentEquals("Chicken Taco")){
				order.getTacoOrder().put(taco, chkTacoQty);
			}
			if (taco.getDescription().contentEquals("Veggie Taco")){
				order.getTacoOrder().put(taco, vegTacoQty);
			}
		}
		for(SideDish side : menu.getSides()) {
			if (side.getDescription().contentEquals("Nachos")){
				order.sideOrder.put(side, nachoQty);
			}
			if (side.getDescription().contentEquals("Tortilla Chips")){
				order.sideOrder.put(side, chipsQty);
			}
			if (side.getDescription().contentEquals("Rice and Beans")){
				order.sideOrder.put(side, beansQty);
			}
		}
		for(Drink drink : menu.getDrinks()) {
			if (drink.getDescription().contentEquals("Dr Pepper")){
				order.drinkOrder.put(drink, drPQty);
			}
			if (drink.getDescription().contentEquals("Sparkling Water")){
				order.drinkOrder.put(drink, spklWtrQty);
			}
			if (drink.getDescription().contentEquals("Pepsi Cola")){
				order.drinkOrder.put(drink, pepsiQty);
			}
			if (drink.getDescription().contentEquals("Pacifico Beer")){
				order.drinkOrder.put(drink, beerQty);
			}
			
		}
		order.setTotalBill(ttlPrice);
		
		//puts order items and quantities in hashMap for writing to transaction record
		order.quantitiesAsString.put("bfTacoQty", columnInfo[8]);
		order.quantitiesAsString.put("chkTacoQty", columnInfo[9]);
		order.quantitiesAsString.put("vegTacoQty", columnInfo[10]);
		order.quantitiesAsString.put("nachosQty", columnInfo[11]);
		order.quantitiesAsString.put("chipsQty", columnInfo[12]);
		order.quantitiesAsString.put("beansQty", columnInfo[13]);
		order.quantitiesAsString.put("drPQty", columnInfo[14]);
		order.quantitiesAsString.put("spklWtrQty", columnInfo[15]);
		order.quantitiesAsString.put("pepsiQty", columnInfo[16]);
		order.quantitiesAsString.put("beerQty", columnInfo[17]);
		
	}
	//Retrieves HashMap for writing to TransactionRecord.csv
	public HashMap<String, String> getOrderQuantitiesAsStrings(String[] columnInfo){
		HashMap<String, String> quantities = new HashMap<String, String>();
		order.quantitiesAsString.put("bfTacoQty", columnInfo[8]);
		order.quantitiesAsString.put("chkTacoQty", columnInfo[9]);
		order.quantitiesAsString.put("vegTacoQty", columnInfo[10]);
		order.quantitiesAsString.put("nachosQty", columnInfo[11]);
		order.quantitiesAsString.put("chipsQty", columnInfo[12]);
		order.quantitiesAsString.put("beansQty", columnInfo[13]);
		order.quantitiesAsString.put("drPQty", columnInfo[14]);
		order.quantitiesAsString.put("spklWtrQty", columnInfo[15]);
		order.quantitiesAsString.put("pepsiQty", columnInfo[16]);
		order.quantitiesAsString.put("beerQty", columnInfo[17]);
		return quantities;
	}
	//getter for KitchenOrder object
	public KitchenOrder getOrder() {
		return order;
	}
	

}

