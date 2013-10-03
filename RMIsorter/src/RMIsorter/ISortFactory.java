package RMIsorter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISortFactory extends Remote {
	
	public ISorter createSorter() throws RemoteException;
	
}
