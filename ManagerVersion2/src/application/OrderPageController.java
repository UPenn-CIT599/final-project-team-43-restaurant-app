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
	
	ObservableList<String> menuItemQuantity = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

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
		serviceOption.setItems(serviceOptionList); // choiceboxes get filled with a custom list in initialize method
		beefTacoQuantity.setItems(menuItemQuantity);
		chickenTacoQuantity.setItems(menuItemQuantity);
		veggieTacoQuantity.setItems(menuItemQuantity);
		nachosQuantity.setItems(menuItemQuantity);
		tortillaQuantity.setItems(menuItemQuantity);
		riceBeansQuantity.setItems(menuItemQuantity);
		drPepperQuantity.setItems(menuItemQuantity);
		laCroixQuantity.setItems(menuItemQuantity);
		pepsiQuantity.setItems(menuItemQuantity);
		pacificoQuantity.setItems(menuItemQuantity);
		
		
		availFunds.setText("$" + Integer.toString(40));

	}

}
