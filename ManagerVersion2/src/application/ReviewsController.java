package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class ReviewsController {

	@FXML
	private TableView<CustomerReviews> tblReviews;

	@FXML
	private TableColumn<CustomerReviews, String> tblStars;

	@FXML
	private TableColumn<CustomerReviews, String> tblComments;

	@FXML
	private Button btnBack;

	@FXML
	private Button btnWriteReview;

	@FXML
	private TextArea msgReview;

	@FXML
	private ChoiceBox<String> starsBox;

	ObservableList<String> starOptions = FXCollections.observableArrayList("1", "2", "3", "4", "5");

	ObservableList<CustomerReviews> reviewListObs;

	CustomerReviews review1, review2, review3, review4, review5, review6;

	ArrayList<String[]> reviewList;

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
	public void initialize() {

		reviewListObs = FXCollections.observableArrayList(review1 = new CustomerReviews(),
				review2 = new CustomerReviews(), review3 = new CustomerReviews(), review4 = new CustomerReviews(),
				review5 = new CustomerReviews(), review6 = new CustomerReviews());

		reviewList = new ArrayList<String[]>();

		//add first random review to reviewList
		reviewList.add(CustomerReviews.obtainARandomReview());
		
		//adds five more random reviews to reviewList
		while (reviewList.size() <= 6) {
			for (int i = 0; i < reviewList.size(); i++) {
				String[] review = CustomerReviews.obtainARandomReview();
				String msgValue = review[1];
				if (!reviewList.get(i)[1].equals(msgValue)) {
					reviewList.add(review);
				}
			}
			
		}

		// adds random reviews from array list to each review object
		review1.setScoreOutOfFive(Integer.parseInt(reviewList.get(0)[0]));
		review1.setMessageReview(reviewList.get(0)[1]);
		review2.setScoreOutOfFive(Integer.parseInt(reviewList.get(1)[0]));
		review2.setMessageReview(reviewList.get(1)[1]);
		review3.setScoreOutOfFive(Integer.parseInt(reviewList.get(2)[0]));
		review3.setMessageReview(reviewList.get(2)[1]);
		review4.setScoreOutOfFive(Integer.parseInt(reviewList.get(3)[0]));
		review4.setMessageReview(reviewList.get(3)[1]);
		review5.setScoreOutOfFive(Integer.parseInt(reviewList.get(4)[0]));
		review5.setMessageReview(reviewList.get(4)[1]);
		review6.setScoreOutOfFive(Integer.parseInt(reviewList.get(5)[0]));
		review6.setMessageReview(reviewList.get(5)[1]);

		// sets all star columns to the scoreOutOfFive instance variable of
		// CustomerReviews.
		tblStars.setCellValueFactory(new PropertyValueFactory<CustomerReviews, String>("scoreOutOfFive"));

		// sets all comment columns to the messageReview instance variable of
		// CustomerReviews.
		tblComments.setCellValueFactory(new PropertyValueFactory<CustomerReviews, String>("messageReview"));

		// sets observable data into the table
		tblReviews.setItems(reviewListObs);

	}

}
