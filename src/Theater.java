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
	

public Customer addMember(String name, String address, String phoneNumber, int creditCardNumber, Date creditCardExpiration, int customerId) {
    Customer customer = new Customer(name, address, phoneNumber, creditCardNumber, creditCardExpiration, customerId);
    if (customerList.addCustomer(customer)) {
      return (customer);
    }
    return null;
  }
}