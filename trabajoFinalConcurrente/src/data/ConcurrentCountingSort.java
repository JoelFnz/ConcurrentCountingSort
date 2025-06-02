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

	public void sort() {
		int processors = Runtime.getRuntime().availableProcessors();
		Thread[][] threads = new Thread[processors][3]; 
		//[n][0] tiene FindMaxThreads, [n][1] tiene CountThreads, [n][2] tiene SortThreads. 
		int origin;
		int bound;
		int maxValue;
		int[] countArray;
		int[] sortedArray = new int[array.length];
		
		//Creacion de hilos
		origin = 0;
		for(int i = 0; i < threads.length; i++) {
		    bound = origin + array.length / processors + ((i < array.length % processors) ? 1 : 0);
		    threads[i][1] = new CountThread(array, origin, bound);
		    threads[i][0] = new FindMaxThread(array, origin, bound);
		    threads[i][2] = new SortThread(array, origin, bound);
		    origin = bound;
		}
		
		//Acá comienza la búsqueda del valor máximo
		for(int i = 0; i < processors; i++) {
			threads[i][0].start();
		}
		
		for(int i = 0; i < processors; i++) {
			try {
				threads[i][0].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Creación del arreglo de valores
		countArray = new int[FindMaxThread.getMaxValue() + 1];
		CountThread.setCountArray(countArray);
		
		//Comienza el conteo de apariciones de valores
		for(int i = 0; i < processors; i++) {
			threads[i][1].start();
		}
		
		for(int i = 0; i < processors; i++) {
			try {
				threads[i][1].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		SortThread.setCountArray(countArray);
		SortThread.setSortedArray(sortedArray);
		
		//Proceso acumulativo
		for(int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i-1];
		}
		
		//Comienza el ordenamiento del array
		for(int i = 0; i < processors; i++) {
			threads[i][2].start();
		}

		for(int i = 0; i < processors; i++) {
			try {
				threads[i][2].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/*//Ordenamiento del arreglo
		for(int i = array.length - 1; i >= 0; i--) {
			sortedArray[countArray[array[i]] - 1] = array[i];
			countArray[array[i]]--;
		}*/

		setArray(sortedArray);
	}
	
}
