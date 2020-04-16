package application;

import java.net.URL;
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
	private Button btnBack;

	@FXML
	private TextField availFunds, totalPrice;

	@FXML
	private ChoiceBox serviceOption, beefTacoQuantity, chickenTacoQuantity, veggieTacoQuantity, nachosQuantity,
			tortillaQuantity, riceBeansQuantity, drPepperQuantity, laCroixQuantity, pepsiQuantity, pacificoQuantity;

	ObservableList<String> serviceOptionList = FXCollections.observableArrayList("Delivery", "Dine in");
	
	ObservableList<String> menuItemQuantity = FXCollections.observableArrayList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

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
	public void display() {
		availFunds = new TextField(); // textfields need to be initialized in display method
	}

	@FXML
	public void initialize() {
		Customer a = new Customer();
		serviceOption.setItems(serviceOptionList); // choiceboxes get filled with a custom list in initialize method
		
		beefTacoQuantity.setValue("0");  // setValue method sets the argument as the default option
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
		
		availFunds.setText("$" + Double.toString(a.getAvailableFunds()));

	}

}
