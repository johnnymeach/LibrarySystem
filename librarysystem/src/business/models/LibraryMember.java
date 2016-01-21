package business.models;

import java.io.Serializable;
import java.util.UUID;

public class LibraryMember extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberId;
	private CheckoutRecord checkoutRecord;

	public LibraryMember(){
		
	}
	public LibraryMember(String firstName, String lastName, String phone, Address address, String memberId,
			CheckoutRecord checkoutRecord) {
		super(firstName, lastName, phone, address);
		this.memberId = memberId;
		this.checkoutRecord = checkoutRecord;
	}

}
