package RMIsorter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class SortClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortClient sc = new SortClient();
		sc.sort();

	}
	
	public void sort(){
		
		Integer[] intArray = {1, 2, 56, 23, 56 , 37, 28, 67, 87, 12,
						  34, 54, 122, 543, 123, 654, 12, 76, 98, 54};
		ISortFactory myServer;
		try {
			myServer = (ISortFactory)Naming.lookup("rmi://" + "localhost" + "/RMIsorter");
			ISortFactory sv = (ISortFactory) myServer.createSorter();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Arrays.asList(intArray));
		
	}

}
