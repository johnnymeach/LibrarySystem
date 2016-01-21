package business.models;

import java.io.Serializable;
import java.util.List;

public class BookCopy extends Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numCopy;

	public BookCopy(String iSBN, String title, int maxCheckoutLength, List<Author> author, int numCopy) {
		super(iSBN, title, maxCheckoutLength, author);
		this.numCopy = numCopy;
	}

	public int getNumCopy() {
		return numCopy;
	}

	public void setNumCopy(int numCopy) {
		this.numCopy = numCopy;
	}
	
	
}
