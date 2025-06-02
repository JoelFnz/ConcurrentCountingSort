package data;

public class SortThread extends Thread {
	private int minValue;
	private int maxValue;
	private int[] array;
	//Critical section:
	private static int[] countArray;
	private static int[] sortedArray;
	
	public SortThread(int[] array, int minValue, int maxValue) {
		super();
		this.array = array;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public static void setSortedArray(int[] sortedArray) {
		SortThread.sortedArray = sortedArray;
	}
	
	public static void setCountArray(int[] countArray) {
		SortThread.countArray = countArray;
	}
	
	public void run() {
		for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] >= minValue && array[i] <= maxValue) {
                sortedArray[countArray[array[i]] - 1] = array[i];
                countArray[array[i]]--;
            }
        }
	}
}
