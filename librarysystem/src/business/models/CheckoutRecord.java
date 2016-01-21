package business.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	private LibraryMember libraryMember=new LibraryMember();
    private List<CheckoutRecordEntry> checkoutRecordEntries=new ArrayList<CheckoutRecordEntry>();
    
	
}
