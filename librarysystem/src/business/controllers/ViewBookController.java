package business.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import business.models.Book;
import business.models.LibraryMember;
import dataaccess.BookImpl;
import dataaccess.LibraryMemberImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewBookController implements Initializable {


	LibraryMemberImpl libraryMember = new LibraryMemberImpl();
	List<LibraryMember> memberList = libraryMember.getAllItems();
	BookImpl bookImp = new BookImpl();
	List<Book> bookList = bookImp.getAllItems();
	
	@FXML
	private Label lblClose;
	Stage stage;

	@FXML
	private TextField txtSearchBook;

	@FXML
	private TableView<Book> bookTable;
	@FXML
	private TableColumn<Book, String> colISBN;
	@FXML
	private TableColumn<Book, String> colTitle;
	@FXML
	private TableColumn<Book, String> colNumCopy;
	
	

	public void backToDashboard() {
		LoginController.helper.backToHome(stage, lblClose, "../views/home/Dashboard.fxml");
	}

	public void loadAddNewBookView() {
		String memberView = "../views/book/AddNewBook.fxml";
		String viewTitle = "Add New Member";
		LoginController.helper.loadNewStage(stage, lblClose, memberView, viewTitle, false);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(() -> {
			getAllBooks();
			lblClose.setOnMouseClicked((MouseEvent event) -> {
				Platform.exit();
				System.exit(0);
			});
		});

	}

	public void getAllBooks() {
		
		colISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
		colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		colNumCopy.setCellValueFactory(new PropertyValueFactory<Book, String>("numCopies"));
		bookTable.setItems(FXCollections.observableArrayList(bookList));
	}

	public void openEditMemberView() {
		/*
		//LibraryMember selectedMember = libraryMemberTable.getSelectionModel().getSelectedItem();
		String memberView = "../views/librarian/EditMember.fxml";
		String viewTitle = "Edit Member";
		LoginController.helper.loadNewStageWithParam(new getControllerWithParam() {

			@Override
			public void getObjectController(Object controller) {
				// TODO Auto-generated method stub
				EditMemberController ctrl = (EditMemberController) controller;
				ctrl.setSelectedMember(selectedMember);
			}
		}, stage, lblClose, memberView, viewTitle, false, selectedMember);
		*/
	}

	public void searchBook() {
		Book searchBook = null;
		String requestId = txtSearchBook.getText();
		if (requestId.isEmpty()) {
			LoginController.helper.showSuccessDialog("Please input ISBN", "Empty Field");
			bookTable.setItems(FXCollections.observableArrayList(bookList));
		} else {
			searchBook = bookImp.searchBook(requestId);
			if (searchBook == null) {
				LoginController.helper.showSuccessDialog("Search not found", "Not found");
				bookTable.setItems(null);
			} else {
				colISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
				colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
				colNumCopy.setCellValueFactory(new PropertyValueFactory<Book, String>("numCopies"));
				bookTable.setItems(FXCollections.observableArrayList(searchBook));
			}
		}

	} 

}
