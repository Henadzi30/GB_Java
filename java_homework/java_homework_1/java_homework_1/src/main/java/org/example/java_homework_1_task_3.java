package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;


public class java_homework_1_task_3 {
    public static void main(String[] args) { // diagonal(int x, int y) {

        // В консоли запросить имя пользователя. В зависимости от текущего времени,
        // вывести приветствие вида:
        //"Доброе утро, <Имя>!", если время от 05:00 до 11:59
        //"Добрый день, <Имя>!", если время от 12:00 до 17:59;
        //"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        //"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя и нажмите <Enter>:");

        String name = iScanner.nextLine();

        Calendar cal = Calendar.getInstance();
        Date dateTime = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("H");
        String formattedDate=dateFormat.format(dateTime);
        int hour = Integer.parseInt(formattedDate);
        if (hour > 3 && hour < 7) {
            System.out.println("Доброй ночи, " + name + "!");
        }
        if (hour > 6 && hour < 12) {
            System.out.println("Доброе утро, " + name + "!");
        }
        if (hour > 11 && hour < 17) {
            System.out.println("Добрый день, " + name + "!");
        }
        if (hour > 16 && hour < 24) {
            System.out.println("Добрый вечер, " + name + "!");
        }
        if (hour > 23 || hour < 4 ) {
            System.out.println("Доброй ночи, " + name + "!");
        }
    }
}
