package business.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardControlller {

	@FXML
	private Label lblClose;
	Stage stage;

	public void openMemberInfo() {
		
		String memberView = "../views/librarian/ViewMember.fxml";
		String viewTitle = "Library System";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}

	public void openBookInfo() {

	}

	public void openLibraryInfo() {

	}

	public void openAuthorInfo() {

	}

	public void changePassword() {

	}
	
	public void signOut(){
		String memberView = "../views/login/Login.fxml";
		String viewTitle = "Library System";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}
	
	public void openAdminInfo(){
		
	}

}
