package business.controllers;

import business.models.Address;
import business.models.CheckoutRecord;
import business.models.LibraryMember;
import business.util.Helper;
import dataaccess.LibraryMemberImpl;
import dataaccess.LibraryMemberIn;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewMemberController {

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
	Stage stage;
	Helper helper = new Helper();
	@FXML
	private Label lblClose;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnMemberInfoClear;
	@FXML
	private Button btnMemberInfoSave;

	public void clearAllInput() {
		txtMemberID.setText("");
		txtMemberFName.setText("");
		txtMemberLName.setText("");
		txtMemberPhone.setText("");
		txtMemberStreet.setText("");
		txtMemberCity.setText("");
		txtMemberState.setText("");
		txtMemberZip.setText("");
	}

	public void backToMemberView() {
		helper.backToHome(stage, lblClose, "../views/librarian/ViewMember.fxml");
	}

	public void addNewMember() {
		checkRequireField();
		Address address = new Address(txtMemberStreet.getText(), txtMemberCity.getText(), txtMemberState.getText(),
				txtMemberZip.getText());
		LibraryMember newLibraryMember = new LibraryMember();

		newLibraryMember.setMemberId(txtMemberID.getText());
		newLibraryMember.setFirstName(txtMemberFName.getText());
		newLibraryMember.setLastName(txtMemberLName.getText());
		newLibraryMember.setPhone(txtMemberPhone.getText());
		newLibraryMember.setAddress(address);

		LibraryMemberImpl memberImpl = new LibraryMemberImpl();
		memberImpl.addLibraryMember(newLibraryMember);
		LoginController.helper.showSuccessDialog("New Member was added to the system", "Save successfully");
	}

	public void checkRequireField() {
		if (txtMemberID.getText().isEmpty() || txtMemberFName.getText().isEmpty() || txtMemberLName.getText().isEmpty()
				|| txtMemberPhone.getText().isEmpty() || txtMemberStreet.getText().isEmpty()
				|| txtMemberCity.getText().isEmpty() || txtMemberState.getText().isEmpty()
				|| txtMemberZip.getText().isEmpty()) {
			LoginController.helper.showErroDialog("All fields are required", "Error empty fields");
		}
	}

}
