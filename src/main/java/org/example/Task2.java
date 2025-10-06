package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void run(){
        System.out.println("Задание 2");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Double> list = ListUtils.generateList(n);

        System.out.print("Исходный массив:");
        System.out.println(list);

        ListUtils.quickSort(list, 0, list.size() - 1);

        System.out.print("Отсортированный массив:");
        System.out.println(list);
    }
}

class ListUtils{
    public static ArrayList<Double> generateList(int n){
        ArrayList<Double> list = new ArrayList<>(n);
        Random rnd = new Random();
        for (int i = 0; i < n; i++){
            list.add(rnd.nextDouble(-10000, 10000));
        }

        return list;
    }

    public static void quickSort(ArrayList<Double> list, int left, int right){
        if (left < right){
            int pivot = partition(list, left, right);

            quickSort(list, left, pivot - 1);
            quickSort(list, pivot + 1, right);
        }
    }

    private static int partition(ArrayList<Double> list, int left, int right){
        double pivot = list.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++){
            if (list.get(j) <= pivot){
                i++;
                double temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        double temp = list.get(i+1);
        list.set(i+1, pivot);
        list.set(right,temp);

        return i + 1;
    }
}



