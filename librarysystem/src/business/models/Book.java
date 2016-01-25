package business.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ISBN;
	private String title;
	private String maxCheckoutLength;
	private String numCopies;
	private List<Author> author = new ArrayList<Author>();
	private List<BookCopy> bookList = new ArrayList<BookCopy>();

	public List<BookCopy> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookCopy> bookList) {
		this.bookList = bookList;
	}

	public Book(String iSBN, String title, String maxCheckoutLength, List<Author> author, String numCopies) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		this.author = author;
		this.numCopies = numCopies;
		for (int i = 0; i < Integer.parseInt(numCopies); i++) {
			addBookCopy(i);
		}

	}

	public void addBookCopy(int numCopy) {
		int lastSize = bookList.size() + 1;
		BookCopy copy = new BookCopy(this, this.getISBN() + "-" + lastSize,true );
		bookList.add(copy);
	}

	public String getISBN() {
		return ISBN;
	}

	public String getNumCopies() {
		return this.numCopies;
	}

	public void setNumCopies(String numCopy) {
		this.numCopies = numCopy;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	public void setMaxCheckoutLength(String maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

}
