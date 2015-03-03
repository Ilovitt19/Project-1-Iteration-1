/**
 *
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010

 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import java.util.*;
import java.text.*;
import java.io.*;
/**
 * UserInterface
 * This class implements the user interface for the Library project.
 * The commands are encoded as integers using a number of
 * static final variables. A number of utility methods exist to
 * make it easier to parse the input.
 *
 */
public class UserInterface {
	private static UserInterface userInterface;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Theater theater;
	private static final int EXIT = 0;
	private static final int ADD_PRODUCER = 1;
	private static final int REMOVE_PRODUCER = 2;
	private static final int LIST_PRODUCERS = 3;
	private static final int ADD_CUSTOMER = 4;
	private static final int REMOVE_CUSTOMER = 5;
	private static final int ADD_CARD = 6;
	private static final int REMOVE_CARD = 7;
	private static final int LIST_CUSTOMERS = 8;
	private static final int ADD_SHOW = 9;
	private static final int LIST_SHOWS = 10;
	private static final int STORE_DATA = 11;
	private static final int HELP = 13;
	/**
	 * Made private for singleton pattern.
	 * Conditionally looks for any saved data. Otherwise, it gets
	 * a singleton Library object.
	 */
	private UserInterface() {
		if (yesOrNo("Look for saved data and  use it?")) {
			retrieve();
		} else {
			theater = Theater.instance();
		}
	}
	/**
	 * Supports the singleton pattern
	 *
	 * @return the singleton object
	 */
	public static UserInterface instance() {
		if (userInterface == null) {
			return userInterface = new UserInterface();
		} else {
			return userInterface;
		}
	}
	/**
	 * Gets a token after prompting
	 *
	 * @param prompt - whatever the user wants as prompt
	 * @return - the token from the keyboard
	 *
	 */
	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}
	/**
	 * Queries for a yes or no and returns true for yes and false for no
	 *
	 * @param prompt The string to be prepended to the yes/no prompt
	 * @return true for yes and false for no
	 *
	 */
	private boolean yesOrNo(String prompt) {
		String more = getToken(prompt + " (Y|y)[es] or anything else for no");
		if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
			return false;
		}
		return true;
	}
	/**
	 * Converts the string to a number
	 * @param prompt the string for prompting
	 * @return the integer corresponding to the string
	 *
	 */
	public int getNumber(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Integer number = Integer.valueOf(item);
				return number.intValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}
	/**
	 * Prompts for a date and gets a date object
	 * @param prompt the prompt
	 * @return the data as a Calendar object
	 */
	public Calendar getDate(String prompt) {
		do {
			try {
				Calendar date = new GregorianCalendar();
				String item = getToken(prompt);
				DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
				date.setTime(dateFormat.parse(item));
				return date;
			} catch (Exception fe) {
				System.out.println("Please input a date as mm/dd/yy");
			}
		} while (true);
	}
	/**
	 * Prompts for a command from the keyboard
	 *
	 * @return a valid command
	 *
	 */
	public int getCommand() {
		do {
			try {
				int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
				if (value >= EXIT && value <= HELP) {
					return value;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Enter a number");
			}
		} while (true);
	}
	/**
	 * Displays the help screen
	 *
	 */
	public void help() {
		System.out.println("Enter a number between 0 and 13 (not 12) as explained below:");
		System.out.println(EXIT + " to Exit\n");
		System.out.println(ADD_PRODUCER + " to add a producer");
		System.out.println(REMOVE_PRODUCER + " to remove producer");
		System.out.println(LIST_PRODUCERS + " to list all producers");
		System.out.println(ADD_CUSTOMER + " to add a customer");
		System.out.println(REMOVE_CUSTOMER + " to remove a cusomer");
		System.out.println(ADD_CARD + " to add a credit card");
		System.out.println(REMOVE_CARD + " to remove a credit card");
		System.out.println(LIST_CUSTOMERS + " to list all customers");
		System.out.println(ADD_SHOW + " to add a show");
		System.out.println(LIST_SHOWS + " to list all shows");
		System.out.println(STORE_DATA + " to  save data");
		System.out.println(HELP + " for help");
	}
	/**
	 * Method to be called for adding a member.
	 * Prompts the user for the appropriate values and
	 * uses the appropriate Library method for adding the member.
	 *
	 */
	public void addProducer() {
		
	}
	
	public void removeProducer() {
		
	}
	
	public void listProducers() {
		
	}
	
	public void addCustomer() {
		String name = getToken("Enter customer name");
		String address = getToken("Enter address");
		String phone = getToken("Enter phone");
		Customer result;
		result = Theater.addCustomer(name, address, phone);
		if (result == null) {
			System.out.println("Could not add member");
		}
		System.out.println(result);
	}
	
	public void removeCustomer() {
		
	}
	
	public void addCreditCard() {
		
	}
	
	public void removeCreditCard() {
		
	}
	
	public void listCustomers() {
		
	}
	
	public void addShow() {
		String title = getToken("Enter show title");
		String producer = getToken("Enter producer");
		String duration = getToken("Enter duration");
		Show result;
		result = Theater.addShow(title, producer, Integer.parseInt(duration));
		if (result == null) {
			System.out.println("Could not add show");
		}
		System.out.println(result);
	}
	
	public void listShows() {
		
	}
	
	

	/**
	 * Method to be called for saving the Library object.
	 * Uses the appropriate Library method for saving.
	 *
	 */
	private void save() {
		if (theater.save()) {
			System.out.println(" The theater has been successfully saved in the file TheaterData \n" );
		} else {
			System.out.println(" There has been an error in saving \n" );
		}
	}
	/**
	 * Method to be called for retrieving saved data.
	 * Uses the appropriate Library method for retrieval.
	 *
	 */
	private void retrieve() {
		try {
			Theater tempTheater = Theater.retrieve();
			if (tempTheater != null) {
				System.out.println(" The theater has been successfully retrieved from the file TheaterData \n" );
				theater = tempTheater;
			} else {
				System.out.println("File doesn't exist; creating new library" );
				theater = Theater.instance();
			}
		} catch(Exception cnfe) {
			cnfe.printStackTrace();
		}
	}
	/**
	 * Orchestrates the whole process.
	 * Calls the appropriate method for the different functionalties.
	 *
	 */
	public void process() {
		int command;
		help();
		while ((command = getCommand()) != EXIT) {
			switch (command) {
				case ADD_PRODUCER:        addProducer();
					break;
				case REMOVE_PRODUCER:         removeProducer();
					break;
				case LIST_PRODUCERS:       listProducers();
					break;
				case ADD_CUSTOMER:      addCustomer();
					break;
				case REMOVE_CUSTOMER:      removeCustomer();
					break;
				case ADD_CARD:       addCreditCard();
					break;
				case REMOVE_CARD:        removeCreditCard();
					break;
				case LIST_CUSTOMERS:       listCustomers();
					break;
				case ADD_SHOW:      addShow();
					break;
				case LIST_SHOWS:  listShows();
					break;
				case STORE_DATA:              save();
					break;
				case HELP:              help();
					break;
			}
		}
	}
	/**
	 * The method to start the application. Simply calls process().
	 * @param args not used
	 */
	public static void main(String[] args) {
		UserInterface.instance().process();
	}
}