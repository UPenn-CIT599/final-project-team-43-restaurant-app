package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This class controls the reservation confirmation page. This page is displayed
 * when a successful reservation is placed
 * 
 * @author yangliu
 *
 */
public class ReservationConfirmationController {

	@FXML
	private Button btnMainPage;

	@FXML
	private TextField confirmedReservationDate, confirmedReservationTime, confirmedReservationID;

	/**
	 * This method is called when the Customer clicks on the "Back" button and
	 * brings the customer back to the customer home page
	 * 
	 * @param event The event of clicking on the "Back" button
	 * @throws Exception
	 */
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

	/**
	 * Initialization of textfields for display are put into the display method
	 */
	@FXML
	public void display() {
		confirmedReservationDate = new TextField();
		confirmedReservationTime = new TextField();
		confirmedReservationID = new TextField();

	}

	
	/**
	 * This method is called whenever the ReservationConfirmation.FXML file is loaded successfully
	 */
	@FXML
	public void initialize() {
		
		//sets the textfields to display the confirmed reservation date, time and ID
		confirmedReservationDate.setText(Customer.getCustomer().getReservationDate());
		confirmedReservationTime.setText(Customer.getCustomer().getReservationTime());
		confirmedReservationID.setText(Customer.getCustomer().getReservationID());

	}

}
