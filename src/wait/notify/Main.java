package wait.notify;

public class Main extends Thread {

    private static final Object mon = new Object();
    private static volatile char currentChar = 'A';
    private static final int COUNT = 5;

    private static void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < COUNT; i++) {
                    while (currentChar != 'A') {
                        mon.wait();
                    }
                    System.out.print('A');
                    currentChar = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < COUNT; i++) {
                    while (currentChar != 'B') {
                        mon.wait();
                    }
                    System.out.print('B');
                    currentChar = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < COUNT; i++) {
                    while (currentChar != 'C') {
                        mon.wait();
                    }
                    System.out.print('C');
                    currentChar = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> Main.printA());
        Thread t2 = new Thread(() -> Main.printB());
        Thread t3 = new Thread(() -> Main.printC());

        t1.start();
        t2.start();
        t3.start();
    }
}
