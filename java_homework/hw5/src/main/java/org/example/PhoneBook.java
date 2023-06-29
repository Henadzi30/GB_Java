package org.example;

import java.io.*;
import java.util.*;

/*
Реализовать консольное приложение - телефонный справочник.
У одной фамилии может быть несколько номеров.
Пользователь может вводить команды:
1: ADD Ivanov 88005553535 - добавить в справочник новое значение. Первый аргумент - фамилия, второй - номер телефона
2: GET Ivanov - получить список всех номеров по фамилии
3: REMOVE Ivanov - удалить все номера по фамилии
4: LIST - Посмотреть все записи
5: EXIT - Завершить программу

Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом.

Пример взаимодействия (=> - это вывод на консоль):
ADD Ivanov 8 800 555 35 35
ADD Ivanov 8 800 100 10 10
GET Ivanov => [8 800 555 35 35, 8 800 100 10 10]
ADD Petrov 8 555 12 34
LIST => Ivanov = [8 800 5553535, 8 800 100 10 10], Petrov = [8 555 12 34]
REMOVE Ivanov
LIST => Petrov = [8 555 12 34]
GET NoName => Не найдена запись с фамилией "NoName"
REMOVE NoName => Не найдена запись с фамилией "NoName"3
 */

public class PhoneBook {
    private static final HashMap<String, String> phoneBook = new HashMap<>();

    //addPhoneBook - добавляет запись по заданным номеру телефона и фамилии
    private static void addPhoneBook(String phone, String name) {

        phoneBook.put(phone, name);

    }

    //removePhoneBook - удаляет запись по номеру телефона
    private static void removePhoneBook(String phone) {

        phoneBook.remove(phone);
    }

    //savePhoneBook - сохраняет БД в текстовом файле phone.txt
    private static void savePhoneBook() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("phone.txt"));
        for(Map.Entry<String,String> k: phoneBook.entrySet()){
            writer.write(k.getKey() + " " + k.getValue()+System.lineSeparator());
        }
        writer.close();
    }

    //loadPhoneBook - загружает БД из текстового файла phone.txt
    //производит проверку на наличие файла
    public static void loadPhoneBook() throws IOException {
        File file = new File("phone.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.txt")));
            String act;
            while ((act=reader.readLine())!=null) {
                String[] dat = act.split(" ");
                phoneBook.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    //PrintPhonebook - выводит на экран все записи телефонного справочника
    public static void PrintPhoneBook(){
        System.out.println("Телефонный справочник: ");
        for(Map.Entry<String,String> k: phoneBook.entrySet()){
            System.out.println(k.getValue() + "= " + k.getKey());
        }
    }

    //FindNumberPhone - производит поиск списка номеров по фамилии, заданной в качестве аргумента
    //возвращает массив строк
    public static String FindNumberPhone(String surname){
        List <String> result = new ArrayList<>();
        for (Map.Entry entry : phoneBook.entrySet()) {
            if (surname.equalsIgnoreCase((String)entry.getValue())){
                result.add((String) entry.getKey());
            }
        }
        if (result.size() == 0) result.add("Не найдена запись с фамилией " + surname );
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        //переменная описывает вызываемое действие
        String action;

        //загрузка БД
        loadPhoneBook();

        //вывод на экран описания возможных действий с указанием команд
        System.out.println("Выбор действия:");
        System.out.println("ADD - добавить в справочник новое значение. Первый аргумент - фамилия," +
                " второй - номер телефона.");
        System.out.println("GET - получить список всех номеров по фамилии.");
        System.out.println("REMOVE - удалить все номера по фамилии.");
        System.out.println("LIST - Посмотреть все записи.");
        System.out.println("EXIT - завершить программу.");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        action = bufferedReader.readLine().toUpperCase();
        while(!action.equals("EXIT")){
            //добавление записи
            if(action.equals("ADD")){
                System.out.println("Введите фамилию:");
                String name = bufferedReader.readLine();
                System.out.println("Введите телефон:");
                String phone = bufferedReader.readLine();
                addPhoneBook(phone, name);
                savePhoneBook();
            }else{
                //удаление всех номеров по фамилии
                if(action.equals("REMOVE")){
                    System.out.println("Введите фамилию:");
                    String name = bufferedReader.readLine();
                    
                    removePhoneBook(name);
                }else{
                    //поиск номеров по фамилии
                    if (action.equals("GET")) {
                        System.out.println("Введите фамилию:");
                        String surname = bufferedReader.readLine();
                        String[] numbers = new String[]{FindNumberPhone(surname)};
                        for (String number : numbers) {
                            System.out.printf(number);
                        }
                    }else{
                        if (action.equals("LIST")) {
                            PrintPhoneBook();
                        }
                    }
                }
            }
            //запрос на следующее действие
            System.out.println();
            System.out.println("Выбор действия:");
            System.out.println("ADD - добавить в справочник новое значение. Первый аргумент - фамилия," +
                    " второй - номер телефона.");
            System.out.println("GET - получить список всех номеров по фамилии.");
            System.out.println("REMOVE - удалить все номера по фамилии.");
            System.out.println("LIST - Посмотреть все записи.");
            System.out.println("EXIT - завершить программу.");
            action =bufferedReader.readLine().toUpperCase();
        }
    }
}
