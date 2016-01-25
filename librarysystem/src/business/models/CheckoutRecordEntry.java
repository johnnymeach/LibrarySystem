package business.models;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CheckoutRecordEntry implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BookCopy copy;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public CheckoutRecordEntry(BookCopy copy, LocalDate checkoutDate, LocalDate dueDate){ 
		this.copy = copy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	public BookCopy getCopy() {
		return copy;
	}
	public void setCopy(BookCopy copy) {
		this.copy = copy;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public StringProperty getISBNProperty() {
		return new SimpleStringProperty(this.getCopy().getBook().getISBN());
	}

	public StringProperty getTitleProperty() {
		return new SimpleStringProperty(this.getCopy().getBook().getTitle());
	}
	public StringProperty getCopyIDProperty() {
		return new SimpleStringProperty(this.getCopy().getNumCopy());
	}
	public ObjectProperty<LocalDate> getCheckoutDateProperty() {
		return new SimpleObjectProperty<LocalDate>(this.getCheckoutDate());
	}
	public ObjectProperty<LocalDate> getDueDateProperty() {
		return new SimpleObjectProperty<LocalDate>(this.getDueDate());
	}
	public ObjectProperty<LocalDate> getReturnDateProperty() {
		return new SimpleObjectProperty<LocalDate>(this.getReturnDate());
	}

	
}
