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
	
	private int lastThreadNumber = 0;
	private int nThreads;
	private Comparable[][] list;
	private Comparable[] restoredArray;
	
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
	
	public void join(Comparable[][] a){
		ArrayList<Comparable> c = new ArrayList<Comparable>();
		for (int k = 0; k < a.length; k++) {
			for (int l = 0; l < a[k].length; l++) {
				c.add(a[k][l]);
			}
		}
		restoredArray =	c.toArray(new Comparable[c.size()]);
		
//		ArrayList<Comparable[]> d = a;
//		List<ArrayList<Comparable[]>> c = Arrays.asList(d);
//		this.restoredArray = (Comparable[]) c.toArray();
		
	}
	
	public void printJoinedList(){
		System.out.println(Arrays.asList(restoredArray));
	}
	
	@Override
	public void update(Observable obs, Object o) {
		if (obs instanceof SorterThread) {
			Comparable[] sortedList = ((SorterThread) obs).getList();
			list[((SorterThread) obs).getThreadNumber()] = sortedList;
			this.lastThreadNumber++;	
			if (lastThreadNumber == nThreads) {
				join(list);
				printJoinedList();
			}
		}
		
	}

}
