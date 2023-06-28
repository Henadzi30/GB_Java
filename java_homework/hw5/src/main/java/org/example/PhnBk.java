package org.example;

import java.util.Set;

public class PhnBk {
    public static void main(String[] args) {
        //TODO напишите консольное приложение для взаимодействия с телефонной книгой
    }

    public void addContact(String phone, String name) {
        //TODO проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getNameByPhone(String phone) {
        //TODO формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        //TODO по имени вернуть список номеров
        return null;
    }

    public StringBuilder getNumbersToString(Set<String> numbers) {
        //TODO вернуть номера в формате строки <номер>, <номер>.
        return null;
    }

    public Set<String> getAllContacts() {
        //TODO вернуть все контакты в формате <имя> — <номер>, <номер> и тд
        return null;
    }

    public boolean checkContacts(String name) {
        //TODO проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        return false;
    }

    public boolean isCorrect(String name, String phone){
        //TODO проверьте корректность номера
        return true;
    }
}