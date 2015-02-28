import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private String creditCardNumber;
	private Date creditCardExpiration;
	private String customerId;
	private List creditCards = new LinkedList();
	public Customer(String name, String address, String phoneNumber, String creditCardNumber, Date creditCardExpiration, String customerId) {
		
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExpiration = creditCardExpiration;
		this.customerId = customerId;
	}
	
	public void removeCreditCard(String creditCardNumber) {
		for (Iterator iterator = creditCards.iterator(); iterator.hasNext(); ) {
		      Customer customer = (Customer) iterator.next();
		      if (customer.getCustomerId().equals(customerId)) {
		    	  creditCards.remove(customer);//this might not work
		      }
		}
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

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Date getCreditCardExpiration() {
		return creditCardExpiration;
	}

	public void setCreditCardExpiration(Date creditCardExpiration) {
		this.creditCardExpiration = creditCardExpiration;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
	}

