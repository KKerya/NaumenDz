package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Task1
        System.out.println("Задание 1");
        int n = scanner.nextInt();
        ArrayUtils arrayUtils = new ArrayUtils(n);
        arrayUtils.PrintArray();
        System.out.println(arrayUtils.GetMinAbs());

    }
}
