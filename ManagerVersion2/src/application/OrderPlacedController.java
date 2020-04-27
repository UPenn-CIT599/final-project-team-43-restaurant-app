package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class controls the Order Placed page. This is the page that displays
 * after a successful order.
 * 
 * @author yangliu
 *
 */
public class OrderPlacedController {
	@FXML
	private Button btnBack;

	/**
	 * This method is called when the customer clicks "Back" and brings the customer
	 * back to the cusotmer home page
	 * 
	 * @param event The event of clicking on the "Back" button
	 * @throws Exception
	 */
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnBack.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("OrderPlaced.fxml"));

		if (event.getSource() == btnBack) {
			stage = (Stage) btnBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
