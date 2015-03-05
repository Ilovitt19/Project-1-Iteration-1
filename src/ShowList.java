import java.io.IOException;
import java.io.Serializable;
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
	 * @param show the book to be inserted
	 * @return true iff the book could be inserted. Currently always true
	 */
	public boolean insertShow(Show show) {
		shows.add(show);
		return true;
	}
	/**
	 * Returns an iterator to all books
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
	 * returns string of show info
	 * @return string
	 */
	public String toString() {
		return shows.toString();
	}
}
