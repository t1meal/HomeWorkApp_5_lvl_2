package root;

public class Main {

    public static void main(String[] args) {

        method2();
    }

    public static void method1(){
        final int size = 5000000;
        final int h = size/2;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int j = 0; j < arr.length; j++){
            arr[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));;
        }
        long b = System.currentTimeMillis();

        System.out.println(b-a);

    }

    public static void method2(){
        final int size = 5000000;
        final int h = size/2;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        float [] a1 = new float[h];


        float [] a2 = new float[h];


        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread th1 = new Thread();

        for (int j = 0; j < a1.length; j++){
            a1[j] = (float)(a1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));;
       }

//        long b = System.currentTimeMillis();
//
//        System.out.println(b-a);

    }
}
