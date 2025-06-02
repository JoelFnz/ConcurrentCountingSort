package data;

public class ConcurrentCountingSort {
	private int[] array;

	public ConcurrentCountingSort(int[] array) {
		this.array = array;
	}

	public int[] getArray() {
		return array;
	}
	
	public void setArray(int[] array) {
		this.array = array;
	}

	public long sort() {
		int processors = Runtime.getRuntime().availableProcessors();
		CountThread[] cThreads = new CountThread[processors];
		int origin;
		int bound;
		int maxValue;
		int[] countArray;
		int[] sortedArray = new int[array.length];
		long startTime = System.nanoTime();

		origin = 0;
		for(int i = 0; i < cThreads.length; i++) {
		    bound = origin + array.length / processors + ((i < array.length % processors) ? 1 : 0);
		    cThreads[i] = new CountThread(origin, bound);
		    origin = bound;
		}
		
		CountThread.setArray(array);
		
		maxValue = array[0];
		for(int i = 1; i < array.length; i++) {
			if(maxValue < array[i]) {
				maxValue = array[i];
			}
		}
		
		countArray = new int[maxValue + 1];
		CountThread.setCountArray(countArray);
		
		for(int i = 0; i < processors; i++) {
			cThreads[i].start();
		}
		
		for(int i = 0; i < processors; i++) {
			try {
				cThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i-1];
		}

		for(int i = array.length - 1; i >= 0; i--) {
			sortedArray[countArray[array[i]] - 1] = array[i];
			countArray[array[i]]--;
		}

		setArray(sortedArray);
		
		return System.nanoTime() - startTime;
	}
	
}
