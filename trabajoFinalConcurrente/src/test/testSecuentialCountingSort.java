package test;

import data.SecuentialCountingSort;

import java.util.Arrays;

import data.ArraysUtil;

public class testSecuentialCountingSort {
	
	public static void main(String[] args) {
		int[] array = new int[10];
		ArraysUtil.fillWithRandomValues(array, 0, 2);
		SecuentialCountingSort sCS = new SecuentialCountingSort(array);
		
		System.out.println("--- SECUENTIAL ---");
		//System.out.println("Unsorted array: " + Arrays.toString(sCS.getArray()));
		System.out.println("Execution time: " + sCS.sort() / 1000000.0 + " ms");
		//System.out.println("Sorted array: " + Arrays.toString(sCS.getArray()));
	}

}
