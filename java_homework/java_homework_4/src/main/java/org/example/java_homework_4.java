package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class java_homework_4 {
    public static void main(String[] args) {
        /*
                    Реализовать консольное приложение, которое:
            1. Принимает от пользователя и “запоминает” строки.
            2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
            3. Если введено revert, удаляет предыдущую введенную строку из памяти.
            4. Если введено exit, то программа завершается

            > - ввод в консоль (stdin), < - вывод на консоль (stdout)
            > java
            > python
            > c#
            > print
            < [c#, python, java]
            > revert
            > print
            < [python, java]
            > revert
            > revert
            > print
            < []
            > revert -> throw new NoSuchElementException
         */

        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Используемые комманды:");
        System.out.println("print - вывод строки в консоль;");
        System.out.println("revert - удаление предыдущей введенной строки из памяти");
        System.out.println("exit - завершение программы");

        while (true) {
            System.out.println("Введите строку или команду и нажмите <Enter>:");
            String input = scanner.nextLine();

            if ("exit".equals(input)) {
                break;
            } else if ("print".equals(input)) {
                System.out.println("Строки выведены в порядке, обратном вводу:");
                Collections.reverse(list);
                System.out.println(list);
            } else if (input.equals("revert")) {
                if (!list.isEmpty()) {
                    Collections.reverse(list);
                    list.removeLast();
                    System.out.println("Последняя введенная строка удалена.");
                } else {
                    System.out.println("Нет сохраненных строк для удаления.");
                }
            } else {
                list.add(input);
            }
        }
    }
}
