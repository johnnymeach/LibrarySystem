package business.controllers;

import business.util.Helper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewMemberController {

	@FXML
	private Label lblClose;
	
	private Helper helper = new Helper();
	Stage stage;

	public void backToHome() {
		helper.backToHome(stage, lblClose);
	}

	public void loadAddNewMemberView() {
		String memberView = "../views/librarian/AddNewMember.fxml";
		String viewTitle = "Add New Member";
		helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}
}
