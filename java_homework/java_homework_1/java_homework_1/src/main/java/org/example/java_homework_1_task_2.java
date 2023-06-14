package org.example;

import java.util.Scanner;

public class java_homework_1_task_2 {
    public static void main(String[] args) {

        // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из
        // диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по
        // следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите размер двумерного квадратного массива и нажмите <Enter>:");

        String x = iScanner.nextLine();

        int num = Integer.parseInt(x);
        int[][] arr = new int[num][num];

        for (int i = 0; i < arr.length; i++) {
            arr[i][arr.length - i - 1] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][i] = 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        iScanner.close();
    }
}
