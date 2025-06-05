package test;

import java.util.Arrays;

import data.ArraysUtil;
import data.ConcurrentCountingSort;
import data.SecuentialCountingSort;

public class TestComparativo {
	
	public static void main(String[] args) {
		long endTime;
		long startTime;
		ConcurrentCountingSort cCS;
		SecuentialCountingSort sCS;
		int[] array = new int[100000000];
		
		ArraysUtil.fillWithRandomValues(array, 0, 1000000);
		cCS = new ConcurrentCountingSort(Arrays.copyOf(array, array.length));
		sCS = new SecuentialCountingSort(array);
		
		/*startTime = System.nanoTime();
		cCS.sort();
		endTime = System.nanoTime();
		System.out.println("Concurrent: " + (endTime - startTime) / 1000000.0 + " ms");
		cCS.setArray(null);
		
		startTime = System.nanoTime();
		sCS.sort();
		endTime = System.nanoTime();
		System.out.println("Secuential: " + (endTime - startTime) / 1000000.0 + " ms");*/
		
		startTime = System.nanoTime();
		sCS.sort();
		endTime = System.nanoTime();
		System.out.println("Secuential: " + (endTime - startTime) / 1000000.0 + " ms");
		array = null;
		
		startTime = System.nanoTime();
		cCS.sort();
		endTime = System.nanoTime();
		System.out.println("Concurrent: " + (endTime - startTime) / 1000000.0 + " ms");
		
	}
}
