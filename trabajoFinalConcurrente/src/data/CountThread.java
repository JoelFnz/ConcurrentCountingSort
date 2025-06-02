package data;

public class CountThread extends Thread {
	private int origin;
	private int bound;
	private int[] array;
	//Critical section:
	private static int[] countArray;

	public CountThread(int[] array, int origin, int bound) {
		super();
		this.origin = origin;
		this.bound = bound;
		this.array = array;
	}

	public static void setCountArray(int[] countArray) {
		CountThread.countArray = countArray;
	}

	public void run() {
		int[] localCountArray = new int[countArray.length];
		for(int i = origin; i < bound; i++) {
			localCountArray[array[i]]++;
		}
		
		for(int i = 0; i < countArray.length; i++) {
			synchronized(countArray) {
				countArray[i] += localCountArray[i];
			}
		}
	}
	
}
