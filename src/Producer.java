import java.io.Serializable;

/**
 * Created by Ian on 2/28/2015.
 */
public class Producer implements Serializable {

	private String name;
	private String id;
	private String address;
	private String phone;
	private double balance = 0;
	private static final String CUSTOMER_STRING = "C";

	public Producer(String name, String address, String phone){

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = CUSTOMER_STRING;

	}
}
