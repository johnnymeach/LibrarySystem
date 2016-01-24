package business.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import business.models.Address;
import business.models.LibraryMember;
import dataaccess.LibraryMemberImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class EditMemberController implements Initializable {

	private LibraryMember selectedMember;
	@FXML
	private TextField txtMemberID;
	@FXML
	private TextField txtMemberFName;
	@FXML
	private TextField txtMemberLName;
	@FXML
	private TextField txtMemberPhone;
	@FXML
	private TextField txtMemberStreet;
	@FXML
	private TextField txtMemberCity;
	@FXML
	private TextField txtMemberState;
	@FXML
	private TextField txtMemberZip;

	public LibraryMember getSelectedMember() {
		return selectedMember;
	}

	public void setSelectedMember(LibraryMember selectedMember) {
		this.selectedMember = selectedMember;
	}

	@FXML
	private Label lblClose;
	Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(() -> {
			getDataToEdit();
		});

	}

	public void getDataToEdit() {
		txtMemberID.setDisable(true);
		txtMemberID.setText(selectedMember.getMemberId());
		txtMemberFName.setText(selectedMember.getFirstName());
		txtMemberLName.setText(selectedMember.getLastName());
		txtMemberPhone.setText(selectedMember.getPhone());
		txtMemberStreet.setText(selectedMember.getAddress().getStreet());
		txtMemberState.setText(selectedMember.getAddress().getState());
		txtMemberCity.setText(selectedMember.getAddress().getCity());
		txtMemberZip.setText(selectedMember.getAddress().getZip());
	}

	public void backToMemberView() {
		LoginController.helper.backToHome(stage, lblClose, "../views/librarian/ViewMember.fxml");
	}

	public void SaveEditedField() {
		checkRequireField();
		Address address = new Address(txtMemberStreet.getText(), txtMemberCity.getText(), txtMemberState.getText(),
				txtMemberZip.getText());
		LibraryMember currentMember = new LibraryMember();

		currentMember.setMemberId(txtMemberID.getText());
		currentMember.setFirstName(txtMemberFName.getText());
		currentMember.setLastName(txtMemberLName.getText());
		currentMember.setPhone(txtMemberPhone.getText());
		currentMember.setAddress(address);

		LibraryMemberImpl memberImpl = new LibraryMemberImpl();
		memberImpl.editLibraryMember(currentMember);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Update successfully");
		alert.setContentText("Member was updated to the system");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			String memberView = "../views/librarian/ViewMember.fxml";
			String viewTitle = "Library System";
			LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
		}
		
	}

	public void checkRequireField() {
		if (txtMemberFName.getText().isEmpty() || txtMemberLName.getText().isEmpty()
				|| txtMemberPhone.getText().isEmpty() || txtMemberStreet.getText().isEmpty()
				|| txtMemberCity.getText().isEmpty() || txtMemberState.getText().isEmpty()
				|| txtMemberZip.getText().isEmpty()) {
			LoginController.helper.showErroDialog("All fields are required", "Error empty fields");
		}
	}

}
