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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * This class is in charge of connecting different interfaces and other class methods
 * @author yinjiezhang
 *
 */
public class Controller implements Initializable {
	
	@FXML
	private Label lbl1, lbl2;
	
	@FXML
	private Button btn1, btn2, btnTable, btnTransaction, btnEmployees, btnInventory, btnL1;
	
	/**
	 * This method defines all the button actions
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void handleButtonAction (ActionEvent event) throws Exception {
		Stage stage;
		Parent root;
		
		if (event.getSource() == btnL1) {
			stage = (Stage) btnL1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		}
		else if(event.getSource() == btn1) {
			stage = (Stage) btn1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		} else if(event.getSource() == btn2){
			stage = (Stage) btn2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		} else if(event.getSource() == btnTable){
			stage = (Stage) btnTable.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Tables.fxml"));
		} else if(event.getSource() == btnTransaction){
			stage = (Stage) btnTransaction.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Transactions.fxml"));
		} else if(event.getSource() == btnEmployees){
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
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
}
