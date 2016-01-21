package business.models;

import java.io.Serializable;

public class User extends Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userID;
	private String userPassword;
	private PersonRole role;

	public User(String firstName, String lastName, String phone, Address address, String userID, String userPassword, PersonRole role) {
		super(firstName, lastName, phone, address);
		this.userID = userID;
		this.userPassword = userPassword;
		this.role = role;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String toString() {
		return "Checkout record for library member " + userID + ": " + userPassword + ": "+role;
	}

}
