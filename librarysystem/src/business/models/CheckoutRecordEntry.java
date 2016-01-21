package business.models;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntry implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LocalDate checkoutDate;
	private LocalDate dueDate;

}
