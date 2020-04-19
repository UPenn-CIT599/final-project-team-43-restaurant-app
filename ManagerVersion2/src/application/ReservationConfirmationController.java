package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReservationConfirmationController {
	
	@FXML
	private Button btnMainPage;
	
	@FXML
	private TextField confirmedReservationDate, confirmedReservationTime, confirmedReservationID;
	
	

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnMainPage.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("CustomerReservation.fxml"));

		if (event.getSource() == btnMainPage) {
			stage = (Stage) btnMainPage.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}


		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	public void display() {
		confirmedReservationDate = new TextField(); 
		confirmedReservationTime = new TextField();
		confirmedReservationID = new TextField();
		
	}

	@FXML
	public void initialize() {
		
		confirmedReservationDate.setText(Customer.getCustomer().getReservationDate());
		confirmedReservationTime.setText(Customer.getCustomer().getReservationTime());
		confirmedReservationID.setText(Customer.getCustomer().getReservationID());
		
	}
	
	
}
