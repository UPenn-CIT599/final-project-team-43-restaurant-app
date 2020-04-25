package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 
 * @author yangliu
 *
 */

public class MenuController {

	@FXML
	private Button btnBack1, btnBack2, btnBack3, btnOrder1, btnOrder2, btnOrder3;

	@FXML
	private TextField beefTacoPriceBox, chickenTacoPriceBox, veggieTacoPriceBox, drPepperPriceBox, laCroixPriceBox,
			pepsiPriceBox, pacificoPriceBox, nachosPriceBox, tortillaPriceBox, riceAndBeansPriceBox, beefTacoCalorieBox,
			chickenTacoCalorieBox, veggieTacoCalorieBox, drPepperCalorieBox, laCroixCalorieBox, pepsiCalorieBox,
			pacificoCalorieBox, nachosCalorieBox, tortillaCalorieBox, riceAndBeansCalorieBox;

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnBack1.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));

		if (event.getSource() == btnBack1) {
			stage = (Stage) btnBack1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		} else if (event.getSource() == btnBack2) {
			stage = (Stage) btnBack2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		} else if (event.getSource() == btnBack3) {
			stage = (Stage) btnBack2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		} else if (event.getSource() == btnOrder1) {
			stage = (Stage) btnOrder1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		} else if (event.getSource() == btnOrder2) {
			stage = (Stage) btnOrder2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		} else if (event.getSource() == btnOrder3) {
			stage = (Stage) btnOrder3.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("OrderPage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	public void display() {
		beefTacoPriceBox = new TextField();
		chickenTacoPriceBox = new TextField();
		veggieTacoPriceBox = new TextField();
		drPepperPriceBox = new TextField();
		laCroixPriceBox = new TextField();
		pepsiPriceBox = new TextField();
		pacificoPriceBox = new TextField();
		nachosPriceBox = new TextField();
		tortillaPriceBox = new TextField();
		riceAndBeansPriceBox = new TextField();
		beefTacoCalorieBox = new TextField();
		chickenTacoCalorieBox = new TextField();
		veggieTacoCalorieBox = new TextField();
		drPepperCalorieBox = new TextField();
		laCroixCalorieBox = new TextField();
		pepsiCalorieBox = new TextField();
		pacificoCalorieBox = new TextField();
		nachosCalorieBox = new TextField();
		tortillaCalorieBox = new TextField();
		riceAndBeansCalorieBox = new TextField();
	}

	@FXML
	public void initialize() {

		Inventory inv = new Inventory();
		inv.populateInventory("Inventory.csv");

		Menu menu = new Menu();
		menu.populateMenu("MenuList.csv", inv);

		// Displays price of each food item in the menu GUI screen
		beefTacoPriceBox.setText("$" + Double.toString(menu.tacos.get(0).getPrice()));
		chickenTacoPriceBox.setText("$" + Double.toString(menu.tacos.get(1).getPrice()));
		veggieTacoPriceBox.setText("$" + Double.toString(menu.tacos.get(2).getPrice()));

		drPepperPriceBox.setText("$" + Double.toString(menu.drinks.get(0).getPrice()));
		laCroixPriceBox.setText("$" + Double.toString(menu.drinks.get(1).getPrice()));
		pepsiPriceBox.setText("$" + Double.toString(menu.drinks.get(2).getPrice()));
		pacificoPriceBox.setText("$" + Double.toString(menu.drinks.get(3).getPrice()));

		nachosPriceBox.setText("$" + Double.toString(menu.sides.get(0).getPrice()));
		tortillaPriceBox.setText("$" + Double.toString(menu.sides.get(1).getPrice()));
		riceAndBeansPriceBox.setText("$" + Double.toString(menu.sides.get(2).getPrice()));
		
		beefTacoCalorieBox.setText(Integer.toString(menu.tacos.get(0).getCalories()) + " calories");
		chickenTacoCalorieBox.setText(Integer.toString(menu.tacos.get(1).getCalories()) + " calories");
		veggieTacoCalorieBox.setText(Integer.toString(menu.tacos.get(2).getCalories()) + " calories");
		
		drPepperCalorieBox.setText(Integer.toString(menu.drinks.get(0).getCalories()) + " calories");
		laCroixCalorieBox.setText(Integer.toString(menu.drinks.get(1).getCalories()) + " calories");
		pepsiCalorieBox.setText(Integer.toString(menu.drinks.get(2).getCalories()) + " calories");
		pacificoCalorieBox.setText(Integer.toString(menu.drinks.get(3).getCalories()) + " calories"); 
		
		nachosCalorieBox.setText(Integer.toString(menu.sides.get(0).getCalories()) + " calories"); 
		tortillaCalorieBox.setText(Integer.toString(menu.sides.get(1).getCalories()) + " calories");
		riceAndBeansCalorieBox.setText(Integer.toString(menu.sides.get(2).getCalories()) + " calories");

	}
}
