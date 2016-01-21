package business.controllers;

import business.util.Helper;
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
		helper.backToHome(stage, lblClose,"../views/librarian/ViewMember.fxml");
	}
	
	public void test(){
		System.out.println("Test from other controller");
	}

}
