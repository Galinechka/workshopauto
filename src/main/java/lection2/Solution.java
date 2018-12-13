//
//3. Задачка про котов:
//        a. Внутри класса Solution создать public static класс кот - Cat.
//        b. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
//        c. В методе main удалите одного кота из Set cats.
//        d. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве.
//        Каждый кот с новой строки.
//        Требования:
//        Программа должна выводить текст на экран.
//        Внутри класса Solution должен быть public static класс Cat с конструктором по умолчанию.
//        Метод createCats() класса Solution должен возвращать множество (Set) содержащее 3 кота.
//        Метод printCats() класса Solution должен вывести на экран всех котов из множества. Каждый кот с новой строки.
//        Метод main() должен один раз вызывать метод createCats().
//        Метод main() должен вызывать метод printCats().
//        Метод main() должен удалять одного кота из множества котов.

package lection2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        cats.remove(cats.iterator().next());

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<Cat>();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        cats.forEach((value)->System.out.println(value.toString()));
    }

    public static class Cat {
        public Cat() {
        }
    }
}

