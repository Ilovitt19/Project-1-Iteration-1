import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;


public class Theater implements Serializable {
	private CustomerList customerList;

	private static Theater instance = null;
	protected Theater() {
	private static Theater theater;


	public Customer addCustomer(String name, String address, String phoneNumber, CreditCard card, String customerId) {
		Customer customer = new Customer(name, address, phoneNumber, card, customerId);
		if (customerList.addCustomer(customer)) {
			return (customer);
		}
		return null;
	}

	public void removeCustomer(String customerId) {
		customerList.removeCustomer(customerId);
	}
	private Theater(){
		customerList = CustomerList.instance();
	}

	public static Theater instance(){
		if (theater == null){
			CustomerIdServer.instance();
			ProducerIdServer.instance();
			return (theater = new Theater());
		}
		else {
			return theater;
		}
	

	
  	}

	
}
