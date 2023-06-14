package org.example;

import java.util.Scanner;

public class java_homework_1_task_4 {
    public static void main(String[] args) {
        // ** Написать метод, которому на вход подается одномерный массив и
        // число n (может быть положительным, или отрицательным), при этом
        // метод должен сместить все элементы массива на n позиций. Элементы
        // смещаются циклично. Для усложнения задачи нельзя пользоваться
        // вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
        // при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        // При каком n в какую сторону сдвиг можете выбирать сами.

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите длину массива и нажмите <Enter>:");
        String arrLength = iScanner.nextLine();
        int arLg = Integer.parseInt(arrLength);

        Scanner biScanner = new Scanner(System.in);
        System.out.println("Введите шаг элементов массива и нажмите <Enter>:");
        String incRement = biScanner.nextLine();
        int incrt = Integer.parseInt(incRement);

        Scanner cyScanner = new Scanner(System.in);
        System.out.println("Введите первый элемент массива и нажмите <Enter>:");
        String firstElem = cyScanner.nextLine();
        int fstEl = Integer.parseInt(firstElem);

        Scanner deScanner = new Scanner(System.in);
        System.out.println("Введите величниу смещения элементов массива и нажмите <Enter>:");
        String bias = deScanner.nextLine();
        int bs = Integer.parseInt(bias);

        System.out.println("Исходный массив: ");
        int[] intArrTest=getArraySubsequence(arLg, incrt,fstEl);
        printArray(intArrTest);
        System.out.println("Массив после обработки со смещением на " + bs);
        printArray(getArrayBias(intArrTest,bs));
    }
    public static int[] getArrayBias(int[] arr, int shift) {
        if (shift > 0) {
            for (int s = 1; s <= shift; s++) {
                int elemshift = arr[arr.length - 1];
                for (int i = arr.length - 2; i >= 0; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[0] = elemshift;
            }
        } else if (shift < 0) {
            for (int s = shift; s <= -1; s++) {
                int elemshift = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    arr[i - 1] = arr[i];
                }
                arr[arr.length - 1] = elemshift;
            }
        }
        return arr;
    }
    public static int[] getArraySubsequence(int length, int increment, int firstElem) {
        int[] arr = new int[length];
        arr[0] = firstElem;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + increment;
        }
        return arr;
    }
    public static void printArray(int[] incomArray) {
        for (int item: incomArray) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}

