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
 * This class controls the Employee FXML file
 * 
 * @author yangliu, yinjiez
 *
 */
public class EmployeesController implements Initializable {
	
	@FXML
	private Button btn2;
	@FXML
	private Button btnAddEmployee;
	
	
	//set up TableView for Employee interface
	@FXML
	private TableView<EmployeeControl> list;
	@FXML
	private TableColumn<EmployeeControl, String> name;
	@FXML
	private TableColumn<EmployeeControl, Integer> attendanceHours;
	@FXML
	private TableColumn<EmployeeControl, Integer> salary;
	@FXML
	private TableColumn<EmployeeControl, Boolean> onDuty;

	/**
	private EmployeeControl employee1, employee2, employee3, employee4, employee5;
	
	public ObservableList<EmployeeControl> obList = FXCollections.observableArrayList(
			employee1 = EmployeeControl.employeeGenerator(), 
			employee2 = EmployeeControl.employeeGenerator(),
			employee3 = EmployeeControl.employeeGenerator(),
			employee4 = EmployeeControl.employeeGenerator(),
			employee5 = EmployeeControl.employeeGenerator()
			);*/
	
    public static EmployeeList el = new EmployeeList("Employee List.csv");
	
	public static ObservableList<EmployeeControl> obList = FXCollections.observableArrayList(el.getEmployeeList());

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		name.setCellValueFactory(new PropertyValueFactory<EmployeeControl, String>("name"));
		attendanceHours.setCellValueFactory(new PropertyValueFactory<EmployeeControl, Integer>("attendanceHours"));
		salary.setCellValueFactory(new PropertyValueFactory<EmployeeControl, Integer>("salary"));
		onDuty.setCellValueFactory(new PropertyValueFactory<EmployeeControl, Boolean>("onDuty"));
		
		
		list.setItems(obList);
		
		
	}

	
	// Event Listener on Button[#btn2].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btn2.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));

		if (event.getSource() == btn2) {
			stage = (Stage) btn2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	// Event Listener on Button[#btnAddEmployee].onAction
	@FXML
	public void addEmployeeAction(ActionEvent event) throws Exception {
		
		
		if (event.getSource() == btnAddEmployee) {
			EmployeeList.addEmployee();
			
		}

		Stage stage = (Stage) btnAddEmployee.getScene().getWindow(); 
		
		Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	
}
