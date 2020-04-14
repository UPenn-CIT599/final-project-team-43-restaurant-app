package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * This class controls the Transactions FXML file
 * 
 * @author yangliu,yinjiez
 *
 */
public class TransactionsController implements Initializable {
	@FXML
	private Button btn2;
	
	//set up TableView for Transaction interface
	@FXML
	private TableView<TransactionRecord> list;
	@FXML
	private TableColumn<TransactionRecord, Integer> date;
	@FXML
	private TableColumn<TransactionRecord, Integer> time;
	@FXML
	private TableColumn<TransactionRecord, Double> transactionAmount;
	@FXML
	private TableColumn<TransactionRecord, String> paymentMethod;

	private TransactionRecord record1, record2, record3, record4, record5;
		
	public ObservableList<TransactionRecord> obList = FXCollections.observableArrayList(
			record1 = TransactionRecord.transactionGenerator(), 
			record2 = TransactionRecord.transactionGenerator(), 
			record3 = TransactionRecord.transactionGenerator(), 
			record4 = TransactionRecord.transactionGenerator(), 
			record5 = TransactionRecord.transactionGenerator()
			);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		date.setCellValueFactory(new PropertyValueFactory<TransactionRecord, Integer>("date"));
		time.setCellValueFactory(new PropertyValueFactory<TransactionRecord, Integer>("time"));
		transactionAmount.setCellValueFactory(new PropertyValueFactory<TransactionRecord, Double>("transactionAmount"));
		paymentMethod.setCellValueFactory(new PropertyValueFactory<TransactionRecord, String>("paymentMethod"));
			
		list.setItems(obList);
			
	}


	// Event Listener on Button[#btn2].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btn2.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Transactions.fxml"));

		if (event.getSource() == btn2) {
			stage = (Stage) btn2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
}
