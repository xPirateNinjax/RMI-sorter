package RMIsorter;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class SortFactory extends UnicastRemoteObject implements ISortFactory {

	protected SortFactory() throws RemoteException {
		super();
		this.createSorter();
	}
	
	@Override
	public ISorter createSorter() throws RemoteException {
		
	QuickSort qs = new QuickSort();
	BubbleSort bs = new BubbleSort();
	return bs;
		
	}
	

}
