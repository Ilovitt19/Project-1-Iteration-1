import java.util.Date;


public class CreditCard {
	private String number;
	private String expirationDate;
	
	public CreditCard(String number, String expirationDate) {
		super();
		this.number = number;
		this.expirationDate = expirationDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
