package business.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import business.models.PersonRole;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardControlller implements Initializable {

	@FXML
	private Label lblClose;
	Stage stage;
	
	@FXML
	private Button btnCheckoutBook;
	@FXML
	private Button btnBook;
	@FXML
	private Button btnAuthor;
	@FXML
	private Button btnMember;
	

	@FXML
	public void openMemberInfo() {

		String memberView = "../views/librarian/ViewMember.fxml";
		String viewTitle = "Library System";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}

	@FXML
	public void openBookInfo() {
		String memberView = "../views/book/ViewBook.fxml";
		String viewTitle = "Library System";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}

	@FXML
	public void openLibrarianInfo() {

	}

	@FXML
	public void openAuthorInfo() {
		String memberView = "../views/author/AddNewAuthor.fxml";
		String viewTitle = "Library System";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}

	@FXML
	public void changePassword() {

	}

	@FXML
	public void signOut() {
		String memberView = "../views/login/Login.fxml";
		String viewTitle = "Library System";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}

	@FXML
	public void openCheckoutForm() {
		String checkoutView = "../views/CheckoutBook.fxml";
		String viewTitle = "Library System";
		LoginController.helper.loadNewStage(stage, lblClose, checkoutView, viewTitle, false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> {
			System.out.println(LoginController.user.getRole());
			if(LoginController.user.getRole().equals(PersonRole.LIBRARIAN)){
				
				btnBook.setDisable(true);
				btnAuthor.setDisable(true);
				btnMember.setDisable(true);
			}else if(LoginController.user.getRole().equals(PersonRole.ADMINISTRATOR)){
				btnCheckoutBook.setDisable(true);
				
			}else{
				System.out.println("Else...");
			}
		});
	}


}
