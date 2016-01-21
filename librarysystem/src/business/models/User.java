package business.models;

import java.io.Serializable;

public class User extends Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userID;
	private String userPassword;

	public User(String firstName, String lastName, String phone, Address address, String userID, String userPassword) {
		super(firstName, lastName, phone, address);
		this.userID = userID;
		this.userPassword = userPassword;
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

}
