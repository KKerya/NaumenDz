package org.example;

import java.util.Random;

class ArrayUtils{
    private int[] array;

    public ArrayUtils(int size){
        array = new int[size];
        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            array[i] = rnd.nextInt(-1000,1000);
        }
    }

    public int GetMinAbs(){
        int minAbs = array[0];
        for(int i = 1; i < array.length; i++){
            if (Math.abs(array[i]) < Math.abs(minAbs)){
                minAbs = array[i];
            }
        }
        return minAbs;
    }

    public void PrintArray(){
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
