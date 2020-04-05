package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.event.ActionEvent;

public class CustomerReservationController extends Application {
	@FXML
	private Button btnCustomerHome;
	private ChoiceBox<String> reservationTimeCBox;

	// Event Listener on Button[#btnCustomerHome].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {

		Stage stage = (Stage) btnCustomerHome.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("CustomerReservation.fxml"));

		if (event.getSource() == btnCustomerHome) {
			stage = (Stage) btnCustomerHome.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		reservationTimeCBox.getItems().add("1 PM");

	}
}
