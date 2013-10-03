package RMIsorter;



import java.util.Arrays;

public class QuickSort implements ISorter {

	public static Comparable[] quickSort (Comparable comparableArray[], int lowIndex, int highIndex){
		
		if (lowIndex>=highIndex){
			return null;
		}
	
		int pivotIndex=getMedianIndexAsPivotIndex(lowIndex, highIndex);
		Comparable pivot=comparableArray[pivotIndex];
		swapItemsWithIndices(comparableArray, pivotIndex, highIndex); 	
 
		int i=lowIndex-1;
		int j=highIndex;
		
		do{ 
			

			do {i++;} while (comparableArray[i].compareTo(pivot)<0);
 
			//So, add extra condition to prevent 'j' from overflowing outside the current sub array
			do {j--;} while (comparableArray[j].compareTo(pivot)>0 &&(j>lowIndex));
			
			if (i<j){
				swapItemsWithIndices(comparableArray, i, j);
			}
			System.out.println("I :"+i + " J :"+j);
		} while (i<j);
		
		swapItemsWithIndices(comparableArray, highIndex, i);//bring pivot to i's position	
		System.out.println("Comparable array : "+Arrays.asList(comparableArray));
		
		
		//the big subarray is partially sorted (agrees to invariant). Let's recurse and bring in more hands
		
		quickSort(comparableArray, lowIndex, i-1); //sort subarray between low index and one before the pivot
		quickSort(comparableArray, i+1, highIndex);
		
		return comparableArray;
	}
	
	private static void swapItemsWithIndices(Comparable[] comparableArray, int firstItem, int secondItem) {
		final Comparable tempItem=comparableArray[firstItem];
		comparableArray[firstItem]=comparableArray[secondItem];
		comparableArray[secondItem]=tempItem;		
	}
	
	private static int getMedianIndexAsPivotIndex(int lowIndex, int highIndex) {
		return lowIndex+((highIndex-lowIndex)/2);
	}

	@Override
	public Comparable[] sort(Comparable[] values) {
		// TODO Auto-generated method stub
		return null;
	}



}
