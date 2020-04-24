package application;

import java.util.HashMap;
import java.util.ArrayList;



public class OrderReader extends CSVReader {
	KitchenOrder order;
	Menu menu;
	Inventory inventory;
	
	public OrderReader() {
		order = new KitchenOrder();
		menu = new Menu();
		inventory = new Inventory();
	}
	

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
		int bfTacoQty = Integer.parseInt(columnInfo[8]);
		int chkTacoQty = Integer.parseInt(columnInfo[9]);
		int vegTacoQty = Integer.parseInt(columnInfo[10]);
		int nachoQty = Integer.parseInt(columnInfo[11]);
		int chipsQty = Integer.parseInt(columnInfo[12]);
		int beansQty = Integer.parseInt(columnInfo[13]);
		int drPQty = Integer.parseInt(columnInfo[14]);
		int spklWtrQty = Integer.parseInt(columnInfo[15]);
		int pepsiQty = Integer.parseInt(columnInfo[16]);
		int beerQty = Integer.parseInt(columnInfo[17]);
		double ttlPrice = Double.parseDouble(columnInfo[18]);
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
				order.tacoOrder.put(taco, chkTacoQty);
			}
			if (taco.getDescription().contentEquals("Veggie Taco")){
				order.tacoOrder.put(taco, vegTacoQty);
			}
		}
		for(SideDish side : menu.getSides()) {
			if (side.getDescription().contentEquals("Nachos")){
				order.sideOrder.put(side, nachoQty);
			}
			if (side.getDescription().contentEquals("Tortilla Chips")){
				order.sideOrder.put(side, chipsQty);
			}
			if (side.getDescription().contentEquals("Beans and Rice")){
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
			if (drink.getDescription().contentEquals("Pepsi")){
				order.drinkOrder.put(drink, pepsiQty);
			}
			if (drink.getDescription().contentEquals("Pacifico Beer")){
				order.drinkOrder.put(drink, beerQty);
			}
			
		}
		order.setTotalBill(ttlPrice);
	}
	
	public HashMap<String, String> getOrderQuantitiesAsStrings(String[] columnInfo){
		HashMap<String, String> quantities = new HashMap<String, String>();
		quantities.put("bfTacoQty", columnInfo[8]);
		quantities.put("chkTacoQty", columnInfo[9]);
		quantities.put("vegTacoQty", columnInfo[10]);
		quantities.put("nachosQty", columnInfo[11]);
		quantities.put("chipsQty", columnInfo[12]);
		quantities.put("beansQty", columnInfo[13]);
		quantities.put("drPQty", columnInfo[14]);
		quantities.put("spklWtrQty", columnInfo[15]);
		quantities.put("pepsiQty", columnInfo[16]);
		quantities.put("beerQty", columnInfo[17]);
		return quantities;
	}
	
	public KitchenOrder getOrder() {
		return order;
	}
	

}

