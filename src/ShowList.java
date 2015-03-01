import java.io.Serializable;
import java.util.*;


public class ShowList implements Serializable {
	//private static final long serialVersionUID = 1L;
	private int numItems;
	private List showList = new LinkedList();
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
	      return (showlist = new ShowList());
	    } else {
	      return showlist;
	    }
	  }
	
		  /**
		   * Inserts a book into the collection
		   * @param book the book to be inserted
		   * @return true iff the book could be inserted. Currently always true
		   */
		  public boolean addShow(Show show) {
		    showList.add(show);
		    return true;
		  }
		  /**
		   * Returns an iterator to all books
		   * @return iterator to the collection
		   */
		  public Iterator getShows() {
		    return showList.iterator();
		  }
}
