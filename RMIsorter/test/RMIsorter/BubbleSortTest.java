package RMIsorter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {
	@SuppressWarnings("rawtypes")
	private Comparable[] numbers;
	private final static int SIZE = 7;
	private final static int MAX = 20;

	@Before
	public void setUp() throws Exception {
		numbers = new Comparable[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
	}

	@Test
	public void testNull() throws RemoteException {
		BubbleSort sorter = new BubbleSort();
		sorter.sort(null);
	}
	
	@Test
	public void testLeeg() throws RemoteException {
		BubbleSort sorter = new BubbleSort();
		sorter.sort(new Comparable[0]);
	}
	
	@Test
	public void testCorrect() throws RemoteException {
		BubbleSort sorter = new BubbleSort();
		@SuppressWarnings("rawtypes")
		Comparable[] array = {5, 8, 3, 200, 57};
		for(int i = 0; i < array.length; i++){
			System.out.println("Ongesorteerde array: " + array[i]);
			}
		sorter.sort(array);
		for(int i = 0; i < array.length; i++){
		System.out.println("Gesorteerde array: " + array[i]);
		}
		Comparable[] correctArray = {3, 5, 8, 57, 200};
		assertArrayEquals(correctArray, array);	
	}
	
	@Test
	public void testSpecial() throws RemoteException {
		BubbleSort sorter = new BubbleSort();
	    Comparable[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
	    sorter.sort(test);
	    if (!validate(test)) {
	      fail("Should not happen");
	    }
	    printResult(test);
	  }
	
	@Test
	public void testLetters() throws RemoteException{
		BubbleSort sorter = new BubbleSort();
		Comparable[] test = { "a", "A", "Z", "d", "E", "F", "o", "e" };
		sorter.sort(test);
		if(!validate(test)){
			fail("Should not happen");
		}
		printResult(test);
	}

	@Test
	public void testWoorden() throws RemoteException{
		BubbleSort sorter = new BubbleSort();
		Comparable[] test = { "Hello ","Hell ","Hallo ","Help ","Halt " };
		sorter.sort(test);
		if(!validate(test)){
			fail("Should not happen");
		}
		printResult(test);
	}
	
	
	private boolean validate(Comparable[] numbers) {
	    for (int i = 0; i < numbers.length - 1; i++) {
	      if (numbers[i].compareTo(numbers[i + 1]) > 0) {
	        return false;
	      }
	    }
	    return true;
	  }
	
	private void printResult(Comparable[] numbers) {
	    for (int i = 0; i < numbers.length; i++) {
	      System.out.print(numbers[i]);
	    }
	    System.out.println();
	  }
}