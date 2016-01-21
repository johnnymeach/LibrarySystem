package business.models;

import java.io.Serializable;

public class Librarian extends Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private String librarianID;

	public Librarian(String firstName, String lastName, String phone, Address address, String librarianID) {
		super(firstName, lastName, phone, address);
		this.librarianID = librarianID;
	}

	public String getLibrarianID() {
		return librarianID;
	}

	public void setLibrarianID(String librarianID) {
		this.librarianID = librarianID;
	}

}
