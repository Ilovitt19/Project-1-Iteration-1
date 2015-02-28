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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Date getCreditCardExpiration() {
		return creditCardExpiration;
	}

	public void setCreditCardExpiration(Date creditCardExpiration) {
		this.creditCardExpiration = creditCardExpiration;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	}

