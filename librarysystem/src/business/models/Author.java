package business.models;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Author extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String credential;
	private String shortBio;

	public Author(String firstName, String lastName, String phone, Address address, String credential,
			String shortBio) {
		super(firstName, lastName, phone, address);
		this.credential = credential;
		this.shortBio = shortBio;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getShortBio() {
		return shortBio;
	}
	public StringProperty getName(){
		return new SimpleStringProperty(this.getFirstName() + " " + this.getLastName());
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

}
