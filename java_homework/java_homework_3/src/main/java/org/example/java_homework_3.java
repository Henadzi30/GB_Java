package org.example;

import java.util.*;

// import static com.sun.tools.classfile.Module_attribute.RequiresEntry.length;

public class java_homework_3 {
    public static void main(String[] args) {
        // Пусть дан произвольный список целых чисел.

        // 1) Найти максимальное значение
        // 2) Найти минимальное значение
        // 3) Найти среднее значение
        // 4) Нужно удалить из него чётные числа

        List<Integer> workArr = hw(listLens());
        maxList(workArr);
        minList(workArr);
        averageValue(workArr);
        oddValue(workArr);
    }
    public static int listLens() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите размер произвольного списка целых чисел и нажмите <Enter>:");

        String lenList = iScanner.nextLine();
        return Integer.parseInt(lenList);
    }

    public static List<Integer> hw(Integer lenArr) {
        Random random = new Random();

        List<Integer> workList = new ArrayList<>();

        for (int i = 0; i < lenArr; i++) {
            workList.add(random.nextInt(100)); //0-99
        }
        System.out.println("Произвольный массив чисел: " + workList);
        return workList;
    }
    public static void  maxList(List<Integer> integers) {
        // Находим максимальное значение списка
        integers.sort(Comparator.reverseOrder());
        System.out.println("Список произвольных чисел, упорядоченный по убыванию: " + integers);
        System.out.println("1) Максимальный элемент списка произвольных чисел: " + integers.get(0));
    }

    public static void  minList(List<Integer> intgs) {
        // Находим минимальное значение списка

        int min_digit = 0;
        for (int i = 0; i < intgs.size(); i++) {
            if (i == 0) {
                min_digit = intgs.get(0);
            }
            if (intgs.get(i) < min_digit) {
                min_digit = intgs.get(i);
            }
        }
        System.out.println("2) Минимальный элемент списка произвольных чисел: " + min_digit);
    }

    public static void  averageValue(List<Integer> intg) {
        // 3) Находим среднее значение

        int sum_digit = 0;
        for (int i = 0; i < intg.size(); i++) {
            sum_digit += i;
        }
        double avergeVale1 = (double) sum_digit / intg.size();
        System.out.println("3) Среднее значение списка произвольных чисел: " + avergeVale1);
    }

    public static void  oddValue(List<Integer> intgr) {
        // 4) Удаляем из списка четные значения

        Set<Integer> collection = new HashSet<>();
        for (Integer i: intgr) {if (i % 2 != 0) {collection.add(i);}}
        System.out.println("4) Список произвольных чисел с удаленными четными элементами: " + collection);
    }
}