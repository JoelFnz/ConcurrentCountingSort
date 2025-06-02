package data;

public class CountThread extends Thread {
	private int origin;
	private int bound;
	private int[] localCountArray;
	//Critical section:
	private static int[] countArray;
	private static int[] array;
	
	public CountThread(int origin, int bound) {
		super();
		this.origin = origin;
		this.bound = bound;
	}

	public int getOrigin() {
		return origin;
	}

	public int getBound() {
		return bound;
	}

	public static int[] getArray() {
		return array;
	}

	public static void setArray(int[] array) {
		CountThread.array = array;
	}

	public static int[] getCountArray() {
		return countArray;
	}

	public static void setCountArray(int[] countArray) {
		CountThread.countArray = countArray;
	}

	public void run() {
		localCountArray = new int[countArray.length];
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
