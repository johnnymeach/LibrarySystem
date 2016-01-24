package business.util;

import business.controllers.EditMemberController;
import business.models.LibraryMember;
import business.models.User;
import business.models.getControllerWithParam;
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

	public void loadNewStageWithParam(getControllerWithParam ctl, Stage oldStage, Label lb, String viewName,
			String viewTitle, boolean maximized, LibraryMember selectedMember) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(viewName));
			Parent root = (Parent) loader.load();
			if (ctl != null) {
				ctl.getObjectController(loader.getController());
			}
			Scene newScene = new Scene(root);
			Stage newStage = new Stage();

			oldStage = (Stage) lb.getScene().getWindow();
			newStage.setTitle(viewTitle);
			newStage.setMaximized(maximized);
			newStage.setTitle(viewTitle);
			newStage.setScene(newScene);
			newStage.show();
		} catch (Exception e) {
			e.printStackTrace();
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

	public void showSuccessDialog(String msg, String title) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setContentText(msg);
		alert.showAndWait();
	}
}