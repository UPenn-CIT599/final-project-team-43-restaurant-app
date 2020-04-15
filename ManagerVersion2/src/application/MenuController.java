package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
	
	@FXML
	private Button btnBack1, btnBack2, btnBack3, btnOrder1, btnOrder2, btnOrder3;


	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnBack1.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));

		if (event.getSource() == btnBack1) {
			stage = (Stage) btnBack1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		} else if (event.getSource() == btnBack2) {
			stage = (Stage) btnBack2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		} else if (event.getSource() == btnBack3) {
			stage = (Stage) btnBack2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		} else if (event.getSource() == btnOrder1) {
			stage = (Stage) btnOrder1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		} else if (event.getSource() == btnOrder2) {
			stage = (Stage) btnOrder2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		} else if (event.getSource() == btnOrder3) {
			stage = (Stage) btnOrder3.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	// Event Listener on changing labels which showing the tables are occupied or
	// not/paid or not
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
