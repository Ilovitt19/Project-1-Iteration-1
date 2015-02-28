import java.util.Date;


public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private int creditCardNumber;
	private Date creditCardExpiration;
	private int customerId;
	
	public Customer(String name, String address, String phoneNumber, int creditCardNumber, Date creditCardExpiration, int customerId) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExpiration = creditCardExpiration;
		this.customerId = customerId;
	}
	
	
}
