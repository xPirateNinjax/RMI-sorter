package RMIsorter;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class SortServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortFactory sf;
		try {
			sf = new SortFactory();
			Naming.bind("rmi://" + "localhost" + "/RMIsorter", sf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SortServer() throws RemoteException {
		SortFactory sf = new SortFactory();
	}

}
