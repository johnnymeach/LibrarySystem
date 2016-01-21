package business.controllers;

import business.util.Helper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardControlller {
	
	@FXML
	private Label lblClose;
	Stage stage;
	Helper helper = new Helper();
	
	public void openMemberInfo(){
		System.out.println("Hello");
//		String memberView = "../views/librarian/ViewMember.fxml";
//		String viewTitle = "Library System";
//		helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}
}
