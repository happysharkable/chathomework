package classfortesting;

import java.util.Arrays;

public class Main {

    public static int[] getAfterLast(int number, int[] array) {
        int lastPosition = 0;

        for (int i = 0; i < array.length; i++)
            if (array[i] == number) lastPosition = i;

        if (lastPosition == 0) return new int[] {};

        return Arrays.copyOfRange(array, lastPosition + 1, array.length);
    }

    public static boolean ifContains(int number1, int number2, int[] array) {
        int countNumber1 = 0;
        int countNumber2 = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number1) countNumber1++;
            if (array[i] == number2) countNumber2++;
        }

        return countNumber1 != 0 && countNumber2 != 0;
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,4,5,6,4,3,2,4,6,7,8};
        int[] array2 = {1,2,3,4,5,6,7,8,9};

        System.out.println(Arrays.toString(getAfterLast(9, array1)));
        System.out.println(ifContains(1, 4, array2));
    }
}
