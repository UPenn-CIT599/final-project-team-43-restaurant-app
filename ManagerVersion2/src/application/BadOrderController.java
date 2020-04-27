package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

/**
 * This class controls the Bad Order page (the window that shows when an invalid
 * order is made).
 * 
 * @author yangliu
 *
 */
public class BadOrderController {
	@FXML
	private Button btnBack;

	/**
	 * This method is called when the "Back" button is clicked on the bad order page
	 * and brings the customer back to the order page
	 * 
	 * @param event The event of clicking the "Back" button
	 * @throws Exception
	 */
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnBack.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("BadOrder.fxml"));

		if (event.getSource() == btnBack) {
			stage = (Stage) btnBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
