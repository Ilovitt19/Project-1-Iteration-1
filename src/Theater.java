import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;


public class Theater implements Serializable {
	  public static final int PRODUCER_NOT_FOUND  = 1;
	  //public static final int BOOK_NOT_ISSUED  = 2;
	  //public static final int BOOK_HAS_HOLD  = 3;
	 // public static final int BOOK_ISSUED  = 4;
	 // public static final int HOLD_PLACED  = 5;
	 // public static final int NO_HOLD_FOUND  = 6;
	  public static final int OPERATION_COMPLETED = 7;
	  public static final int OPERATION_FAILED= 8;
	  //public static final int NO_SUCH_MEMBER = 9;
	
	private CustomerList customerList;
	private ShowList showList;
	private ProducerList producerList;
	private static Theater theater;
	

	private Theater() {
		showList = ShowList.instance();
		producerList = ProducerList.instance();
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
	//

	public Producer addProducer(String name, String address, String phone) {
		Producer producer = new Producer(name, address, phone);
	    if (producerList.insertProducer(producer)) {
	      return (producer);
	    }
	    return null;
	  }


	public int removeProducer(String producerId) {
	    Producer producer = theater.search(producerId);
	    if (producer == null) {
	      return(PRODUCER_NOT_FOUND);
	    }
	    if (producerList.removeProducer(producer)) {
	      return (OPERATION_COMPLETED);
	    }
	    return (OPERATION_FAILED);
	}

	public void listProducers() {

	}

	public Customer addCustomer(String name, String address, String phoneNumber, CreditCard card) {
		Customer customer = new Customer(name, address, phoneNumber, card);
		if (customerList.addCustomer(customer)) {
			return (customer);
		}
		return null;
	}

	public void removeCustomer(String customerId) {
		customerList.removeCustomer(customerId);
	}

	public void addCreditCard(String customerId, String creditCardNumber, String expirationDate){
		CreditCard card = new CreditCard(creditCardNumber, expirationDate);
		Customer customer = customerList.search(customerId);
		customer.addCreditCard(card);
	}

	public void removeCreditCard() {

	}

	public void listCustomers() {

	}

	public Show addShow(String title, Producer producer, int duration) {
		Show show = new Show(title, producer, duration);
		if(showList.insertShow(show)) {
			return (show);
		}else{
			return null;
		}
	}

	public void listShows(){
	}

	public static Theater retrieve() {
		try {
			FileInputStream file = new FileInputStream("TheaterData");
			ObjectInputStream input = new ObjectInputStream(file);
			input.readObject();
			CustomerIdServer.retrieve(input);
			return theater;
		} catch(IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
	}

	public static  boolean save() {
		try {
			FileOutputStream file = new FileOutputStream("TheaterData");
			ObjectOutputStream output = new ObjectOutputStream(file);
			output.writeObject(theater);
			output.writeObject(CustomerIdServer.instance());
			return true;
		} catch(IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}

	private void writeObject(java.io.ObjectOutputStream output) {
		try {
			output.defaultWriteObject();
			output.writeObject(theater);
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
	}

	private void readObject(java.io.ObjectInputStream input) {
		try {
			input.defaultReadObject();
			if (theater == null) {
				theater = (Theater) input.readObject();
			} else {
				input.readObject();
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return customerList + "\n" + producerList + "\n" + showList;
	}

}
