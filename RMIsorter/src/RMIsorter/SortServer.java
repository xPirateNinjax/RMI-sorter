package RMIsorter;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class SortServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ISortFactory sf;
		try {
			sf = new SortFactory();
			Naming.bind("//localhost:1099/SortFactory", sf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SortServer() throws RemoteException {
		SortFactory sf = new SortFactory();
	}

}
