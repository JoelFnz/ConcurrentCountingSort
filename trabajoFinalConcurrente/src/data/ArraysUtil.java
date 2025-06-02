package data;

import java.util.Random;

public class ArraysUtil {
	private ArraysUtil() {
		
	}
	
	public static void fillWithRandomValues(int[] array, int minValue, int maxValue) {
		Random rand = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(minValue, maxValue);
		}
	}
	
}
