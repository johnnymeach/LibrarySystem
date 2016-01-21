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

public class AddNewAuthorController implements Initializable{
	
	Stage stage;
	Helper helper = new Helper();
	@FXML
	private Label lblClose;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Platform.runLater(() -> {
			lblClose.setOnMouseClicked((MouseEvent event) -> {
				Platform.exit();
				System.exit(0);
			});
		});

	}
	
	public void test(){
		System.out.println("hello");
	}

	

}
