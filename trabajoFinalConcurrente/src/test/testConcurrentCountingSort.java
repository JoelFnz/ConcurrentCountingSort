package test;

import data.ConcurrentCountingSort;
import data.ArraysUtil;

import java.util.Arrays;

public class testConcurrentCountingSort {
	
	public static void main(String[] args) {
		int[] array = new int[10];
		ArraysUtil.fillWithRandomValues(array, 0, 2);
		ConcurrentCountingSort cCS = new ConcurrentCountingSort(array);
		
		System.out.println("--- CONCURRENT ---");
		//System.out.println("Unsorted array: " + Arrays.toString(cCS.getArray()));
		System.out.println("Execution time: " + cCS.sort() / 1000000.0 + " ms");
		//System.out.println("Sorted array: " + Arrays.toString(cCS.getArray()));
	}
	
}
