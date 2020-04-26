package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * This class is in charge of running GUI for Manager Version
 * 
 * @author yinjiezhang
 *
 */
public class Main extends Application {

	/**
	 * The start method is used to start the GUI
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// creates a new customer every time application is launched
		Customer.getCustomer().setAvailableFunds(Customer.getCustomer().getAvailableFunds());
		
		//create a new bank account
		//BankAccount.getBankAccount().setBalance(1000);

		// gives the customer a unique ID
		double ID = Math.random() * 9999999;
		Customer.getCustomer().setCustomerID(Integer.toString((int) ID));

		// launches GUI
		launch(args);

	}

}
