package data;

public class FindMaxThread extends Thread {
	private int origin;
	private int bound;
	private int[] array;
	//Critical section:
	private static Object monitor = new Object();
	private static int maxValue;
	
	public FindMaxThread(int[] array, int origin, int bound) {
		super();
		this.origin = origin;
		this.bound = bound;
		this.array = array;
	}
	
	public static int getMaxValue() {
		return maxValue;
	}
	
	public void run() {
		int localMax = array[origin];
		for(int i = origin + 1; i < bound; i++) {
			if(localMax < array[i]) {
				localMax = array[i];
			}
		}
		
		synchronized(monitor) {
			if(localMax > maxValue) {
				maxValue = localMax;
			}
		}
	}
}
