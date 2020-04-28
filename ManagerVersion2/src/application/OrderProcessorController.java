package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
/**
 * Class for an order processor interface 
 * Note: this is presently unimplemented and button
 * methods shown here are currently called in other classes
 * 
 * @author porth
 *
 */
public class OrderProcessorController {
	@FXML
	private Button back, viewInventory, orderFill, refillProduct, managerLogin;
	
	// Event Listener on Button[back].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) back.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("OrderProcessor.fxml"));
		//back button returns to main page
		if (event.getSource() == back) {
			stage = (Stage) back.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}
		//view inventory button refreshes inventory window on Manager interface
		else if (event.getSource() == viewInventory) {
			stage = (Stage) viewInventory.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
		}
		//fill order button processes food order from CustomerOrder page
		else if (event.getSource() == orderFill) {
			stage = (Stage) orderFill.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderProcessor.fxml"));
			
			KitchenOrder currentOrder = new KitchenOrder();
			Inventory inventory = new Inventory();
			Menu menu = new Menu();
			inventory.populateInventory("Inventory.csv");
			menu.populateMenu("MenuList.csv", inventory);		
			currentOrder = currentOrder.fetchOrder("CustomerOrders.csv", menu);
			OrderProcessor processor = new OrderProcessor(currentOrder);
			processor.fillOrder(currentOrder);
			processor.writeInventory(processor.createInventoryUpdate(inventory));
		}
		//refillProduct button re-supplies depleted inventory
		else if (event.getSource() == refillProduct) {
			stage = (Stage) refillProduct.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderProcessor.fxml"));
			Inventory inventory = new Inventory();
			inventory.populateInventory("Inventory.csv");
			inventory.createProductOrder();
			//inventory.buyProduct(product, units);
		}
		//link to Manger landing page
		else if (event.getSource() == managerLogin) {
			stage = (Stage) managerLogin.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
}
