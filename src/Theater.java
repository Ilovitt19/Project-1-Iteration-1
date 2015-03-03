import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;


public class Theater implements Serializable {
	private CustomerList customerList;
	private ShowList showList;
	private static Theater theater;
	private ProducerList producerList;

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

	public void addProducer() {

	}

	public void removeProducer() {

	}

	public void listProducers() {

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

	public void addCreditCard(String customerId, String creditCardNumber, Date expirationDate){
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
			MemberIdServer.retrieve(input);
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
			output.writeObject(MemberIdServer.instance());
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
