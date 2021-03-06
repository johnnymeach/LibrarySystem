package business.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import business.models.LibraryMember;
import business.models.getControllerWithParam;
import dataaccess.LibraryMemberImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewMemberController implements Initializable {


	LibraryMemberImpl libraryMember = new LibraryMemberImpl();
	List<LibraryMember> memberList = libraryMember.getAllItems();
	
	@FXML
	private Label lblClose;
	Stage stage;

	@FXML
	private TextField txtSearchMemberId;

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

	public void getAllLibraryMember() {
		colMemberId.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("memberId"));
		colFirstname.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("firstName"));
		colLastname.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("lastName"));
		colPhone.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("phone"));
		colStreet.setCellValueFactory(cellData -> cellData.getValue().getAddress().getStreetProperty());
		colCity.setCellValueFactory(cellData -> cellData.getValue().getAddress().getCityProperty());
		colState.setCellValueFactory(cellData -> cellData.getValue().getAddress().getStateProperty());
		colZip.setCellValueFactory(cellData -> cellData.getValue().getAddress().getZipProperty());
		libraryMemberTable.setItems(FXCollections.observableArrayList(memberList));
	}

	public void openEditMemberView() {
		LibraryMember selectedMember = libraryMemberTable.getSelectionModel().getSelectedItem();
		String memberView = "../views/librarian/EditMember.fxml";
		String viewTitle = "Edit Member";
		LoginController.helper.loadNewStageWithParam(new getControllerWithParam() {

			@Override
			public void getObjectController(Object controller) {
				// TODO Auto-generated method stub
				EditMemberController ctrl = (EditMemberController) controller;
				ctrl.setSelectedMember(selectedMember);
			}
		}, stage, lblClose, memberView, viewTitle, false, selectedMember);
	}

	public void searchMember() {
		LibraryMember searchMember = null;
		String requestId = txtSearchMemberId.getText();
		if (requestId.isEmpty()) {
			LoginController.helper.showSuccessDialog("Please input memberID", "Empty Field");
			libraryMemberTable.setItems(FXCollections.observableArrayList(memberList));
		} else {
			searchMember = libraryMember.searchLibraryMember(requestId);
			if (searchMember == null) {
				LoginController.helper.showSuccessDialog("Search not found", "Not found");
				libraryMemberTable.setItems(null);
			} else {
				colMemberId.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("memberId"));
				colFirstname.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("firstName"));
				colLastname.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("lastName"));
				colPhone.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("phone"));
				colStreet.setCellValueFactory(cellData -> cellData.getValue().getAddress().getStreetProperty());
				colCity.setCellValueFactory(cellData -> cellData.getValue().getAddress().getCityProperty());
				colState.setCellValueFactory(cellData -> cellData.getValue().getAddress().getStateProperty());
				colZip.setCellValueFactory(cellData -> cellData.getValue().getAddress().getZipProperty());
				libraryMemberTable.setItems(FXCollections.observableArrayList(searchMember));
			}
		}

	}

}
