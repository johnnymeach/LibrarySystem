package business.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import business.models.LibraryMember;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditMemberController implements Initializable{

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
	
	public void getDataToEdit(){
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
		LoginController.helper.backToHome(stage, lblClose,"../views/librarian/ViewMember.fxml");
	}
	
	public void SaveEditedField(){
		
	}
	
	
}
