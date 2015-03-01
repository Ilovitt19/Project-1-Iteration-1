import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;


public class Theater implements Serializable {
	private CustomerList customerList;

	private static Theater theater;
	 
	  private Theater() {
	    
	    customerList = CustomerList.instance();
	  }
	 
	  public static Theater instance() {
	    if (theater == null) {
	    	ProducerIdServer.instance(); // instantiate all singletons
	      return (theater = new Theater());
	    } else {
	      return theater;
	    }
	  }
	
	public void addCreditCard(String customerId, String creditCardNumber, Date expirationDate){
		CreditCard card = new CreditCard(creditCardNumber, expirationDate);
		Customer customer = customerList.search(customerId);
		customer.addCreditCard(card);
	}

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

	
}
