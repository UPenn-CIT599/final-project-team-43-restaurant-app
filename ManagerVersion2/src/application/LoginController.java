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
	private Button btn2, btnBackToCus;

	// Event Listener on Button[#btn2, #btnBackToCus].onAction and check UserEmail
	// and Password

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btn2.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		//here set up the user email account and password
		if (event.getSource() == btn2 && txtUserEmail.getText().equals("manager@taco.edu")
				&& txtPassword.getText().equals("05042020")) {

			stage = (Stage) btn2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		}

		if (event.getSource() == btnBackToCus) {

			stage = (Stage) btnBackToCus.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	// Event Handler for showing system time

	/**
	 * @FXML final Label clock = new Label();
	 * @FXML final DateFormat format = DateFormat.getInstance();
	 * @FXML final Timeline timeline = new Timeline(new
	 *       KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
	 * @Override public void handle(ActionEvent event) { final Calendar cal =
	 *           Calendar.getInstance();
	 *           clock.setText(format.format(cal.getTime())); } }));
	 *           timeline.setCycleCount(Animation.INDEFINITE); timeline.play();
	 */
}
