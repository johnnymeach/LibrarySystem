package business.util;

import business.models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Helper {
	User user;

	public void loadView(Stage stage, String viewName, String viewTitle, boolean maximized) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(viewName));
		stage.setTitle(viewTitle);
		stage.setMaximized(maximized);
		stage.setTitle(viewTitle);
		stage.setScene(new Scene(root));
		stage.show();
	}

	public void loadNewStage(Stage stage, Label lb, String viewName, String viewTitle, boolean maximized) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(viewName));
			stage = (Stage) lb.getScene().getWindow();
			Stage newStage = new Stage();
			newStage.setTitle(viewTitle);
			newStage.setMaximized(maximized);
			newStage.setTitle(viewTitle);
			newStage.setScene(new Scene(root));
			newStage.show();
			stage.close();
		} catch (Exception e) {
		}

	}

	public void backToHome(Stage stage, Label lblClose, String memberView) {
		String viewTitle = "Library Member";
		loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}

	public void showErroDialog(String msg, String title) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setContentText(msg);
		alert.showAndWait();
	}
}
