package business.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import business.models.PersonRole;
import business.models.User;
import business.util.Helper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	static User user;
	PersonRole role;
	@FXML
	private Label lblClose;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	private Helper helper = new Helper();
	Stage stage;

	public void loginAction(ActionEvent event) {
//		System.out.println(usernameField.getText());
//		System.out.println(passwordField.getText());
		
		String memberView = "../views/home/Dashboard.fxml";
		String viewTitle = "Library System";
		helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
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
}
