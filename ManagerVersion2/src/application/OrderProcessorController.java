package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OrderProcessorController {
	@FXML
	private Button back, viewInventory, fillOrder, refillProduct, managerLogin;
	
	// Event Listener on Button[#btn2].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) back.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("OrderProcessor.fxml"));

		if (event.getSource() == back) {
			stage = (Stage) back.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}
		else if (event.getSource() == viewInventory) {
			stage = (Stage) viewInventory.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
		}
		else if (event.getSource() == fillOrder) {
			stage = (Stage) fillOrder.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderProcessor.fxml"));
			
			KitchenOrder currentOrder = new KitchenOrder();
			Inventory inventory = new Inventory();
			Menu menu = new Menu();
			inventory.populateInventory("Inventory.csv");
			menu.populateMenu("MenuList.csv", inventory);		
			currentOrder = currentOrder.fetchOrder("CustomerOrders.csv", menu);
			OrderProcessor processor = new OrderProcessor(currentOrder);
			processor.fillOrder();
			processor.writeInventory(processor.createInventoryUpdate(inventory));
		}
		else if (event.getSource() == refillProduct) {
			stage = (Stage) refillProduct.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderProcessor.fxml"));
			Inventory inventory = new Inventory();
			inventory.populateInventory("Inventory.csv");
			inventory.createProductOrder();
			//inventory.buyProduct(product, units);
		}
		else if (event.getSource() == managerLogin) {
			stage = (Stage) managerLogin.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
}
