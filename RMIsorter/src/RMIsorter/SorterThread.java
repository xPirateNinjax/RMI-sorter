package RMIsorter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
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

	public SorterThread(Comparable[] c, int i) {

		this.SorteerThread = new Thread(this);
		this.list = c;
		System.out.println(Arrays.asList(c));
		this.threadNummer = i;
		this.SorteerThread.start();
	}

	@Override
	public void run() {
		try {
			//System.out.println("Thread: " + this.threadNummer + " runt");
			list = sort(list);
			System.out.println("Gesplicde lijst: " + this.threadNummer + " " + Arrays.asList(list));
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

	public Comparable[] getList() {
		return this.list;
	}

}
