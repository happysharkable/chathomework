package ru.gb.jtwo.lfive.online;

public class ThreadMain {

    private static long a;
    private static long b;
    private static long c;
    static Object monitor = new Object();

    private synchronized static void incAllVars() {
        for (int i = 0; i < 1_000_000; i++) {
            a = a + 1;
            b = b + 1;
            c = c + 1;
        }
        String vars = String.format("a = %d, b = %d, c = %d", a, b, c);
        System.out.println(vars);
    }

    private static void incAllVars2() {
        synchronized (monitor) {
            for (int i = 0; i < 1_000_000; i++) {
                a = a + 1;
                b = b + 1;
                c = c + 1;
            }
            String vars = String.format("a = %d, b = %d, c = %d", a, b, c);
            System.out.println(vars);
        }
    }

    public static void main(String[] args) {
        Runnable r0 = new Runnable() {
            @Override
            public void run() {
                incAllVars();
            }
        };

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                incAllVars2();
            }
        };

        new Thread(r0, "Thread #1").start();
        new Thread(r0, "Thread #2").start();
        new Thread(r0, "Thread #3").start();
        new Thread(r1, "Thread #11").start();
        new Thread(r1, "Thread #12").start();
        new Thread(r1, "Thread #13").start();

    }

    private static void interruptJoinEx() {
        System.out.println(Thread.currentThread().getName() + " start");
        MyThread t1 = new MyThread("MyThread-1");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main end");
    }

    private static void runnableEx() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("MyRunnable");
            }
        };
        Thread t0 = new Thread(r, "My-Thread-0");
        t0.start();
    }
}
