import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class CustomerList implements Serializable {
	
	 private List customers = new LinkedList();
	 private static CustomerList customerList;
	 
	 
	 private CustomerList() {
	  }
	  
	  public static CustomerList instance() {
	    if (customerList == null) {
	      return (customerList = new CustomerList());
	    } else {
	      return customerList;
	    }
	  }

public boolean addCustomer(Customer customer) {
    customers.add(customer);
    return true;
  }

public void remove(String customerId) {
	for (Iterator iterator = customers.iterator(); iterator.hasNext(); ) {
	      Customer customer = (Customer) iterator.next();
	      if (customer.getCustomerId().equals(customerId)) {
	    	  customers.remove(customer);//this might not work
	    	  
	      }
	}
	
}
private void writeObject(java.io.ObjectOutputStream output) {
    try {
      output.defaultWriteObject();
      output.writeObject(customerList);
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private void readObject(java.io.ObjectInputStream input) {
    try {
      if (customerList != null) {
        return;
      } else {
        input.defaultReadObject();
        if (customerList == null) {
        	customerList = (CustomerList) input.readObject();
        } else {
          input.readObject();
        }
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
 
}
	


