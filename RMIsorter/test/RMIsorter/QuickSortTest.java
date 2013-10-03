package RMIsorter;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class QuickSortTest {

	private int[] numbers;
	private final static int SIZE = 7;
	private final static int MAX = 20;

	@Before
	public void setUp() throws Exception {
		numbers = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
	}

	@Test
	public void testNull() throws RemoteException {
		QuickSort quickSorter = new QuickSort();
		quickSorter.quickSort(null, 0, 0);
	}

	@Test
	public void testLeeg() throws RemoteException {
		QuickSort quickSorter = new QuickSort();
		quickSorter.quickSort(new Comparable[0], 0, 0);
	}

	@Test
	public void testSpeciale() throws RemoteException {
		QuickSort quickSorter = new QuickSort();
		Comparable[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
		Comparable[] outcome = quickSorter.quickSort(test, 0, test.length - 1);
		if (!validate(test)) {
			fail("Should not happen");
		}
		printResult(test);
	}

	@Test
	public void testLetters() throws RemoteException {
		QuickSort quickSorter = new QuickSort();
		Comparable[] test = { "a", "A", "Z", "d", "E", "F", "o", "e" };
		Comparable[] outcome = quickSorter.quickSort(test, 0, test.length - 1);
		if (!validate(test)) {
			fail("Should not happen");
		}
		printResult(test);
	}

	@Test
	public void testWoorden() throws RemoteException {
		QuickSort quickSorter = new QuickSort();
		Comparable[] test = { "Hello ", "Hell ", "Hallo ", "Help ", "Halt " };
		Comparable[] outcome = quickSorter.quickSort(test, 0, test.length - 1);
		if (!validate(test)) {
			fail("Should not happen");
		}
		System.out.println(Arrays.asList(outcome));
	}

	private boolean validate(Comparable[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i].compareTo(numbers[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	private void printResult(Comparable[] test) {
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]);
		}
		System.out.println();
	}

	@Test
	public void testCorrect() throws RemoteException {
		QuickSort quickSorter = new QuickSort();
		@SuppressWarnings("rawtypes")
		Comparable[] array = { 5, 8, 3, 200, 57 };
		Comparable[] outcome = quickSorter.quickSort(array, 0, array.length - 1);
		System.out.println("GequickSorteerde array: " + Arrays.asList(array));
		Comparable[] correctArray = { 3, 5, 8, 57, 200 };
		assertArrayEquals(correctArray, array);
	}

	private void assertArrayEquals(Comparable[] correctArray, Comparable[] array) {
		// TODO Auto-generated method stub

	}

}
