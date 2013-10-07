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
	
	private static int range = 1000;

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
		Comparable[] list = generateRandomList(100, Integer.class);
		System.out.println("Ongesorteerde array: " + Arrays.asList(list));
		ISortFactory sf = (ISortFactory) Naming.lookup("SortFactory");
		ISorter sorter = sf.createSorter();
		ArrayList<Comparable[]> c = splice(list);
		ListJoiner lj = new ListJoiner(c.size());
		for (int i = 0; i < c.size(); i++) {

			SorterThread st = new SorterThread(c.get(i), i);
			st.addObserver(lj);
		}

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
			c[i] = (int) (Math.random() * range);
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
	
	public static ArrayList<Comparable[]> splice(Comparable[] splice) {
		ArrayList<Comparable> invoer = new ArrayList<Comparable>(
				Arrays.asList(splice));
		ArrayList<ArrayList<Comparable>> lijst = new ArrayList<ArrayList<Comparable>>();
		
		int aantalDelen = 5;
		int grens = range / aantalDelen;

		for (int k = 0; k < aantalDelen; k++) {
			ArrayList<Comparable> arrayDeel = new ArrayList<Comparable>();
			int bovenGrens = (k + 1) * grens;
			// ArrayList<Comparable> gedeelteVanInvoer = new ArrayList();

			for (int j = 0; j < invoer.size(); j++) {
				if (((Comparable) invoer.get(j)).compareTo(bovenGrens) <= 0) {
					arrayDeel.add(invoer.get(j));
					invoer.remove(j);
					j--;
				}
			}

			lijst.add(arrayDeel);
		}
		return arrayListToArray(lijst);
	}
	
	public static ArrayList<Comparable[]> arrayListToArray(
			ArrayList<ArrayList<Comparable>> lijst) {
		ArrayList<Comparable[]> uitvoer = new ArrayList<Comparable[]>();
		for (int i = 0; i < lijst.size(); i++) {
			uitvoer.add(lijst.get(i).toArray(
					new Comparable[lijst.get(i).size()]));
		}
		return uitvoer;
	}
}
