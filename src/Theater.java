import java.io.Serializable;
import java.util.Date;


public class Theater implements Serializable {
	private CustomerList customerList;
	private static Theater theater;


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

	public Customer addCustomer(String name, String address, String phoneNumber, String creditCardNumber, Date creditCardExpiration, String customerId) {
    	Customer customer = new Customer(name, address, phoneNumber, creditCardNumber, creditCardExpiration, customerId);
    	if (customerList.addCustomer(customer)) {
      		return (customer);
    	}
    	return null;
  	}

	public void removeCustomer(String customerId) {
     	customerList.remove(customerId);
  }
}