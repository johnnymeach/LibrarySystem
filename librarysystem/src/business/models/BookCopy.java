package business.models;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookCopy implements Serializable {

	private static final long serialVersionUID = 1L;
	private String copyNum;
	private Book book;
	private boolean isAvailable;
	public BookCopy(Book book, String copyNum, boolean isAvailable) {
		this.book = book;
		this.copyNum = copyNum;
		this.isAvailable = isAvailable;
	}

	public String getCopyNum() {
		return copyNum;
	}

	public void setCopyNum(String copyNum) {
		this.copyNum = copyNum;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getNumCopy() {
		return copyNum;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setNumCopy(String copyNum) {
		this.copyNum = copyNum;
	}
	
	public StringProperty getBookTitleProperty(){
		return new SimpleStringProperty(this.getBook().getTitle());
	}
	
	public StringProperty getBookMaxCheckoutProperty(){
		return new SimpleStringProperty(this.getBook().getMaxCheckoutLength());
	}
	
	public StringProperty getIsAvailableProperty() {
		return new SimpleStringProperty(isAvailable ? "Yes" : "No");
	}

	public StringProperty getCopyNoProperty() {
		return new SimpleStringProperty(this.copyNum);
	}
	
	
}
