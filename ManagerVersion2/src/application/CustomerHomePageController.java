package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class controls the CustomerHomePage FXML File
 * 
 * @author yinjiezhang; yangliu
 *
 */
public class CustomerHomePageController implements Initializable {
	
	
	@FXML
	private Button  btnL1, btnCReservation, btnViewMenu, btnOrder;;

	
	/**
	 * This method defines all the button actions
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void handleButtonAction (ActionEvent event) throws Exception {
		
		Stage stage = (Stage) btnL1.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		
		if (event.getSource() == btnL1) {
			stage = (Stage) btnL1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		} else if(event.getSource() == btnCReservation) {
			stage = (Stage) btnCReservation.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerReservation.fxml"));
		} else if(event.getSource() == btnViewMenu) {
			stage = (Stage) btnViewMenu.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		} else if(event.getSource() == btnOrder) {
			stage = (Stage) btnOrder.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		}
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
}
