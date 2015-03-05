import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Collection of producer objects
 *
 */
public class ProducerList implements Serializable {
	private static final long serialVersionUID = 1L;
	private List producers = new LinkedList();
	private static ProducerList producerList;

	private ProducerList() {

	}
	/**
	 * Private constructor for singleton pattern
	 *
	 */
	public static ProducerList instance() {
		if (producerList == null) {
			return (producerList = new ProducerList());
		} else {
			return producerList;
		}
	}
	/**
	 * Supports the singleton pattern
	 *
	 * @return the singleton object
	 */
	public Producer search(String producerId) {
		for (Iterator iterator = producers.iterator(); iterator.hasNext(); ) {
			Producer producer = (Producer) iterator.next();
			if (producer.getId().equals(producerId)) {
				return producer;
			}
		}
		return null;
	}
	/**
	 * adds a producer to the list
	 * @param producer
	 * @return true or false boolean
	 */
	public boolean insertProducer(Producer producer) {
		producers.add(producer);
		return true;
	}

	public boolean removeProducer(String producerId) {
		Producer producer = search(producerId);
		if (producer == null) {
			return false;
		} else {
			return producers.remove(producer);
		}
	}

	private void writeObject(java.io.ObjectOutputStream output) {
		try {
			output.defaultWriteObject();
			output.writeObject(producerList);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	/**
	 * reads file
	 * @param input
	 */
	private void readObject(java.io.ObjectInputStream input) {
		try {
			if (producerList != null) {
				return;
			} else {
				input.defaultReadObject();
				if (producerList == null) {
					producerList = (ProducerList) input.readObject();
				} else {
					input.readObject();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return producers.toString();
	}
}

