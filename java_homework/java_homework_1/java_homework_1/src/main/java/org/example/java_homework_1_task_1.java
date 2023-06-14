package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class java_homework_1_task_1 {
    public static void main(String[] args)
    {
        // Задать одномерный массив и найти в нем минимальный и максимальный элементы;
        Integer[] arr = {76, 23, 0, -4, 87, -13, 6, 8, 3, 5, 1, 9};

        int min_digit = 0;
        int max_digit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                min_digit = arr[0];
                max_digit = arr[0];
            }
            if (arr[i] < min_digit) {
                min_digit = arr[i];
            }
            if (arr[i] > max_digit) {
                max_digit = arr[i];
            }
        }
        System.out.println("Минимальное значение: " + min_digit);
        System.out.println("Максимальное значение: " + max_digit);
    }
}