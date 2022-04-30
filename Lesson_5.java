package HomeWork_Java_lvl_2;

import java.util.Arrays;

public class Lesson_5 {

    public static void main(String[] args) throws InterruptedException {
        doArray();
        doArray2();
    }

    public static void doArray() throws InterruptedException {
        MyThread thread1 = new MyThread();
        thread1.start();
        thread1.join();
    }

    public static void doArray2() throws InterruptedException {
        MyThread2 thread2 = new MyThread2();
        thread2.start();
        thread2.join();
    }
}

class MyThread extends Thread {
    public void run() {
        final int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0F);

        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finish = System.currentTimeMillis();
        long result = (finish - start) / 1000;
        System.out.println("Время просчета первого метода = " + result + " секунд");
    }
}

class MyThread2 extends Thread {

    public void run() {
        final int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0F);
        final int h = size / 2;
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        timerStart();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerStop("Разбивка заняла ");

        timerStart();
        for (int i = 0; i < a1.length; i++) {
            a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerStop("Просчет массива а1 занял ");

        timerStart();
        for (int i = 0; i < a2.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerStop("Просчет массива a2 занял ");

        timerStart();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerStop("Склейка заняла ");
    }

    static long timerStart() {
        return System.currentTimeMillis();
    }

    static void timerStop(String msg) {
        long finish = System.currentTimeMillis();
        long result = finish - timerStart();
        System.out.println(msg + result + " секунд");
    }
}

