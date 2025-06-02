package test;

import data.SecuentialCountingSort;

import java.util.Arrays;

import data.ArraysUtil;

public class testSecuentialCountingSort {
	
	public static void main(String[] args) {
		int[] array = new int[100000000];
		ArraysUtil.fillWithRandomValues(array, 0, 100000000);
		SecuentialCountingSort sCS = new SecuentialCountingSort(array);
		long startTime;
		long endTime;
		
		System.out.println("--- SECUENTIAL ---");
		//System.out.println("Unsorted array: " + Arrays.toString(sCS.getArray()));
		startTime = System.nanoTime();
		sCS.sort();
		endTime = System.nanoTime();
		System.out.println("Execution time: " + (endTime - startTime) / 1000000.0 + " ms");
		//System.out.println("Sorted array: " + Arrays.toString(sCS.getArray()));
	}

}
