/**
 * Java. Level 2* Lesson 5. Homework 5.
 *
 * @author Petrov Nikolay
 * @version dated Jan 18, 2019
 */

import java.util.Arrays;
public class Homework5 {
    final int SIZE = 10000000;
    final int HALF_SIZE = SIZE / 2;
    float testA65;

    public static void main(String[] args) {
        Homework5 HW5 = new Homework5();
        HW5.doWithoutThreads();
        HW5.doWithThreads();
    }

    void doWithoutThreads() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1); // filling the array
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++)
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        System.out.println("Время работы первого метода:" + (System.currentTimeMillis() - a));
    }

    void doWithThreads() {
        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF_SIZE];
        float[] a2 = new float[HALF_SIZE];

        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, a2, 0, HALF_SIZE);
        Thread one = new Thread(new CalcArray(a1, 0));
        Thread two = new Thread(new CalcArray(a2, HALF_SIZE));
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(a2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println("Время работы второго метода:" + (System.currentTimeMillis() - a));

    }
}
class CalcArray implements Runnable {
    private float[] array;
    private int shift;

    CalcArray(float[] array, int shift) {
        this.array = array;
        this.shift = shift;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++)
            array[i] = (float)(array[i] *
                    Math.sin(0.2f + (i + shift) / 5) *
                    Math.cos(0.2f + (i + shift) / 5) *
                    Math.cos(0.4f + (i + shift) / 2));
    }
}
