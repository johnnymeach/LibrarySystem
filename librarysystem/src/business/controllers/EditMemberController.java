package business.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EditMemberController {

	@FXML
	private Label lblClose;
	Stage stage;
	public void backToMemberView() {
		LoginController.helper.backToHome(stage, lblClose,"../views/librarian/ViewMember.fxml");
	}
	
}
