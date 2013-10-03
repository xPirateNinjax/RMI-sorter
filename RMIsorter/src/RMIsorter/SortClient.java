package RMIsorter;

import java.util.Arrays;

public class SortClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortClient sc = new SortClient();
		sc.sort();

	}
	
	public void sort(){
		
		int[] intArray = {1, 2, 56, 23, 56 , 37, 28, 67, 87, 12,
						  34, 54, 122, 543, 123, 654, 12, 76, 98, 54};
				
		System.out.println(Arrays.asList(intArray));
		
	}

}
