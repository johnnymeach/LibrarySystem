package business.models;

import java.io.Serializable;

public class Administrator extends Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private String adminstratorID;
	private PersonRole personRole;

	public Administrator(String firstName, String lastName, String phone, Address address, String adminstratorID,
			PersonRole personRole) {
		super(firstName, lastName, phone, address);
		this.personRole = personRole;
		this.adminstratorID = adminstratorID;
	}

	public PersonRole getPersonRole() {
		return personRole;
	}

	public void setPersonRole(PersonRole personRole) {
		this.personRole = personRole;
	}

	public String getAdminstratorID() {
		return adminstratorID;
	}

	public void setAdminstratorID(String adminstratorID) {
		this.adminstratorID = adminstratorID;
	}

}
