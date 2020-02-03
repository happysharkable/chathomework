package ru.gb.jtwo.lfive.online;

public class MyThread extends Thread {

    MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println("My thread start");
//        while (!isInterrupted());
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("My Thread end");
    }
}
