package HW5;
import java.util.Arrays;

public class Threads {
    private static final int size = 10000000; //размер длинного массива
    private static final int n = 2; // число потоков
    private static final int h = size / n; //размер разделенных массивов
    private static final float[] arr = new float[size]; //одномерный длинный массив

    public static void main(String[] args) {
        Threads hw5 = new Threads();
        hw5.firstArr();
        hw5.secondArr();
    }

    private void secondArr() {
        Thread[] threads = new Thread[n];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis(); //Засекают время выполнения

        float[][] newArr = new float[n][h];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr, i*h, newArr[i], 0, h);
        }

        long split = System.currentTimeMillis();
        System.out.println("Время разделения массива "+ (split - a));

        for(int i=0; i<n; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> calcSecondArr(newArr, finalI));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long concat = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            System.arraycopy(newArr[i], 0, arr, i*h, h);
        }
        long end = System.currentTimeMillis();
        System.out.println("Время склейки массива "+ (end - concat));
        System.out.println("Время выполнения второго метода "+ (end - a));
    }

    private void calcSecondArr(float[][] arr, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < h; i++)
            arr[n][i] = (float) (arr[n][i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения "+(n+1)+"-го потока "+ (end - start));
    }
    private void firstArr() {
       Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения первого метода "+ (end - a));
    }
}