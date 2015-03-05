import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;


public class Theater implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int PRODUCER_NOT_FOUND  = 1;
	public static final int CUSTOMER_NOT_FOUND  = 2;
	public static final int CREDIT_CARD_NOT_FOUND  = 3;
	public static final int ONLY_CREDIT_CARD = 4;
	public static final int SHOW_PLAYING  = 5;
	public static final int OPERATION_COMPLETED = 7;
	public static final int OPERATION_FAILED= 8;

	private CustomerList customerList;
	private ShowList showList;
	private ProducerList producerList;
	private static Theater theater;

	/**
	 * Constructor to instantiate the three lists
	 */
	private Theater() {
		showList = ShowList.instance();
		producerList = ProducerList.instance();
		customerList = CustomerList.instance();
	}
	//Singleton property
	public static Theater instance() {
		if (theater == null) {
			ProducerIdServer.instance(); // instantiate all singletons
			return (theater = new Theater());
		} else {
			return theater;
		}
	}

	/**
	 * Method to add a producer to the ProducerList
	 * @param name name of producer
	 * @param address address of producer
	 * @param phone phone number of producer
	 * @return
	 */
	public Producer addProducer(String name, String address, String phone) {
		Producer producer = new Producer(name, address, phone);
		if (producerList.insertProducer(producer)) {
			return (producer);
		}
		return null;
	}

	/**
	 * Method to remove a producer with given Id
	 * @param producerId the Id of the producer to be removed
	 * @return
	 */
	public int removeProducer(String producerId) {
		Producer producer = producerList.search(producerId);
		Show show = showList.search(producerId);
		if (show != null) {
			return(SHOW_PLAYING);
		}
		if (producer == null) {
			return(PRODUCER_NOT_FOUND);
		}
		if (producerList.removeProducer(producerId)) {
			return (OPERATION_COMPLETED);
		}
		return (OPERATION_FAILED);
	}

	/**
	 * Method to get and print a list of producers from ProducerList
	 */
	public void listProducers() {
		producerList.listProducers();
	}

	/**
	 * Method to add a customer to the customer list
	 * @param name Customer's name
	 * @param address Customer's address
	 * @param phoneNumber customer's phone number
	 * @param card customer's initial credit card
	 * @return
	 */
	public Customer addCustomer(String name, String address, String phoneNumber, CreditCard card) {
		Customer customer = new Customer(name, address, phoneNumber, card);
		if (customerList.addCustomer(customer)) {
			return (customer);
		}
		return null;
	}

	/**
	 * Method to remove a customer with the given id
	 * @param customerId The ID of customer to remove
	 * @return
	 */
	public int removeCustomer(String customerId) {
		Customer customer = customerList.search(customerId);
		if (customer == null) {
			return(CUSTOMER_NOT_FOUND);
		}
		if (customerList.removeCustomer(customerId)) {
			return (OPERATION_COMPLETED);
		}
		return (OPERATION_FAILED);
	}

	/**
	 * Method to add a credit card to a user
	 * @param customerId Id of customer to add to
	 * @param creditCardNumber credit card number to add
	 * @param expirationDate expiration date of card
	 * @return
	 */
	public Customer addCreditCard(String customerId, String creditCardNumber, String expirationDate){
		CreditCard card = new CreditCard(creditCardNumber, expirationDate);
		if (customerList.search(customerId) != null) {
			Customer customer = customerList.search(customerId);
			customer.addCreditCard(card);
			return (customer);
		}
		return null;
	}

	/**
	 * Method to remove a credit card from a user
	 * @param customerId Id of customer to remove from
	 * @param cardNumber Credit Card number
	 * @return
	 */
	public int removeCreditCard(String customerId, String cardNumber) {
		Customer customer = customerList.search(customerId);
		CreditCard card = customer.searchCreditCard(cardNumber);
		if (card == null) {
			return(CREDIT_CARD_NOT_FOUND);
		}
		if ( customer.cardListSize() == 1) {
			return ( ONLY_CREDIT_CARD );
		}
		if ( customer.removeCreditCard(cardNumber) ) {
			return (OPERATION_COMPLETED);
		}
		return (OPERATION_FAILED);
	}

	/**
	 * Method to get and print a list of customers from CustomerList
	 */
	public void listCustomers() {
		customerList.listCustomers();
	}

	/**
	 * Method to add a show to ShowList
	 * @param title the title of the show
	 * @param producerId ID of the show producer
	 * @param duration
	 * @return
	 */
	public Show addShow(String title, String producerId, String start, String end) {
		Show show = new Show(title, producerId, start, end);
		if(showList.insertShow(show)) {
			return (show);
		}else{
			return null;
		}
	}

	/**
	 * Method to get and print a list of shows from ShowList
	 */
	public void listShows(){
		showList.listShows();
	}

	/**
	 * Fetches data from the disk to be loaded
	 * @return
	 */
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

	/**
	 * Saves Theater data to disk
	 * @return
	 */
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

	/**
	 * Writes Theater data to disk
	 * @param output
	 */
	private void writeObject(java.io.ObjectOutputStream output) {
		try {
			output.defaultWriteObject();
			output.writeObject(theater);
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
	}

	/**
	 * Reads Theater data from disk
	 * @param input
	 */
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
