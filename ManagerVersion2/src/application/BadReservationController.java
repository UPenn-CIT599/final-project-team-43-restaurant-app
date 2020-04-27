package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class controls the Bad Reservation page (the windows that shows when an
 * invalid reservation is made).
 * 
 * @author yangliu
 *
 */
public class BadReservationController {
	@FXML
	private Button btnBack;

	/**
	 * This method is called when the "Back" button is clicked on the bad
	 * reservation page and brings the customer back to the customer reservation
	 * page
	 * 
	 * @param event The event of clicking the "Back" button
	 * @throws Exception
	 */
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnBack.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("BadReservation.fxml"));

		if (event.getSource() == btnBack) {
			stage = (Stage) btnBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerReservation.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
