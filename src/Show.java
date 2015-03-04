import java.util.Calendar;
import java.util.GregorianCalendar;


public class Show { 
	private String showTitle;
	private String producerId;
	private Calendar date;

	public Show(String showTitle, String producerId, int duration) {
		this.showTitle = showTitle;
		this.producerId = producerId;
		date = new GregorianCalendar();
		date.setTimeInMillis(System.currentTimeMillis());
		date.add(Calendar.DATE, duration);
	}
	
	public String getTitle() {
		return showTitle;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public boolean isValid(){
		return (System.currentTimeMillis() < date.getTimeInMillis());
	}

}
