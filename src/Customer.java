import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private CreditCard card;
	private String customerId;
	
	private List creditCards = new LinkedList();
	public Customer(String name, String address, String phoneNumber, CreditCard card, String customerId) {
		
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.card = card;
		this.customerId = customerId;
	}
	
	public void removeCreditCard(String creditCardNumber) {
		for (Iterator iterator = creditCards.iterator(); iterator.hasNext(); ) {
		      CreditCard card = (CreditCard) iterator.next();
		      if (card.getNumber().equals(creditCardNumber)) {
		    	  creditCards.remove(card);//this might not work
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

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
	}

