import java.util.Date;


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

public void removeCustomer(String customerId) {
     customerList.remove(customerId);
  }
}