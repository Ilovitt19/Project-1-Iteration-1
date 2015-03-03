import java.util.Calendar;
import java.util.GregorianCalendar;


public class Show { 
	private String showTitle;
	private Producer producer;
	private Calendar date;

	public Show(String showTitle, Producer producer, int duration) {
		this.showTitle = showTitle;
		this.producer = producer;
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
