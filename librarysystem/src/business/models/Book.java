package business.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ISBN;
	private String title;
	private int maxCheckoutLength;
	private List<Author> author = new ArrayList<Author>();

	public Book(String iSBN, String title, int maxCheckoutLength, List<Author> author) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
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

	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

}
