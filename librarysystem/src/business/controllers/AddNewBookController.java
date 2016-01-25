package business.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.models.Author;
import business.models.Book;
import business.util.Helper;
import dataaccess.AuthorImpl;
import dataaccess.BookImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddNewBookController implements Initializable{
	
	Stage stage;
	Helper helper = new Helper();
	@FXML
	private Label lblClose;
	@FXML
	private Button btnNewAuthor;
	
	@FXML
	private TextField txt_ISBN;
	@FXML
	private TextField txtBookTitle;
	@FXML
	private TextField txtMaxCheckoutLength;
	
	@FXML
	private TextField txtnoofcopies;
	@FXML
	private TextField txtAuthorNames;
	
	AuthorImpl author = new AuthorImpl();
	List<Author> authorList = author.getAllItems();
	
	List<Author> selectedAuthorList = new ArrayList<Author>();
	public ComboBox<String> comboAuthorList = new ComboBox<String>();
	@FXML
	public TableView<Author> authorListTable;
	@FXML
	private TableColumn<Author, String> colFirstname;
	@FXML
	private TableColumn<Author, String> colLastname;
	
	public void addAuthor(ActionEvent event) throws Exception{
		
		String AuthorView = "../views/author/addNewAuthor.fxml";
		String viewTitle = "Add New Author";
		helper.loadNewStage(stage,lblClose, AuthorView, viewTitle, false);
		//System.out.println("xyz");
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<String> authorName = new ArrayList<String>();
	for(Author a : authorList){
		//comboAuthorList.getItems().add(a.getFirstName());
		authorName.add(a.getFirstName() + " " + a.getLastName());

		System.out.println("FirstName: " + a.getFirstName());
	}
	
	colFirstname.setCellValueFactory(new PropertyValueFactory<Author, String>("firstName"));
	colLastname.setCellValueFactory(new PropertyValueFactory<Author, String>("lastName"));
	
	authorListTable.setItems(FXCollections.observableArrayList(authorList));

	
	
//		ObservableList obList = FXCollections.observableList(authorName);
//		  comboAuthorList.getItems().clear();
//		  comboAuthorList.setItems(obList);
		  
		 
		Platform.runLater(() -> {
			lblClose.setOnMouseClicked((MouseEvent event) -> {
				Platform.exit();
				System.exit(0);
			});
		});

	}

	public void addNewBook(){
		Book newBook = new Book(txt_ISBN.getText() ,txtBookTitle.getText(), txtMaxCheckoutLength.getText(), selectedAuthorList, txtnoofcopies.getText());
		BookImpl bookImpl = new BookImpl();
		bookImpl.addBook(newBook);
		LoginController.helper.showSuccessDialog("New book was successfully saved", "Save successfully");
		
	}
	public void backToDashboard() {
		LoginController.helper.backToHome(stage, lblClose, "../views/home/Dashboard.fxml");
	}
	
	public void backToViewBook() {
		LoginController.helper.backToHome(stage, lblClose, "../views/book/ViewBook.fxml");
	}

	public void getAuthorInfo(){
		selectedAuthorList.add(authorListTable.getSelectionModel().getSelectedItem());
		if(txtAuthorNames.getText()==null){
			txtAuthorNames.setText(
					authorListTable.getSelectionModel().getSelectedItem().getFirstName()+ " " +
					authorListTable.getSelectionModel().getSelectedItem().getLastName());
		}
		else{
		txtAuthorNames.setText(txtAuthorNames.getText()+","+
				authorListTable.getSelectionModel().getSelectedItem().getFirstName()+ " " +
				authorListTable.getSelectionModel().getSelectedItem().getLastName());
		}
	}
	

}
