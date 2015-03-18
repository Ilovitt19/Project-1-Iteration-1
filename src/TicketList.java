import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class TicketList {
	private static final long serialVersionUID = 1L;

	private List tickets = new LinkedList();
	private static TicketList ticketList;

	private TicketList() {
	}
	/**
	 * Supports the singleton pattern
	 *
	 * @return the singleton object
	 */
	public static TicketList instance() {
		if ( ticketList == null ) {
			return ( ticketList = new TicketList() );
		} else {
			return ticketList;
		}
	}

	public boolean insertShow(Ticket ticket) {
		tickets.add(ticket);
		return true;
	}

	public Ticket search(String date) throws ParseException {
		for (Iterator iterator = tickets.iterator(); iterator.hasNext(); ) {
			Ticket show = ( Ticket ) iterator.next();
			if ( show.getDate().equals( date ) ) {
				return show;
			}
		}
		return null;
	}

	public Iterator getShows() {
		return tickets.iterator();
	}

	private void writeObject(java.io.ObjectOutputStream output) {
		try {
			output.defaultWriteObject();
			output.writeObject(ticketList);
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
	}

	private void readObject(java.io.ObjectInputStream input) {
		try {
			if (ticketList != null) {
				return;
			} else {
				input.defaultReadObject();
				if (ticketList == null) {
					ticketList = (TicketList) input.readObject();
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
	public void listTickets(String date){

		if(tickets.isEmpty()){
			System.out.println("No tickets available");
		}
		else {
			System.out.println("Tickets Prchased: ");
			for (Iterator iterator = tickets.iterator(); iterator.hasNext();){
				Ticket ticket = (Ticket)iterator.next();
				
				if(ticket.getDate().equals((date))) {
					//System.out.println("Tickets Prchased: ");
					System.out.println(ticket);
				}
			}
		}



	}
	/**
	 * returns string of show info
	 * @return string
	 */
	public String toString() {
		return tickets.toString();
	}
}
