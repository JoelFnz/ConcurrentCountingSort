package data;

public class SecuentialCountingSort {
	private int[] array;

	public SecuentialCountingSort(int[] array) {
		this.array = array;
	}
	
	public int[] getArray() {
		return array;
	}
	
	public void setArray(int[] array) {
		this.array = array;
	}
	
	public void sort() {
		int maxValue;
		int[] countArray;
		int[] sortedArray = new int[array.length];
		
		maxValue = array[0];
		for(int i = 0; i < array.length; i++) {
			if(maxValue < array[i]) {
				maxValue = array[i];
			}
		}

		countArray = new int[maxValue + 1];
		
		for(int i = 0; i < array.length; i++) {
			countArray[array[i]]++;
		}
		
		for(int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i - 1]; 
		}
		
		for(int i = array.length - 1; i >= 0; i--) {
			sortedArray[countArray[array[i]] - 1] = array[i];
			countArray[array[i]]--;
		}
		
		setArray(sortedArray);
	}
}
