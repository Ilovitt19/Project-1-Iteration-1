import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ian on 2/28/2015.
 */
public class Producer implements Serializable {

	private String name;
	private String id;
	private String address;
	private String phone;
	private double balance = 0;
	private static final String PRODUCER_STRING = "P";
	private List showsProduced = new LinkedList();

	public Producer(String name, String address, String phone){

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = PRODUCER_STRING;
		id = PRODUCER_STRING + (ProducerIdServer.instance()).getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void generateID(){
		
	}

}
