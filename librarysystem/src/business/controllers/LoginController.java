package business.controllers;

import java.net.URL;
import java.util.ResourceBundle;

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

	@FXML
	private Label lblClose;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	private Helper helper = new Helper();
	Stage stage;

	public void loginAction(ActionEvent event) {
		String memberView = "../views/librarian/AddNewMember.fxml";
		String viewTitle = "Library Member";
		System.out.println(usernameField.getText());
		System.out.println(passwordField.getText());
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
