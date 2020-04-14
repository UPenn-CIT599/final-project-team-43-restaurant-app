package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;


/**
 * This class controls the Tables FXML file
 * 
 * @author yangliu, yinjiez
 *
 */
public class TablesController implements Initializable {
	@FXML
	private Button btn2;
	
	@FXML
	private Label lbl1o, lbl2o, lbl3o, lbl4o, lbl5o, lbl6o, lbl7o, lbl8o, 
	              lbl9o, lbl10o, lbl11o, lbl12o, lbl13o, lbl14o, lbl15o, lbl16o,
	              lbl1p, lbl2p, lbl3p, lbl4p, lbl5p, lbl6p, lbl7p, lbl8p, 
	              lbl9p, lbl10p, lbl11p, lbl12p, lbl13p, lbl14p, lbl15p, lbl16p;

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
	
	//Event Listener on changing labels which showing the tables are occupied or not/paid or not
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbl1o.setText("Occupied");
	}
}
