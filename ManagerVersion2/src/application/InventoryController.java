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
 * This class controls the Inventory FXML file
 * 
 * @author yinjiez
 *
 */
public class InventoryController implements Initializable {
	@FXML
	private Button btn2;
	
	//set up TableView for Inventory interface
	@FXML
	private TableView<InventoryItem> list;
	@FXML
	private TableColumn<InventoryItem, String> itemID;
	@FXML
	private TableColumn<InventoryItem, String> itemName;
	@FXML
	private TableColumn<InventoryItem, Double> calorie;
	@FXML
	private TableColumn<InventoryItem, Double> unitPrice;
	@FXML
	private TableColumn<InventoryItem, String> units;
	@FXML
	private TableColumn<InventoryItem, Double> packSize;
	@FXML
	private TableColumn<InventoryItem, Double> packPrice;
	@FXML
	private TableColumn<InventoryItem, Double> onHand;
	@FXML
	private TableColumn<InventoryItem, Double> reorderPoint;
	@FXML
	private TableColumn<InventoryItem, String> vendorName;
	
	
	public static final InventoryReader in = new InventoryReader("Inventory.csv");
	
	
	public static ObservableList<InventoryItem> obList = FXCollections.observableArrayList(
			in.getInventoryList()
		    );

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		itemID.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("itemID"));
		itemName.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("itemName"));
		calorie.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("calorie"));
		unitPrice.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("unitPrice"));
		units.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("units"));
		packSize.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("packSize"));
		packPrice.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("packPrice"));
		onHand.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("onHand"));
		reorderPoint.setCellValueFactory(new PropertyValueFactory<InventoryItem, Double>("reorderPoint"));
		vendorName.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("vendorName"));
		
		
		
		list.setItems(obList);
		
		
	}
	

	// Event Listener on Button[#btn2].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btn2.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));

		if (event.getSource() == btn2) {
			stage = (Stage) btn2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
}
