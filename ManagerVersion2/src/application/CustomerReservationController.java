package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * This class controls the CustomerReservation FXML file
 * 
 * @author yangliu
 *
 */
public class CustomerReservationController extends Application {
	
	
	@FXML
	private Button btnCustomerHome, btnReservation;
	
	@FXML
	private ChoiceBox reservationTimeCBox;

	ObservableList<String> availableTimes = FXCollections.observableArrayList("9 AM", "10 AM", "11 AM", "12 PM", "1 PM",
			"2 PM", "3 PM", "4 PM", "5 PM");

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {

		Stage stage = (Stage) btnCustomerHome.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("CustomerReservation.fxml"));

		if (event.getSource() == btnCustomerHome) {
			stage = (Stage) btnCustomerHome.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		} else if (event.getSource() == btnReservation) {
			stage = (Stage) btnReservation.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("ReservationConfirmation.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	public void initialize() {
		reservationTimeCBox.setItems(availableTimes);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}
}
