package business.controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import business.models.Book;
import business.models.BookCopy;
import business.models.CheckoutRecordEntry;
import business.models.LibraryMember;
import dataaccess.BookImpl;
import dataaccess.LibraryMemberImpl;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckoutController {
	LocalDate checkoutDate = LocalDate.now();
	static LibraryMember checkingoutMember = null;
	static Book checkingoutBook = null;
	LibraryMemberImpl libraryMember = new LibraryMemberImpl();
	List<LibraryMember> memberList = libraryMember.getAllItems();
	BookImpl bookImpl = new BookImpl();
	List<Book> bookList = bookImpl.getAllItems();

	@FXML
	private TableView<BookCopy> tableListOfCopy;
	@FXML
	private TableColumn<BookCopy, String> colCopyNumber;
	@FXML
	private TableColumn<BookCopy, String> colAvailable;
	@FXML
	private TableColumn<BookCopy, String> colBookCopyTitle;
	@FXML
	private TableColumn<BookCopy, String> colMaxCheckoutLength;

	@FXML
	private TableView<CheckoutRecordEntry> tableCheckoutBook;
	@FXML
	private TableColumn<CheckoutRecordEntry, String> colTitleBook;
	@FXML
	private TableColumn<CheckoutRecordEntry, String> colCopyNo;
	@FXML
	private TableColumn<CheckoutRecordEntry, String> colISBN;
	@FXML
	private TableColumn<CheckoutRecordEntry, String> colCheckoutDate;
	@FXML
	private TableColumn<CheckoutRecordEntry, String> colDueDate;

	@FXML
	private TextField txtSearchMemberID;
	@FXML
	private TextField txtSearchBookISBN;
	@FXML
	private Text txtNumberCopy;
	@FXML
	private Text txtMemberName;
	@FXML
	private Text txtBookTitle;
	Stage stage;
	@FXML
	private Label lblClose;

	public void searchMember() {
		String requestId = txtSearchMemberID.getText();
		if (requestId.isEmpty()) {
			LoginController.helper.showSuccessDialog("Please input memberID", "Empty Field");
		} else {
			checkingoutMember = libraryMember.searchLibraryMember(requestId);
			if (checkingoutMember == null) {
				LoginController.helper.showSuccessDialog("Search not found", "Not found");
				txtMemberName.setText("");
			} else {
				txtMemberName.setText(checkingoutMember.getFirstName() + " " + checkingoutMember.getLastName());
//				tableCheckoutBook.setItems(FXCollections
//						.observableArrayList(checkingoutMember.getCheckoutRecord().getCheckoutRecordEntries()));
			}
		}
	}

	public void searchBook() {

		String requestId = txtSearchBookISBN.getText();
		if (requestId.isEmpty()) {
			LoginController.helper.showSuccessDialog("Please input ISBN", "Empty Field");
		} else {
			checkingoutBook = bookImpl.searchBook(requestId);
			if (checkingoutBook == null) {
				LoginController.helper.showSuccessDialog("Search not found", "Not found");
				txtBookTitle.setText("");
				txtNumberCopy.setText("");
			} else {
				txtBookTitle.setText(checkingoutBook.getTitle());
				txtNumberCopy.setText(checkingoutBook.getNumCopies());
				showBookCopyList(checkingoutBook);
			}
		}

	}

	public void showBookCopyList(Book book) {

		List<BookCopy> bookCopyList = book.getBookList();
		colCopyNumber.setCellValueFactory(new PropertyValueFactory<BookCopy, String>("numCopy"));
		colBookCopyTitle.setCellValueFactory(cellData -> cellData.getValue().getBookTitleProperty());
		colMaxCheckoutLength.setCellValueFactory(cellData -> cellData.getValue().getBookMaxCheckoutProperty());
		colAvailable.setCellValueFactory(cellData -> cellData.getValue().getIsAvailableProperty());
		tableListOfCopy.setItems(FXCollections.observableArrayList(bookCopyList));

	}

	public void selectCheckoutBook() {
		BookCopy selectedBookBopy = tableListOfCopy.getSelectionModel().getSelectedItem();
		LocalDate dueDate = LocalDate.now().plus(Integer.parseInt(selectedBookBopy.getBook().getMaxCheckoutLength()),ChronoUnit.DAYS);
//				
//		List<CheckoutRecordEntry> checkoutRecordEntries = new CheckoutRecordEntry(selectedBookBopy, checkoutDate, dueDate);
//		CheckoutRecord checkoutRecord = new CheckoutRecord(checkingoutMember, checkoutRecordEntries);
//		checkingoutMember.setCheckoutRecord(checkoutRecord);
//		colISBN.setCellValueFactory(new PropertyValueFactory<BookCopy, String>("numCopy"));
//		colTitleBook.setCellValueFactory(cellData -> cellData.getValue().getBookTitleProperty());
//		colCheckoutDate.setCellValueFactory(cellData -> cellData.getValue().getBookMaxCheckoutProperty());
//		colDueDate.setCellValueFactory(cellData -> cellData.getValue().getIsAvailableProperty());
//		colCopyNo.setCellValueFactory(cellData -> cellData.getValue().getBookTitleProperty());
		tableCheckoutBook.setItems(FXCollections.observableArrayList());
	}

	public void backToDashboard() {
		LoginController.helper.backToHome(stage, lblClose, "../views/home/Dashboard.fxml");
	}

}
