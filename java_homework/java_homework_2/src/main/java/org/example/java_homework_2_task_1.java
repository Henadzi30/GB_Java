package org.example;

// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class java_homework_2_task_1 {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("name", "mkyong.com");
        object.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        object.put("messages", list);

        try{
            FileWriter file = new FileWriter("test.json");
            file.write(object.toJSONString());
            file.flush();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//
//            throws java.lang.Exception {
//
//        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
//
//        Map<String, String> filterParams = Arrays.stream(json.substring(1, json.length() - 1).split(","))
//                .map(s -> s.split(":"))
//                .collect(Collectors.toMap(a -> a[0].trim(), b -> b[1].trim()));
//
//        StringBuilder whereClauseBuilder = new StringBuilder("select * from students where ");

//        System.out.println(filterParams);
//        System.out.println(whereClauseBuilder.toString());
//        Object obj = new JSONParser().parse(new FileReader("People.json"));
//        System.out.println(obj.toString());
    JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


//        for (Map.Entry<String, String> entry : filterParams.entrySet()) {
//            if (!entry.getValue().equals("null")) {
//                whereClauseBuilder.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'").append(" and ");
//            }
//        }
//
//        int endIndex = whereClauseBuilder.length() - " and ".length();
//        if (whereClauseBuilder.lastIndexOf(" and ") == endIndex) {
//            whereClauseBuilder.delete(endIndex, whereClauseBuilder.length());
//        }
//        System.out.println(whereClauseBuilder.toString());
//    }
//}


//        Object obj = new JSONParser().parse(new FileReader("Peuple.json"));
//        JSONObject jn = (JSONObject) o;
//        String Name = (String) jn.get("name");
//        // Map<String, String> jn = new HashMap<String, String>();
//        jn.put("name", "Ivanov");
//        jn.put("country", "Russia");
//        jn.put("city", "Moscow");
//        jn.put("age", null);
//        System.out.println(getQuery(jn));
//    }
//    public static String getQuery(Map<String, String> params) {
//
//        StringBuilder s = new StringBuilder();
//        for (Map.Entry<String,String> pair : params.entrySet())
//        {
//            if (pair.getValue() != null)
//            {
//                s.append(pair.getKey() +" = '" + pair.getValue()+"' and ");
//            }
//        }
//        s.delete(s.toString().length()-5,s.toString().length());
//        return s.toString();
//    }
//}


////////////////////////////////

//import java.util.*;
//import java.lang.*;
//import java.io.*;
//import java.util.stream.Collectors;
//
//class Main {
//    public static void main(String[] args) throws java.lang.Exception {
//        // Данные для фильтрации в виде JSON-строки
//        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
//
//        // Преобразуем строку JSON в объект Map<String, String>
//        Map<String, String> filterParams = Arrays.stream(json.substring(1, json.length() - 1).split(","))
//                .map(s -> s.split(":"))
//                .collect(Collectors.toMap(a -> a[0].trim(), b -> b[1].trim()));
//
//        // Создаем StringBuilder для формирования запроса
//        StringBuilder whereClauseBuilder = new StringBuilder("select * from students where ");
//
//        // Добавляем параметры фильтрации в запрос, если они не равны null
//        for (Map.Entry<String, String> entry : filterParams.entrySet()) {
//            if (!entry.getValue().equals("null")) {
//                whereClauseBuilder.append(entry.getKey()).append("=").append("'").append(entry.getValue()).append("'").append(" and ");
//            }
//        }
//
//        // Удаляем последний оператор "and", если он есть
//        int endIndex = whereClauseBuilder.length() - " and ".length();
//        if (whereClauseBuilder.lastIndexOf(" and ") == endIndex) {
//            whereClauseBuilder.delete(endIndex, whereClauseBuilder.length());
//        }
//
//        // Выводим результат на экран
//        System.out.println(whereClauseBuilder.toString());
//    }
//}
