package ru.gb.jtwo.ltwo.online;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {

    private static interface KeyboardListener {
        void keyPressed();
    }

    private static abstract class KeyboardAdapter implements KeyboardListener {
        @Override
        public void keyPressed() { }
    }

    private static void addKeyboardListener(KeyboardListener l) {
        l.keyPressed();
    }

    private static int methodA(int a, int b) {
        return a / b;
    }

    private static class IOStream implements Closeable {
        FileNotFoundException fnfe = new FileNotFoundException("open fail");
        SQLException ioew = new SQLException("write fail");

        public void open() throws FileNotFoundException {
            System.out.println("open");
            //throw fnfe;
        }
        public void write() throws SQLException {
            System.out.println("write");
            throw ioew;
        }

        @Override
        public void close() {
            System.out.println("close");
            throw new NullPointerException("nothing to close");
        }
    }

    public static void main(String[] args) {
        System.out.println(methodA(1, 5));
//        System.out.println(methodA(4, 0));

        try (IOStream ioStream = new IOStream()) {
            ioStream.open();
            ioStream.write();
        } catch (FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void interfaceExample() {
        Human[] humans = { new Minotaur() };
        humans[0].talk();

        Bull[] bulls = { new Minotaur() };
        bulls[0].voice();

        class MyClass implements KeyboardListener {
            @Override
            public void keyPressed() {

            }
        }
        MyClass m = new MyClass();
        addKeyboardListener(m);
        addKeyboardListener(new MyClass());
        addKeyboardListener(new KeyboardListener() {
            @Override
            public void keyPressed() {

            }
        });
        addKeyboardListener(new KeyboardAdapter() {
            @Override
            public void keyPressed() {

            }
        });
        addKeyboardListener( () -> {
            System.out.println("Hello");
        });
    }
}
/*
	 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
	 10 3 1 2
	 2 3 2 2
	 5 6 7 1
	 300 3 1 0
	 Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
	 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
	 3. Ваши методы должны бросить исключения в случаях:
	    Если размер матрицы, полученной из строки, не равен 4x4;
	    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
	 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.

* */
