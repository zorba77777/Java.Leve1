package lesson13;

public class MainHW5 {

    static final int size = 10000000;
    static final int h = size / 2;

    public void firstMetod()
    {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
    }

    public void secondMetod()
    {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++)
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++)
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
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

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
    }

    public void thirdMetod()
    {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(new MyRunnableHW5(a1));
        Thread t2 = new Thread(new MyRunnableHW5(a1));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
    }

    public void forthMetod()
    {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(new MyRunnableHW5(a1));
        Thread t2 = new Thread(new MyRunnableHW5(a1));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
    }

    public static void main(String[] args) {
        MainHW5 les5 = new MainHW5();
        //1. Необходимо написать два метода
        System.out.println("Первый метод");
        les5.firstMetod();
        System.out.println("Второй метод");
        les5.secondMetod();
        System.out.println("Третий метод");
        les5.thirdMetod();
        System.out.println("Четвертый метод");
        les5.forthMetod();
    }

}
