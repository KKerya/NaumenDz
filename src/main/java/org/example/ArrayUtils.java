package org.example;

import java.util.Random;

public class ArrayUtils {
    public static int[] generateArray(int size) {
        int[] array = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt();
        }
        return array;
    }

    public static int getMinAbs(int[] array) {
        int minAbs = array[0];
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) < Math.abs(minAbs)) {
                minAbs = array[i];

                if (minAbs == 0)
                    break;
            }
        }
        return minAbs;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print(array[i]);
            } else {
                System.out.print(" " + array[i]);
            }
        }
        System.out.println();
    }
}
