package test;

import data.ConcurrentCountingSort;
import data.ArraysUtil;

import java.util.Arrays;

public class TestConcurrentCountingSort {
	
	public static void main(String[] args) {
		int[] array = new int[100000000];
		ArraysUtil.fillWithRandomValues(array, 0, 1000000);
		ConcurrentCountingSort cCS = new ConcurrentCountingSort(array);
		long startTime;
		long endTime;
		
		System.out.println("--- CONCURRENT ---");
		//System.out.println("Unsorted array: " + Arrays.toString(cCS.getArray()));
		startTime = System.nanoTime();
		cCS.sort();
		endTime = System.nanoTime();
		System.out.println("Execution time: " + (endTime - startTime) / 1000000.0 + " ms");
		//System.out.println("Sorted array: " + Arrays.toString(cCS.getArray()));
	}
	
}
