package org.example;

// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.util.HashMap;
import java.util.Map;

public class java_homework_2_task_1 {
    public static void main(String[] args) {
        Map<String, String> keyValue = new HashMap<String,String>();
        keyValue.put("name","Ivanov");
        keyValue.put("country","Ukraine");
        keyValue.put("city","Kiev");
        keyValue.put("age",null);
        System.out.println(getQuery(keyValue));
    }
    public static String getQuery(Map<String, String> kv)
        {
        StringBuilder request = new StringBuilder("select * from students where ");
        for (Map.Entry<String,String> pair : kv.entrySet()) {
            if (pair.getValue() != null) {
                request.append(pair.getKey() +" = '" + pair.getValue()+"' and ");
            }
        }
        request.delete(request.toString().length()-5,request.toString().length());
        return request.toString();
    }
}