package org.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class java_homework_2_bubble {
    public static void main(String[] args) throws IOException {

        // Реализуйте алгоритм сортировки пузырьком числового массива,
        // результат после каждой итерации запишите в лог-файл.

//        int [] mas = {11, 3, 14, 16, 7};
        int[] array = new int[12];

        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * 20) - 10);
//            System.out.println(array[i]);
        }
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));

        Logger logger = Logger.getLogger(java_homework_2_bubble.class.getName());

//        ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        boolean isSorted = false;
        int bufer;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]){
                    isSorted = false;

                    bufer = array[i];
                    array[i] = array[i+1];
                    array[i+1] = bufer;
                }

            }
            logger.log(Level.WARNING, "Тестовое логирование" + Arrays.toString(array));
            logger.info("Тестовое логирование " +  Arrays.toString(array));

        }
        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(array));
    }
}
