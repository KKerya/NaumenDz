package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1{
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 1");
        int n = scanner.nextInt();
        int[] array = ArrayUtils.generateArray(n);
        ArrayUtils.printArray(array);
        System.out.println(ArrayUtils.getMinAbs(array));
    }
}

class ArrayUtils{
    public static int[] generateArray(int size){
        int[] array = new int[size];
        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            array[i] = rnd.nextInt(-10000,10000);
        }
        return array;
    }

    public static int getMinAbs(int[] array){
        int minAbs = array[0];
        for(int i = 1; i < array.length; i++){
            if (Math.abs(array[i]) < Math.abs(minAbs)){
                minAbs = array[i];
            }
        }
        return minAbs;
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            if (i == 0) {
                System.out.print(array[i]);
            }
            else{
                System.out.print(" " + array[i]);
            }
        }
        System.out.println();
    }

}
