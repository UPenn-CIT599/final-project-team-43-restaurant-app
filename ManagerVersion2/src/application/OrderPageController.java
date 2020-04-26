package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrderPageController {



	@FXML
	private Button btnBack, orderButton, btnCheckPrice;

	@FXML
	private TextField availFunds, totalPriceBox, addressBox;

	@FXML
	private ChoiceBox serviceOption, beefTacoQuantity, chickenTacoQuantity, veggieTacoQuantity, nachosQuantity,
			tortillaQuantity, riceBeansQuantity, drPepperQuantity, laCroixQuantity, pepsiQuantity, pacificoQuantity;

	ObservableList<String> serviceOptionList = FXCollections.observableArrayList("Delivery", "Dine in");

	ObservableList<String> menuItemQuantity = FXCollections.observableArrayList("0", "1", "2", "3", "4", "5");

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnBack.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));

		if (event.getSource() == btnBack) {
			stage = (Stage) btnBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	public void orderClicked(ActionEvent event) throws Exception {
		
		
		
		Stage stage = (Stage) orderButton.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		
		//serviceType stores the value of the serviceOptionChoiceBox
		String serviceType = (String) serviceOption.getValue();

		//sets up format for date and time
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
		
		//variable now stores the time of order
		LocalDateTime now = LocalDateTime.now();

		//stores current date/time of order in currentDate and currentTime variables
		String currentDate = date.format(now);
		String currentTime = time.format(now);

		// stores customer's available funds in availableFunds
		double availableFunds = Customer.getCustomer().getAvailableFunds();

		// stores customer ID in customerID
		String customerID = Customer.getCustomer().getCustomerID();

		//assigns quantity to each menu item based on selection in ChoiceBoxes
		int beefTQty = Integer.parseInt(beefTacoQuantity.getValue().toString());
		int chickenTQty = Integer.parseInt(chickenTacoQuantity.getValue().toString());
		int veggieTQty = Integer.parseInt(veggieTacoQuantity.getValue().toString());
		int nachosQty = Integer.parseInt(nachosQuantity.getValue().toString());
		int tortillaQty = Integer.parseInt(tortillaQuantity.getValue().toString());
		int riceBeansQty = Integer.parseInt(riceBeansQuantity.getValue().toString());
		int drPepperQty = Integer.parseInt(drPepperQuantity.getValue().toString());
		int spkWaterQty = Integer.parseInt(laCroixQuantity.getValue().toString());
		int pepsiQty = Integer.parseInt(pepsiQuantity.getValue().toString());
		int pacificoQty = Integer.parseInt(pacificoQuantity.getValue().toString());
		
		Inventory inv = new Inventory();
		inv.populateInventory("Inventory.csv");
		
		Menu menu = new Menu();
		menu.populateMenu("MenuList.csv", inv);

		// calculates total cost of all items
		double totalCost = CustomerOrder.calculateTotalPrice(beefTQty, chickenTQty, veggieTQty, nachosQty, tortillaQty,
				riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty);
		
		// removes commas from the customer-inputed address
		String address = addressBox.getText().replaceAll(",", "");
		
		//by default, a order will be assumed to be a bad order
		stage = (Stage) orderButton.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("BadOrder.fxml"));
		
		// if no service option is selected, bad order page is shown
		if (event.getSource() == orderButton && serviceOption.getSelectionModel().isEmpty()) {
			stage = (Stage) orderButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("BadOrder.fxml"));
		}

		// this if-block runs if the order is for dine in only
		else if (event.getSource() == orderButton && serviceType.equals("Dine in") && availableFunds >= totalCost && totalCost != 0) {

			stage = (Stage) orderButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPlaced.fxml"));
			/*
			totalCost = CustomerOrder.calculateTotalPrice(beefTQty, chickenTQty, veggieTQty, nachosQty,
					tortillaQty, riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty);
*/
			CustomerOrder.writeOrderDineIn(customerID, serviceType, currentDate, currentTime, beefTQty, chickenTQty,
					veggieTQty, nachosQty, tortillaQty, riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty,
					totalCost);
			
			BankAccount.getBankAccount().makeDeposit(totalCost);
			
			Customer.getCustomer().setAvailableFunds(Customer.deductFunds(availableFunds, totalCost));
			
			TableList.assignTableToOrder();
			
			
			
			
			
			
			
		
		} 
		// this if-block runs if the order is for delivery only
		else if (event.getSource() == orderButton && serviceType.equals("Delivery") && availableFunds >= totalCost
				&& totalCost != 0 && !address.isEmpty()) {

			stage = (Stage) orderButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPlaced.fxml"));
/*
			totalCost = CustomerOrder.calculateTotalPrice(beefTQty, chickenTQty, veggieTQty, nachosQty,
					tortillaQty, riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty);
*/
			CustomerOrder.writeOrderDelivery(customerID, serviceType, currentDate, currentTime, beefTQty, chickenTQty,
					veggieTQty, nachosQty, tortillaQty, riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty,
					totalCost, address);
			
			BankAccount.getBankAccount().makeDeposit(totalCost);
			
			Customer.getCustomer().setAvailableFunds(Customer.deductFunds(availableFunds, totalCost));
			
			
			
			
			
			
			

		} 


		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	@FXML
	public void checkPrices(ActionEvent event) throws Exception {
		if (event.getSource() == btnCheckPrice) {
			int beefTQty = Integer.parseInt(beefTacoQuantity.getValue().toString());
			int chickenTQty = Integer.parseInt(chickenTacoQuantity.getValue().toString());
			int veggieTQty = Integer.parseInt(veggieTacoQuantity.getValue().toString());
			int nachosQty = Integer.parseInt(nachosQuantity.getValue().toString());
			int tortillaQty = Integer.parseInt(tortillaQuantity.getValue().toString());
			int riceBeansQty = Integer.parseInt(riceBeansQuantity.getValue().toString());
			int drPepperQty = Integer.parseInt(drPepperQuantity.getValue().toString());
			int spkWaterQty = Integer.parseInt(laCroixQuantity.getValue().toString());
			int pepsiQty = Integer.parseInt(pepsiQuantity.getValue().toString());
			int pacificoQty = Integer.parseInt(pacificoQuantity.getValue().toString());
			
			Inventory inv = new Inventory();
			inv.populateInventory("Inventory.csv");
			
			Menu menu = new Menu();
			menu.populateMenu("MenuList.csv", inv);

			// calculates total cost of all items
			double totalCost = CustomerOrder.calculateTotalPrice(beefTQty, chickenTQty, veggieTQty, nachosQty, tortillaQty,
					riceBeansQty, drPepperQty, spkWaterQty, pepsiQty, pacificoQty);
			totalPriceBox.setText("$" + Double.toString((totalCost)));
		}
		
	}
	
	
	
	
	
	
	

	@FXML
	public void display() {
		availFunds = new TextField(); // textfields need to be initialized in display method
		totalPriceBox = new TextField();

	}

	@FXML
	public void initialize() {
		serviceOption.setItems(serviceOptionList); // choiceboxes get filled with a custom list in initialize method

		beefTacoQuantity.setValue("0"); // setValue method sets the argument as the default option
		beefTacoQuantity.setItems(menuItemQuantity);

		chickenTacoQuantity.setValue("0");
		chickenTacoQuantity.setItems(menuItemQuantity);

		veggieTacoQuantity.setValue("0");
		veggieTacoQuantity.setItems(menuItemQuantity);

		nachosQuantity.setValue("0");
		nachosQuantity.setItems(menuItemQuantity);

		tortillaQuantity.setValue("0");
		tortillaQuantity.setItems(menuItemQuantity);

		riceBeansQuantity.setValue("0");
		riceBeansQuantity.setItems(menuItemQuantity);

		drPepperQuantity.setValue("0");
		drPepperQuantity.setItems(menuItemQuantity);

		laCroixQuantity.setValue("0");
		laCroixQuantity.setItems(menuItemQuantity);

		pepsiQuantity.setValue("0");
		pepsiQuantity.setItems(menuItemQuantity);

		pacificoQuantity.setValue("0");
		pacificoQuantity.setItems(menuItemQuantity);

		availFunds.setText("$" + Double.toString(Customer.getCustomer().getAvailableFunds()));

	}

}
