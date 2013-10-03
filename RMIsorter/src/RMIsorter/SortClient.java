package RMIsorter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Random;

public class SortClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortClient sc = new SortClient();
		sc.generateRandomIntegers(10000);

	}
	
	public void sort(){
		
		Comparable[] intArray = {1, 2, 56, 23, 56 , 37, 28, 67, 87, 12,
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
	
	private Comparable[] generateRandomIntegers(int length) 
	{	
		Comparable[] c= new Comparable[length]; 

		for (int i = 0 ; i < length ; i++) 
		{ 
		c[i] = (int) (Math.random () * 100); 
		}
		System.out.println(Arrays.asList(c));
		
		return c;
		
	}
	
	private Comparable[] generateRandomStrings(int length) 
	{
		Comparable[] c= new Comparable[length]; 

		return c;
		
		 Random r = new Random(); // perhaps make it a class variable so you don't make a new one every time
		 
		 StringBuilder sb = new StringBuilder();
		    for(int i = 0; i < length; i++) {
		        c[i] = (char)(r.nextInt((int)(Character.MAX_VALUE)));
		        sb.append(c);
		    }
		    System.out.println(Arrays.asList(c));
	}



}
