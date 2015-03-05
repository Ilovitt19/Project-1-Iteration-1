import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * This class stores customers
 *
 * */

public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private CreditCard card;
	private String customerId;
	private static final String CUSTOMER_STRING = "C";
	private List creditCards = new LinkedList();
	/**
	 * Constructor for the customer class
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param card
	 */
	public Customer(String name, String address, String phoneNumber, CreditCard card) {

		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		creditCards.add(this.card = card); //adds the first creditcard to the list.

		customerId = CUSTOMER_STRING + (CustomerIdServer.instance()).getId();
	}
	/**
	 * adds a credit card to the credit cards list
	 * @param card
	 */
	public void addCreditCard(CreditCard card) {
		creditCards.add(card);

	}
	public boolean removeCreditCard(String creditCardNumber) {
//		for (Iterator iterator = creditCards.iterator(); iterator.hasNext(); ) {
//			CreditCard card = (CreditCard) iterator.next();
//			if (card.getNumber().equals(creditCardNumber)) {
//				creditCards.remove(card);//this works
//			}
//		}
		CreditCard card = searchCreditCard(creditCardNumber);
		if (card == null) {
			return false;
		} else {
			return creditCards.remove(card);
		}
	}
	public CreditCard searchCreditCard(String cardNumber) {
		for (Iterator iterator = creditCards.iterator(); iterator.hasNext(); ) {
			CreditCard card = (CreditCard) iterator.next();
			if (card.getNumber().equals(cardNumber)) {
				return card;
			}
		}
		return null;
	}
	/**
	 * gets customer name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets customer name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets customer address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * sets customer address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * sets customer phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * gets customer credit card object
	 * @return card object
	 */
	public CreditCard getCard() {
		return card;
	}
	/**
	 * sets customer credit card
	 * @param card
	 */
	public void setCard(CreditCard card) {
		this.card = card;
	}
	/**
	 * gets customer id
	 * @return customerID
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * sets customer id
	 * @param customerId
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * prints a string of customer info
	 * @return string of customer info
	 */
	public String toString() {
		String string = "Customer name " + name + " address " + address + " id " + customerId + "phone " + phoneNumber
				+ " \n " + ((CreditCard) creditCards.get(0)).getNumber();

		return string;
	}

}

