package RMIsorter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;

/**
 * 
 * @author Frank
 * 
 */

public class SorterThread extends Observable implements Runnable {
	private Thread SorteerThread;
	private Comparable[] list;
	private int threadNummer;

	public SorterThread(Comparable[] c) {

		this.SorteerThread = new Thread(this);
		this.list = c;
		this.SorteerThread.start();
	}

	@Override
	public void run() {
		try {
			list = sort(list);
			setChanged();
			notifyObservers();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getThreadNumber() {
		return threadNummer;
	}

	public Comparable[] sort(Comparable[] c) throws RemoteException, MalformedURLException, NotBoundException {
		ISortFactory sf = (ISortFactory) Naming
				.lookup("rmi://localhost/SortFactory");
		ISorter sorter = sf.createSorter();
		Comparable[] sortedList = sorter.sort(c);
		
		return sortedList;
	}

}
