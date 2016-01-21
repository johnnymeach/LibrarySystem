package business.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	private LibraryMember libraryMember=new LibraryMember();
    private List<CheckoutRecordEntry> checkoutRecordEntries=new ArrayList<CheckoutRecordEntry>();
    
    
    public CheckoutRecord(LibraryMember libraryMember, List<CheckoutRecordEntry> checkoutRecordEntries) {
		this.libraryMember = libraryMember;
		this.checkoutRecordEntries = checkoutRecordEntries;
	}


	public LibraryMember getLibraryMember() {
		return libraryMember;
	}


	public void setLibraryMember(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
	}


	public List<CheckoutRecordEntry> getCheckoutRecordEntries() {
		return checkoutRecordEntries;
	}


	public void setCheckoutRecordEntries(List<CheckoutRecordEntry> checkoutRecordEntries) {
		this.checkoutRecordEntries = checkoutRecordEntries;
	}


	public void addCheckoutRecordEntries(CheckoutRecordEntry c) {
    	checkoutRecordEntries.add(c);
	}
	
}
