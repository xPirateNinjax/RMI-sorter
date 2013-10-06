package RMIsorter;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class SortFactory extends UnicastRemoteObject implements ISortFactory {

	Random r = new Random();

	protected SortFactory() throws RemoteException {
		super();
		this.createSorter();

	}

	@Override
	public ISorter createSorter() throws RemoteException {
		if (getRandomBoolean()) {
			QuickSort qs = new QuickSort();
			return qs;
		} else {
			BubbleSort bs = new BubbleSort();
			return bs;
		}

	}

	public boolean getRandomBoolean() {
		return r.nextBoolean();
	}

}
