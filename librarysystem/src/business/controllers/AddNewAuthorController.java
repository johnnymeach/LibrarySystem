package business.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import business.models.Address;
import business.models.Author;
import business.util.Helper;
import dataaccess.AuthorImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddNewAuthorController implements Initializable {

	Stage stage;
	Helper helper = new Helper();
	@FXML
	private Label lblClose;
	@FXML
	private Button btnAuthorInfoSave;
	@FXML
	private Button btnAuthorInfoClear;
	@FXML
	private Button btnAuthorInfoBack;

	@FXML
	private TextField txtAuthorFName;
	@FXML
	private TextField txtAuthorLName;
	@FXML
	private TextField txtAuthorPhone;
	@FXML
	private TextField txtAuthorStreet;
	@FXML
	private TextField txtAuthorCity;
	@FXML
	private TextField txtAuthorState;
	@FXML
	private TextField txtAuthorZip;
	@FXML
	private TextField txtAuthorShortBio;
	@FXML
	private TextField txtAuthorCredential;

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

	public void addNewAuthor() {
		checkRequireField();
		Address address = new Address(txtAuthorStreet.getText(), txtAuthorCity.getText(), txtAuthorState.getText(),
				txtAuthorZip.getText());
		Author newAuthor = new Author(txtAuthorFName.getText(), txtAuthorLName.getText(), txtAuthorPhone.getText(),
				address, txtAuthorCredential.getText(), txtAuthorShortBio.getText());
		AuthorImpl authorImpl = new AuthorImpl();
		authorImpl.addAuthor(newAuthor);
		LoginController.helper.showSuccessDialog("New auhtor was added to the system", "Save successfully");
	}

	public void checkRequireField() {
		if (txtAuthorFName.getText().isEmpty() || txtAuthorLName.getText().isEmpty()
				|| txtAuthorPhone.getText().isEmpty() || txtAuthorStreet.getText().isEmpty()
				|| txtAuthorCity.getText().isEmpty() || txtAuthorState.getText().isEmpty()
				|| txtAuthorZip.getText().isEmpty() || txtAuthorShortBio.getText().isEmpty()) {
			LoginController.helper.showErroDialog("All fields are required", "Error empty fields");
		}
	}

	public void clearAllInput() {
		txtAuthorFName.setText("");
		txtAuthorLName.setText("");
		txtAuthorPhone.setText("");
		txtAuthorStreet.setText("");
		txtAuthorCity.setText("");
		txtAuthorState.setText("");
		txtAuthorZip.setText("");
		txtAuthorShortBio.setText("");
		txtAuthorCredential.setText("");
	}

}
