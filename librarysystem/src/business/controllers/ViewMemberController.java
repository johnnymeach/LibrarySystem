package business.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewMemberController {

	@FXML
	private Label lblClose;
	Stage stage;

	public void backToDashboard() {
		LoginController.helper.backToHome(stage, lblClose, "../views/home/Dashboard.fxml");
	}

	public void loadAddNewMemberView() {
		String memberView = "../views/librarian/AddNewMember.fxml";
		String viewTitle = "Add New Member";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}
}
