package RMIsorter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISorter extends Remote{

	Comparable[] sort(Comparable[] c) throws RemoteException;


}

	


