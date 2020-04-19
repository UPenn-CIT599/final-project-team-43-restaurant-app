package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.MethodOrderer.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * This class controls the CustomerReservation FXML file
 * 
 * @author yangliu
 *
 */
public class CustomerReservationController {

	@FXML
	private Button btnCustomerHome, btnReservation;

	@FXML
	private ChoiceBox reservationTimeCBox;

	@FXML
	private DatePicker reservationDateBox;

	ObservableList<String> availableTimes = FXCollections.observableArrayList("09:00", "10:00", "11:00", "12:00",
			"13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00");

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {

		Stage stage = (Stage) btnCustomerHome.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("CustomerReservation.fxml"));

		if (event.getSource() == btnCustomerHome) {
			stage = (Stage) btnCustomerHome.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	public void makeReservation(ActionEvent event) throws Exception {

		Stage stage = (Stage) btnReservation.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("CustomerReservation.fxml"));

		// sets up format for date and time
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");

		// variable now stores the time of order
		LocalDateTime now = LocalDateTime.now();
		ChronoLocalDate dNow = now.toLocalDate();
		LocalTime tNow = now.toLocalTime();

		if (!reservationTimeCBox.getSelectionModel().isEmpty() && reservationDateBox.getValue() != null) {
			stage = (Stage) btnReservation.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("BadReservation.fxml"));

		}

		if (event.getSource() == btnReservation && (reservationTimeCBox.getSelectionModel().isEmpty())) {
			stage = (Stage) btnReservation.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("BadReservation.fxml"));

		}
		// Nested if-block. First if-block runs when customer makes reservation that is
		// for today's date or a future date
		else if (event.getSource() == btnReservation
				&& (reservationDateBox.getValue().isEqual(dNow) || reservationDateBox.getValue().isAfter(dNow))) {
			String selectedTime = reservationTimeCBox.getValue().toString();
			String selectedDate = reservationDateBox.getValue().toString();

			int selTime = Integer.parseInt(selectedTime.replaceAll(":", ""));
			int timeNow = Integer.parseInt(time.format(tNow).replaceAll(":", ""));

			// second if-block check if selected reservation time is in the future
			if ((reservationDateBox.getValue().isEqual(dNow) && selTime > timeNow)
					|| reservationDateBox.getValue().isAfter(dNow)) {

				double resID = Math.round(Math.random() * 999999);
				String strResID = Double.toString(resID).replace(".", "");

				// Reservation is a success and will update Customer class instance variables
				Customer.getCustomer().setReservationID(strResID);
				Customer.getCustomer().setReservationTime(selectedTime);
				Customer.getCustomer().setReservationDate(selectedDate);

				String customerID = Customer.getCustomer().getCustomerID();
				String reservationID = Customer.getCustomer().getReservationID();
				String resDate = Customer.getCustomer().getReservationDate();
				String resTime = Customer.getCustomer().getReservationTime();

				Customer.writeReservation(customerID, reservationID, resDate, resTime);

				stage = (Stage) btnReservation.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("ReservationConfirmation.fxml"));
			}
		}

		else {
			stage = (Stage) btnReservation.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("BadReservation.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	public void initialize() {
		reservationTimeCBox.setItems(availableTimes);
		reservationDateBox.setValue(LocalDate.now());
	}

}
