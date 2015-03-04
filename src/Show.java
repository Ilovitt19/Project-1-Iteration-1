import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * stores shows
 *
 */
public class Show { 
	private String showTitle;
	private String producerId;
	private Calendar date;
	/**
	 * constructor for show class
	 * 
	 * @param showTitle
	 * @param producerId
	 * @param duration
	 */
	public Show(String showTitle, String producerId, int duration) {
		this.showTitle = showTitle;
		this.producerId = producerId;
		date = new GregorianCalendar();
		date.setTimeInMillis(System.currentTimeMillis());
		date.add(Calendar.DATE, duration);
	}
	/**
	 * gets show title
	 * @return title
	 */
	public String getTitle() {
		return showTitle;
	}
	/**
	 * gets show date
	 * @return calendar date
	 */
	public Calendar getDate() {
		return date;
	}
	/**
	 * test if date is in range
	 * @return true or false boolean
	 */
	public boolean isValid(){
		return (System.currentTimeMillis() < date.getTimeInMillis());
	}

}
