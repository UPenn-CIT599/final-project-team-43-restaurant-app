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
	private Label lbl1o;
	@FXML
	private Label lbl2o;
	@FXML
	private Label lbl3o;
	@FXML
	private Label lbl4o;
	@FXML
	private Label lbl5o;
	@FXML
	private Label lbl6o;
	@FXML
	private Label lbl7o;
	@FXML
	private Label lbl8o;
	@FXML
	private Label lbl9o;
	@FXML
	private Label lbl10o;
	@FXML
	private Label lbl11o;
	@FXML
	private Label lbl12o;
	@FXML
	private Label lbl13o;
	@FXML
	private Label lbl14o;
	@FXML
	private Label lbl15o;
	@FXML
	private Label lbl16o;
	@FXML
	private Label lbl1p;
	@FXML
	private Label lbl2p;
	@FXML
	private Label lbl3p;
	@FXML
	private Label lbl4p;
	@FXML
	private Label lbl5p;
	@FXML
	private Label lbl6p;
	@FXML
	private Label lbl7p;
	@FXML
	private Label lbl8p;
	@FXML
	private Label lbl9p;
	@FXML
	private Label lbl10p;
	@FXML
	private Label lbl11p;
	@FXML
	private Label lbl12p;
	@FXML
	private Label lbl13p;
	@FXML
	private Label lbl14p;
	@FXML
	private Label lbl15p;
	@FXML
	private Label lbl16p;
	

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
		if(TableList.tableList[0].isOccupied() && TableList.tableList[0].isPaid()) {
			lbl1o.textProperty().setValue("Occupied");
			lbl1p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[1].isOccupied() && TableList.tableList[1].isPaid()) {
			lbl2o.textProperty().setValue("Occupied");
			lbl2p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[2].isOccupied() && TableList.tableList[2].isPaid()) {
			lbl3o.textProperty().setValue("Occupied");
			lbl3p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[3].isOccupied() && TableList.tableList[3].isPaid()) {
			lbl4o.textProperty().setValue("Occupied");
			lbl4p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[4].isOccupied() && TableList.tableList[4].isPaid()) {
			lbl5o.textProperty().setValue("Occupied");
			lbl5p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[5].isOccupied() && TableList.tableList[5].isPaid()) {
			lbl6o.textProperty().setValue("Occupied");
			lbl6p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[6].isOccupied() && TableList.tableList[6].isPaid()) {
			lbl7o.textProperty().setValue("Occupied");
			lbl7p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[7].isOccupied() && TableList.tableList[7].isPaid()) {
			lbl8o.textProperty().setValue("Occupied");
			lbl8p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[8].isOccupied() && TableList.tableList[8].isPaid()) {
			lbl9o.textProperty().setValue("Occupied");
			lbl9p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[9].isOccupied() && TableList.tableList[9].isPaid()) {
			lbl10o.textProperty().setValue("Occupied");
			lbl10p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[10].isOccupied() && TableList.tableList[10].isPaid()) {
			lbl11o.textProperty().setValue("Occupied");
			lbl11p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[11].isOccupied() && TableList.tableList[11].isPaid()) {
			lbl12o.textProperty().setValue("Occupied");
			lbl12p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[12].isOccupied() && TableList.tableList[12].isPaid()) {
			lbl13o.textProperty().setValue("Occupied");
			lbl13p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[13].isOccupied() && TableList.tableList[13].isPaid()) {
			lbl14o.textProperty().setValue("Occupied");
			lbl14p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[14].isOccupied() && TableList.tableList[14].isPaid()) {
			lbl15o.textProperty().setValue("Occupied");
			lbl15p.textProperty().setValue("Paid");
		}
		if(TableList.tableList[15].isOccupied() && TableList.tableList[15].isPaid()) {
			lbl16o.textProperty().setValue("Occupied");
			lbl16p.textProperty().setValue("Paid");
		}
			
			
	}
		
}
