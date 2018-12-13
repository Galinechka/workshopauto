//2. Есть коллекция HashMap<String, String>,туда занесли 10 различных строк. Вывести на экран список ключей, каждый элемент с новой строки.
//        Требования:
//        Программа должна создавать переменную коллекции HashMap с типом элементов String, String. Переменная должна быть сразу проинициализирована.
//        Программа не должна считывать значения с клавиатуры.
//        Программа должна добавлять в коллекцию 10 различных строк, согласно условию.
//        Метод printKeys() должен выводить на экран список ключей коллекции, каждый элемент с новой строки.
package lection2;

import java.util.HashMap;

public class task2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "Galina");
        map.put("2", "Vika");
        map.put("3", "Anita");
        map.put("4", "Leonid");
        map.put("5", "Denis");
        map.put("6", "Masha");
        map.put("7", "Julia");
        map.put("8", "Jana");
        map.put("9", "Andrii");
        map.put("10", "Vitalij");
        
        printKey(map);
        
    }

    private static void printKey(HashMap<String, String> map) {
        map.forEach((key,value)->System.out.println(key));
    }
}
