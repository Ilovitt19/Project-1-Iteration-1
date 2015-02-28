import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class CustomerList implements Serializable {
	
	 private List customers = new LinkedList();


public boolean addCustomer(Customer customer) {
    customers.add(customer);
    return true;
  }
}