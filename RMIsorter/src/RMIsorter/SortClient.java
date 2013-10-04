package RMIsorter;

import java.io.Serializable;
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
		ISortFactory myServer = null;
		try {
			myServer = (ISortFactory) Naming.lookup("rmi://"
					+ "localhost" + "/RMIsorter");
			ISorter iSort = myServer.createSorter();			
			Comparable[] sortedList = iSort.sort(generateRandomIntegers(10));
			System.out.println(Arrays.asList(sortedList));
			
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
	
	private static Comparable[] generateRandomIntegers(int length) 
	{	
		Comparable[] c= new Comparable[length]; 

		for (int i = 0 ; i < length ; i++) 
		{ 
		c[i] = (int) (Math.random () * 100); 
		}
		System.out.println(Arrays.asList(c));
		
		return c;
		
	}
	
	private Comparable[] generateRandomStrings(int length) {
		String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Comparable[] c = new Comparable[length];
		Random r = new Random();
		for (int j = 0; j < length; j++) {
			StringBuffer randStr = new StringBuffer();
			for (int i = 0; i < r.nextInt(255); i++) {
				int number = r.nextInt(CHAR_LIST.length() + 1);
				if (number - 1 == -1) {
				} else {
					number--;
				}
				randStr.append(CHAR_LIST.charAt(number));
			}
			Comparable tijdelijk = (Comparable) randStr.toString();

			c[j] = tijdelijk;
		}
		System.out.println(Arrays.asList(c));
		return c;
	}
	
	private Comparable[] generateRandomList(int length, Class type) {
		Comparable[] c = null;
		if (type == String.class) {
			c = generateRandomStrings(length);
		} else if (type == Integer.class) {
			c = generateRandomIntegers(length);
		}
		return c;

	}
	
//	private Comparable[] generateRandomUsername(int length) {
//		Comparable[] c = new Comparable[length];
//		Random r = new Random();
//		for (int i = 0; i < length; i++) {
//			StringBuffer temp = new StringBuffer();
//			for (int j = 0; j < 10; j++) {
//				 = r.nextInt(10);
//				temp.append(getallen);
//			}
//			for (int k = 0; k < 5; k++) {
//				int character = r.nextInt(90 - 65) + 65;
//				char letter = (char) character;
//				temp.append(letter);
//			}
//			
//			
//			Username u = new Username();
//			u.username = temp.toString();
//			u.id = id;
//			c[i] = (Comparable) u;
//		}
//		return c;
//	}
//	


}
