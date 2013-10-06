package RMIsorter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class QuickSort extends UnicastRemoteObject implements ISorter{
	
	private Comparable[] c;
	
	public QuickSort() throws RemoteException{
		super();
	}

	public Comparable[] sort(Comparable[] comp)  {

		if (comp == null || comp.length == 0)
			throw new IllegalArgumentException("The array can't be empty");
		this.c = comp;
		quickSort(comp, 0, c.length - 1);
		return c;
	}

	public void quickSort(Comparable comparableArray[], int lowIndex,
			int highIndex) {

		if (lowIndex >= highIndex) {
			return;
		}

		int pivotIndex = getMedianIndexAsPivotIndex(lowIndex, highIndex);

		Comparable pivot = comparableArray[pivotIndex];


		swap(comparableArray, pivotIndex, highIndex);

		int i = lowIndex - 1;
		int j = highIndex;

		do {

			do {
				i++;

			} while (comparableArray[i].compareTo(pivot) < 0);

			do {
				j--;
			} while (comparableArray[j].compareTo(pivot) > 0 && (j > lowIndex));

			if (i < j) {
				swap(comparableArray, i, j);
			}

		} while (i < j);

		swap(comparableArray, highIndex, i);



		quickSort(comparableArray, lowIndex, i - 1);
		quickSort(comparableArray, i + 1, highIndex);
	}

	private void swap(Comparable[] comparableArray,
			int firstItem, int secondItem) {

		final Comparable tempItem = comparableArray[firstItem];
		comparableArray[firstItem] = comparableArray[secondItem];
		comparableArray[secondItem] = tempItem;
		c = comparableArray;
	}

	private int getMedianIndexAsPivotIndex(int lowIndex, int highIndex) {
		return lowIndex + ((highIndex - lowIndex) / 2);
	}

}