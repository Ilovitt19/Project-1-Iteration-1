import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;


public class ShowList implements Serializable {
	private static final long serialVersionUID = 1L;
	private List shows = new LinkedList();
	private static ShowList showlist;

	private ShowList() {
	}
	/**
	 * Supports the singleton pattern
	 *
	 * @return the singleton object
	 */
	public static ShowList instance() {
		if (showlist == null) {
			return ( showlist = new ShowList());
		} else {
			return showlist;
		}
	}

	/**
	 * Inserts a show into the collection
	 * @param show the show to be inserted
	 * @return true iff the show could be inserted. Currently always true
	 */
	public boolean insertShow(Show show) {
		shows.add(show);
		return true;
	}
	/**
	 * Checks to see if a show matches a certain producer Id;
	 * and also checks to see if the show is playing (by calling isValid())
	 * if the show is found, the method returns the show
	 */
	public Show search(String producerId) throws ParseException {
		for (Iterator iterator = shows.iterator(); iterator.hasNext(); ) {
			Show show = (Show) iterator.next();
			if (show.getProducerId().equals(producerId) && show.isValid()) {
				return show;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	public Show searchTitle(String customerId) throws ParseException {
		for (Iterator iterator = shows.iterator(); iterator.hasNext(); ) {
			Show show = (Show) iterator.next();
			if (show.getTitle().equals(customerId) && show.isValid()) {
				return show;
			}
		}
		return null;
	}
	
	
	
	
	
	
	/**
	 * Returns an iterator to all shows
	 * @return iterator to the collection
	 */
	public Iterator getShows() {
		return shows.iterator();
	}
	/**
	 * writes objects to file
	 * @param output
	 */
	private void writeObject(java.io.ObjectOutputStream output) {
		try {
			output.defaultWriteObject();
			output.writeObject(showlist);
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
	/**
	 * reads file
	 * @param input
	 */
	private void readObject(java.io.ObjectInputStream input) {
		try {
			if (showlist != null) {
				return;
			} else {
				input.defaultReadObject();
				if (showlist == null) {
					showlist = (ShowList) input.readObject();
				} else {
					input.readObject();
				}
			}
		} catch(IOException ioe) {
			System.out.println("in Catalog readObject \n" + ioe);
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	/**
	 * Prints a list of the shows
	 */
	public void listShows(){

		if(shows.isEmpty()){
			System.out.println("No shows available");
		}
		else {
			for (Iterator iterator = shows.iterator(); iterator.hasNext();){
				Show show = (Show)iterator.next();
				System.out.println(show);

			}
		}

	}
	/**
	 * returns string of show info
	 * @return string
	 */
	public String toString() {
		return shows.toString();
	}
}