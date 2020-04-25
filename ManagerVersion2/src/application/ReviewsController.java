package application;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

/**
 * This class controls the Reviews.fxml file for customer reviews
 * 
 * @author yangliu
 *
 */

public class ReviewsController {

	@FXML
	private TableView<CustomerReviews> tblReviews;

	@FXML
	private TableColumn<CustomerReviews, String> tblStars;

	@FXML
	private TableColumn<CustomerReviews, String> tblComments;

	@FXML
	private Button btnBack, btnWriteReview;

	@FXML
	private TextArea msgReview;

	@FXML
	private ChoiceBox<String> starsBox;

	ObservableList<String> starOptions = FXCollections.observableArrayList("1", "2", "3", "4", "5");

	ObservableList<CustomerReviews> reviewListObs;

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnBack.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Reviews.fxml"));

		if (event.getSource() == btnBack) {
			stage = (Stage) btnBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	public void writeReviewClicked(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnWriteReview.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Reviews.fxml"));

		if (event.getSource() == btnWriteReview && !starsBox.getSelectionModel().isEmpty() && !msgReview.getText().isEmpty()) {
			
			CustomerReviews newReview = new CustomerReviews();
			newReview.setScoreOutOfFive(Integer.parseInt(starsBox.getValue()));
			
			//ignores newlines for review entry
			newReview.setMessageReview(msgReview.getText().replaceAll("\n", " "));
			
			//writes the new review to the restaurantreviews.csv file
			newReview.addReview();

			
			stage = (Stage) btnWriteReview.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Reviews.fxml"));
		} else {
			stage = (Stage) btnWriteReview.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Reviews.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	

	@FXML
	public void initialize() throws IOException {

		reviewListObs = FXCollections.observableArrayList();

		FileReader fr = new FileReader("restaurantreviews.csv");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();

		// Adds all of the reviews in restaurantreviews.csv file to the reviewListObs so
		// that they can be placed/viewed in a table format
		while (CSVReader.readNumberOfLines("restaurantreviews.csv") - 1 > reviewListObs.size()) {
			CustomerReviews currentReview = new CustomerReviews();
			reviewListObs.add(currentReview);
			String line = br.readLine();
			if (line != null) {
				String[] lineReview = line.split(",", 2);
				currentReview.setScoreOutOfFive(Integer.parseInt(lineReview[0]));
				currentReview.setMessageReview(lineReview[1]);
			}
		}
		br.close();

		// sets all star columns to the scoreOutOfFive instance variable of
		// CustomerReviews.
		tblStars.setCellValueFactory(new PropertyValueFactory<CustomerReviews, String>("scoreOutOfFive"));

		// sets all comment columns to the messageReview instance variable of
		// CustomerReviews.
		tblComments.setCellValueFactory(new PropertyValueFactory<CustomerReviews, String>("messageReview"));

		// sets observable data into the table
		tblReviews.setItems(reviewListObs);

		//sets star options (1-5) for the starsBox Choice Box
		starsBox.setItems(starOptions);

	}

}
