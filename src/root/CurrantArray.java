package root;

import java.util.Arrays;

public class CurrantArray {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public CurrantArray() {
        Arrays.fill(arr, 1);
    }

    public void sync (){
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Операция заняла: " + end);
    }

    public void aSync (){
        long start = System.currentTimeMillis();

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calc(arr1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calc(arr2);
            }
        });

        t1.start();
        t2.start();

        try {
           t1.join();
           t2.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        merge(arr1, arr2);
//

        long end = System.currentTimeMillis() - start;
        System.out.println("Операция заняла: " + end);
    }

    public synchronized void calc(float[] arr){
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
    }

    public synchronized void merge(float [] arr1, float[] arr2){
            System.arraycopy(arr1, 0, arr, 0, h);
            System.arraycopy(arr2, 0, arr, h, h);
    }
}

