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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This class controls the CustomerHomePage FXML File
 * 
 * @author yinjiezhang; yangliu
 *
 */
public class CustomerHomePageController implements Initializable {
	
	
	@FXML
	private Button  btnL1, btnCReservation, btnViewMenu, btnOrder, btnReviews;

	@FXML
	private TextField customerIDBox;
	
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
		} else if(event.getSource() == btnReviews) {
			stage = (Stage) btnReviews.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Reviews.fxml"));
		} 
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void display() {
		customerIDBox = new TextField(); // textfields need to be initialized in display method
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		customerIDBox.setText(Customer.getCustomer().getCustomerID());
	}
	
}
