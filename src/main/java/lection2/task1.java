//1. Замерить время добавления, поиска и удаления объектов из коллекции в LinkedList, ArrayList, TreeSet, HashSet
// (использовать большое количество элементов в коллекции, например 100 000).
// Сравнить время и сделать вывод о том, в каких условиях какая коллекция работает быстрее.

//Time for adding element
//        Linked list: 12
//        Array list: 11
//        Three Set: 12
//        Hash Set: 12
//        Time for search for an element
//        Linked list: 326
//        Array list: 253
//        Three Set: 25
//        Hash Set: 16
//        Time for removing an element
//        Linked list: 251
//        Array list: 417
//        Three Set: 35
//        Hash Set: 25

package lection2;

import java.util.*;

public class task1 {

    public static void main(String[] args) throws InterruptedException {

        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        TreeSet threeSet = new TreeSet();
        HashSet hashSet = new HashSet();
        int sizeOfDataSet = 100000;

        for (int i = 1; i<=sizeOfDataSet; i++){
            linkedList.add(String.valueOf(i));
            arrayList.add(String.valueOf(i));
            threeSet.add(String.valueOf(i));
            hashSet.add(String.valueOf(i));
        }


        System.out.println("Time for adding element");
        System.out.println("Linked list: " + returnTimeAdd(linkedList));
        System.out.println("Array list: " + returnTimeAdd(arrayList));
        System.out.println("Three Set: " + returnTimeAdd(threeSet));
        System.out.println("Hash Set: " + returnTimeAdd(hashSet));

        System.out.println("Time for search for an element");
        System.out.println("Linked list: " + returnTimeSearch(linkedList));
        System.out.println("Array list: " + returnTimeSearch(arrayList));
        System.out.println("Three Set: " + returnTimeSearch(threeSet));
        System.out.println("Hash Set: " + returnTimeSearch(hashSet));

        System.out.println("Time for removing an element");
        System.out.println("Linked list: " + returnTimeRemove(linkedList));
        System.out.println("Array list: " + returnTimeRemove(arrayList));
        System.out.println("Three Set: " + returnTimeRemove(threeSet));
        System.out.println("Hash Set: " + returnTimeRemove(hashSet));

    }

    private static long returnTimeAdd(Collection data){
        long startTime = System.nanoTime();

        data.add("1000001");
        long endTime = System.nanoTime();
        return ((endTime - startTime)/1000);
    }

    private static long returnTimeSearch(Collection data){
        long startTime = System.nanoTime();

        data.contains("5000");
        long endTime = System.nanoTime();
        return ((endTime - startTime)/1000);
    }

    private static long returnTimeRemove(Collection data){
        long startTime = System.nanoTime();

        data.remove("5000");
        long endTime = System.nanoTime();
        return ((endTime - startTime)/1000);
    }

}
