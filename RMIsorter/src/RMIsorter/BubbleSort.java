package RMIsorter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author Peter van Meijgaard & Frank Oyevaar
 *
 */
public class BubbleSort extends UnicastRemoteObject implements ISorter{

	@Override
	public Comparable[] sort(Comparable[] sorteerObject) {
		if (sorteerObject ==null || sorteerObject.length==0){
		      return null;
		    }
		boolean gesorteerd = false;
		while(!gesorteerd){
			gesorteerd = true;
			
			for(int i = 0; i < sorteerObject.length - 1; i++){
				if(sorteerObject[i].compareTo(sorteerObject[i + 1]) > 0){
					Comparable temp = sorteerObject[i + 1];
					sorteerObject[i + 1] = sorteerObject[ i ];
					sorteerObject[i] = temp;
					gesorteerd = false;
				}
			}
		}
		
		return sorteerObject;
	}
	
	/**
	 * 
	 * @throws RemoteException
	 */
	protected BubbleSort() throws RemoteException{
		super();
	}

}
