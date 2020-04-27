package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

/**
 * This class controls the Main FXML File
 * 
 * @author yangliu, yinjiez
 *
 */
public class MainController implements Initializable {
	@FXML
	private Button btnTable, btnTransaction, btnEmployees, btnInventory, btn1;
	
	@FXML
	private TextField bankAmount;

	// Event Listener on Button[#btnTable, btnTransaction, btnEmployees, btnInventory, btn1].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btn1.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

		if (event.getSource() == btn1) {
			stage = (Stage) btn1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		} else if (event.getSource() == btnTable) {
			stage = (Stage) btnTable.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Tables.fxml"));
		} else if (event.getSource() == btnTransaction) {
			stage = (Stage) btnTransaction.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Transactions.fxml"));
		} else if (event.getSource() == btnEmployees) {
			stage = (Stage) btnEmployees.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
		} else {
			stage = (Stage) btnInventory.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	public void display() {
		bankAmount = new TextField(); // textfields need to be initialized in display method
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		bankAmount.setText(BankAccount.getBankAccount().getBalance());
		
	}

}
