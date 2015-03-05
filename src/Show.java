import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * stores shows
 *
 */
public class Show implements Serializable{
	private static final long serialVersionUID = 1L;
	private String showTitle;
	private String producerId;
	private Calendar date;
	private String start;
	private String end;
	/**
	 * constructor for show class
	 *
	 * @param showTitle
	 * @param producerId
	 * @param duration
	 */
	public Show(String showTitle, String producerId, String start, String end) {
		this.showTitle = showTitle;
		this.producerId = producerId;
		this.start =start;
		this.end=end;
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
	 * @throws ParseException 
	 */
	public boolean isValid() throws ParseException{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = start;
		String dateInString2 = end;
		Date date5 = sdf.parse(dateInString);
		Date date8 = sdf.parse(dateInString2);
		
		return (d.after(date5) && d.before(date8));
	}
	/** 
	 * returns the producerID 
	 */
	public String getProducerId() {
		return producerId;
	}


	/**
	 * Prints string of show info
	 * @return show info
	 */
	public String toString() {
		String string = "Show Title: " + showTitle + " dates: " + date;
		return string;
	}
}
