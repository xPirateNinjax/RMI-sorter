package RMIsorter;

import java.awt.List;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortClient {

	/**
	 * @param args
	 * @author Frank
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException,
			RemoteException, NotBoundException {
		SortClient sc = new SortClient();
		ListJoiner lj = new ListJoiner(0);
		Comparable[] list = generateRandomList(100, Integer.class);
		System.out.println(Arrays.asList(list));
		ISortFactory sf = (ISortFactory) Naming.lookup("SortFactory");
		ISorter sorter = sf.createSorter();
		ArrayList<Comparable[]> c = splice(list);
		for(int i = 0; i < c.size(); i++){
			
				sorter.sort(c.get(i));
				
			
		
		}
		System.out.println(Arrays.asList(c));
//		lj.join(c);
//		lj.printJoinedList();
//		ArrayList<Comparable[]> lists = splice(list);
//		for(@SuppressWarnings("rawtypes") Comparable[] lst : lists) 
//		{
//			ISorter sorter1 = sf.createSorter();
//			Comparable[] result = sorter1.sort(lst);
//			lj.join(result);
//			System.out.println(Arrays.asList(result));
//		} 


	}

	public void sort() {

		Comparable[] intArray = { 1, 2, 56, 23, 56, 37, 28, 67, 87, 12, 34, 54,
				122, 543, 123, 654, 12, 76, 98, 54 };
		ISortFactory myServer;
		try {
			myServer = (ISortFactory) Naming.lookup("rmi://" + "localhost"
					+ "/RMIsorter");
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

	private static Comparable[] generateRandomIntegers(int length) {
		Comparable[] c = new Comparable[length];

		for (int i = 0; i < length; i++) {
			c[i] = (int) (Math.random() * 1000);
		}
		// System.out.println(Arrays.asList(c));

		return c;

	}

	private static Comparable[] generateRandomStrings(int length) {
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
		// System.out.println(Arrays.asList(c));
		return c;
	}

	private static Comparable[] generateRandomList(int length, Class type) {
		Comparable[] c = null;
		if (type == String.class) {
			c = generateRandomStrings(length);
		} else if (type == Integer.class) {
			c = generateRandomIntegers(length);
		} else if (type == Username.class) {
			c = generateRandomUsername(length);

		}
		return c;

	}

	private static Comparable[] generateRandomUsername(int length) {
		Comparable[] c = new Comparable[length];
		Random r = new Random();
		for (int i = 0; i < length; i++) {

			StringBuffer sb = new StringBuffer();
			Comparable[] tempString = generateRandomStrings(length);
			Comparable[] tempInt = generateRandomIntegers(length);

			Username u = new Username();

			sb.append(tempString[i]);
			sb.append(tempInt[i]);

			u.username = (String) tempString[i];
			u.id = (Integer) tempInt[i];

			c[i] = u;

		}
		return c;
	}

	public static ArrayList<Comparable[]> splice(Comparable[] a) {

		ArrayList<Comparable[]> splitArray = new ArrayList<Comparable[]>();
		int aantalDelen = 5;

		for (int i = 0; i < aantalDelen; i++) {
			Comparable[] arrayStuk = null;

			if (i + aantalDelen < a.length) {
				arrayStuk = Arrays.copyOfRange(a, i * (a.length / aantalDelen),
						(i + 1) * (a.length / aantalDelen));

			}

			splitArray.add(arrayStuk);
		}

		for (int i = 0; i < aantalDelen; i++) {
			System.out.printf("[ ");
			for (int k = 0; k < a.length / aantalDelen; k++) {
				System.out.printf(" " + splitArray.get(i)[k] + " ");
			}
			System.out.printf("]\n");
		}

		return splitArray;
	}

}
