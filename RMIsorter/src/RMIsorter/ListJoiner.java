package RMIsorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author Frank
 *
 */
public class ListJoiner implements Observer {
	
	public int lastThreadNumber = 0;
	public int nThreads;
	public Comparable[] restoredArray;
	
	public ListJoiner(int t){
		this.nThreads = t;
	}
	
	public ListJoiner getListJoiner(){
		
		ListJoiner l = null;
		
		return l;
	}
	
	public int getNextThreadNumber(){
		return lastThreadNumber;
	}
	
	public void join(ArrayList<Comparable[]> c2){
		
		ArrayList<Comparable[]> d = c2;
		List<ArrayList<Comparable[]>> c = Arrays.asList(d);
		this.restoredArray = (Comparable[]) c.toArray();
		
	}
	
	public void printJoinedList(){
		System.out.println(Arrays.asList(restoredArray));
	}
	
	@Override
	public void update(Observable obs, Object o) {
		if (obs instanceof SorterThread) {
			this.lastThreadNumber++;	
		}
		
	}

}
