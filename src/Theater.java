import java.util.Date;
import java.util.Iterator;


public class Theater {
	private CustomerList customerList;

	private static Theater instance = null;
	protected Theater() {

	}
	public static Theater getInstance() {
		if(instance == null) {
			instance = new Theater();
		}
		return instance;
	}

	public Customer addCustomer(String name, String address, String phoneNumber, CreditCard card, String customerId) {
		Customer customer = new Customer(name, address, phoneNumber, card, customerId);
		if (customerList.addCustomer(customer)) {
			return (customer);
		}
		return null;
	}

	public void addCreditCard(String customerId, String creditCardNumber, Date expirationDate){
		CreditCard card = new CreditCard(creditCardNumber, expirationDate);
		Customer customer = customerList.search(customerId);
		customer.addCreditCard(card);
	}
	public void removeCustomer(String customerId) {
		customerList.removeCustomer(customerId);
	}
}