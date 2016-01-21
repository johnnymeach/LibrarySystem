package business.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import business.util.Helper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddNewBookController implements Initializable{
	
	Stage stage;
	Helper helper = new Helper();
	@FXML
	private Label lblClose;
	@FXML
	private Button btnNewAuthor;
	
	public void addAuthor(ActionEvent event) throws Exception{
		String AuthorView = "../views/author/addAuthor.fxml";
		String viewTitle = "Add New Author";
		helper.loadNewStage(stage,lblClose, AuthorView, viewTitle, false);
		System.out.println("xyz");
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Platform.runLater(() -> {
			lblClose.setOnMouseClicked((MouseEvent event) -> {
				Platform.exit();
				System.exit(0);
			});
		});

	}
	
	public void backToDashboard() {
		LoginController.helper.backToHome(stage, lblClose, "../views/home/Dashboard.fxml");
	}

	

}
