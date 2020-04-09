package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import javafx.event.ActionEvent;

/**
 * This class controls the Login FXML file
 * 
 * @author yinjiez
 *
 */
public class LoginController {
	
	@FXML
	private TextField txtUserEmail;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private Button btn2;
	

	// Event Listener on Button[#btn2].onAction and check UserEmail and Password
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btn2.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

		if (event.getSource() == btn2 && txtUserEmail.getText().equals("manager@taco.edu") 
				&& txtPassword.getText().equals("05042020")) {
			
			stage = (Stage) btn2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		} 
		

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
}
