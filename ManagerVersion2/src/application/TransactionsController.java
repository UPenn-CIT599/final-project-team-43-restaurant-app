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
 * @author yinjiez
 *
 */
public class TransactionsController implements Initializable {
	@FXML
	private Button btn2;

	// set up TableView for Transaction interface
	@FXML
	private TableView<TransactionItem> list;
	@FXML
	private TableColumn<TransactionItem, String> customerID;
	@FXML
	private TableColumn<TransactionItem, String> date;
	@FXML
	private TableColumn<TransactionItem, String> time;
	@FXML
	private TableColumn<TransactionItem, Double> transactionAmount;
	@FXML
	private TableColumn<TransactionItem, String> paymentMethod;

	/**
	 * private TransactionItem record1, record2, record3, record4, record5, record6,
	 * record7, record8, record9, record10, record11, record12, record13, record14,
	 * record15, record16, record17, record18, record19, record20;
	 * 
	 * public ObservableList<TransactionRecord> obList =
	 * FXCollections.observableArrayList( record1 =
	 * TransactionItem.transactionGenerator(), record2 =
	 * TransactionItem.transactionGenerator(), record3 =
	 * TransactionItem.transactionGenerator(), record4 =
	 * TransactionItem.transactionGenerator(), record5 =
	 * TransactionItem.transactionGenerator(), record6 =
	 * TransactionItem.transactionGenerator(), record7 =
	 * TransactionItem.transactionGenerator(), record8 =
	 * TransactionItem.transactionGenerator(), record9 =
	 * TransactionItem.transactionGenerator(), record10 =
	 * TransactionItem.transactionGenerator(), record11 =
	 * TransactionItem.transactionGenerator(), record12 =
	 * TransactionItem.transactionGenerator(), record13 =
	 * TransactionItem.transactionGenerator(), record14 =
	 * TransactionItem.transactionGenerator(), record15 =
	 * TransactionItem.transactionGenerator(), record16 =
	 * TransactionItem.transactionGenerator(), record17 =
	 * TransactionItem.transactionGenerator(), record18 =
	 * TransactionItem.transactionGenerator(), record19 =
	 * TransactionItem.transactionGenerator(), record20 =
	 * TransactionItem.transactionGenerator() );
	 */

	ObservableList<TransactionItem> obList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TransactionRecord tr = new TransactionRecord("CustomerOrders.csv");
		obList = FXCollections.observableArrayList(tr.getRealTimeTransactionRecord());

		customerID.setCellValueFactory(new PropertyValueFactory<TransactionItem, String>("customerID"));
		date.setCellValueFactory(new PropertyValueFactory<TransactionItem, String>("date"));
		time.setCellValueFactory(new PropertyValueFactory<TransactionItem, String>("time"));
		transactionAmount.setCellValueFactory(new PropertyValueFactory<TransactionItem, Double>("transactionAmount"));
		paymentMethod.setCellValueFactory(new PropertyValueFactory<TransactionItem, String>("paymentMethod"));

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
