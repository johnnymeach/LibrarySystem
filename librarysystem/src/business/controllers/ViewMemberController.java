package business.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import business.models.LibraryMember;
import dataaccess.LibraryMemberImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewMemberController implements Initializable {

	@FXML
	private Label lblClose;
	Stage stage;
	
	@FXML
	private TableView<LibraryMember> libraryMemberTable;
	@FXML
	private TableColumn<LibraryMember, String> colMemberId;
	@FXML
	private TableColumn<LibraryMember, String> colFirstname;
	@FXML
	private TableColumn<LibraryMember, String> colLastname;
	@FXML
	private TableColumn<LibraryMember, String> colPhone;
	@FXML
	private TableColumn<LibraryMember, String> colStreet;
	@FXML
	private TableColumn<LibraryMember, String> colCity;
	@FXML
	private TableColumn<LibraryMember, String> colState;
	@FXML
	private TableColumn<LibraryMember, String> colZip;

	public void backToDashboard() {
		LoginController.helper.backToHome(stage, lblClose, "../views/home/Dashboard.fxml");
	}

	public void loadAddNewMemberView() {
		String memberView = "../views/librarian/AddNewMember.fxml";
		String viewTitle = "Add New Member";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(() -> {
			getAllLibraryMember();
			lblClose.setOnMouseClicked((MouseEvent event) -> {
				Platform.exit();
				System.exit(0);
			});
		});
		
	}
	
	public void getAllLibraryMember(){
		LibraryMemberImpl libraryMember = new LibraryMemberImpl();
		List<LibraryMember> memberList = libraryMember.getAllItems();
		
		colMemberId.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("memberId"));
		colFirstname.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("firstname"));
		colLastname.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("lastname"));
		colPhone.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("phone"));
		colStreet.setCellValueFactory(cellData -> cellData.getValue().getAddress().getStreetProperty());
		colCity.setCellValueFactory(cellData -> cellData.getValue().getAddress().getCityProperty());
		colState.setCellValueFactory(cellData -> cellData.getValue().getAddress().getStateProperty());
		colZip.setCellValueFactory(cellData -> cellData.getValue().getAddress().getZipProperty());
		libraryMemberTable.setItems(FXCollections.observableArrayList(memberList));
	}
}
