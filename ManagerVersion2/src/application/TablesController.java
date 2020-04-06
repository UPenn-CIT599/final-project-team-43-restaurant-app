package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import javafx.event.ActionEvent;


/**
 * This class controls the Tables FXML file
 * 
 * @author yangliu
 *
 */
public class TablesController {
	@FXML
	private Button btn2;

	// Event Listener on Button[#btn2].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btn2.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Tables.fxml"));

		if (event.getSource() == btn2) {
			stage = (Stage) btn2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
}
