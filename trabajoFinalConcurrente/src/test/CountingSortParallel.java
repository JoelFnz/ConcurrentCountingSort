package test;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class CountingSortParallel {

    public static void countingSort(int[] array, int maxValue) {
        int[] count = new int[maxValue + 1];
        Arrays.fill(count, 0);

        // Dividir el arreglo en partes
        int numThreads = 4; // Número de hilos
        int partSize = array.length / numThreads;
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            final int start = i * partSize;
            final int end = (i == numThreads - 1) ? array.length : start + partSize;

            new Thread(() -> {
                for (int j = start; j < end; j++) {
                    count[array[j]]++;
                }
                latch.countDown();
            }).start();
        }

        try {
            latch.await(); // Esperar a que todos los hilos terminen
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Combinar los resultados
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        int maxValue = Arrays.stream(array).max().getAsInt();

        countingSort(array, maxValue);

        System.out.println("Array ordenado: " + Arrays.toString(array));
    }
}
