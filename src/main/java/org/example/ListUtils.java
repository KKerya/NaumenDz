package org.example;

import java.util.ArrayList;
import java.util.Random;


class ListUtils {
    public static ArrayList<Double> generateList(int n) {
        ArrayList<Double> list = new ArrayList<>(n);
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rnd.nextDouble());
        }
        return list;
    }

    public static void quickSort(ArrayList<Double> list, int left, int right) {
        if (left < right) {
            int pivot = partition(list, left, right);

            quickSort(list, left, pivot - 1);
            quickSort(list, pivot + 1, right);
        }
    }

    private static int partition(ArrayList<Double> list, int left, int right) {
        double pivot = list.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (list.get(j) <= pivot) {
                i++;
                double temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        double temp = list.get(i + 1);
        list.set(i + 1, pivot);
        list.set(right, temp);

        return i + 1;
    }
}



