import java.util.Date;


public class CreditCard {
	private String number;
	private Date expirationDate;
	
	public CreditCard(String number, Date expirationDate) {
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

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
