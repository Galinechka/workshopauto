//- Ввести с клавиатуры число и имя, вывести на экран строку:
//        Пример: Galina 22
//        Последовательность вводимых данных имеет большое значение.
//        Требования:
//        Программа должна выводить текст.
//        Программа должна считывать данные с клавиатуры.
//        Выведенный текст должен содержать введенное имя.
//        Выведенный текст должен содержать введенное число.

package lection1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class taskOne {

    public static void main(String args[]) {

        int age;
        String name;

        Data data = new Data();

        data.request();

        System.out.println("Your name is: " + data.getName());
        System.out.println("Your age is: " + data.getAge());

    }

}

    class Data {

        private String text;
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void request() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter name and age in full years:");
            text = sc.nextLine().trim();

            //if nothing or space entered ask again
            if (text.equals("")){
                System.out.println("You haven't entered any data!");
                request();
            }

            countAge();
            countName();

        }

        //looking for word starting with numbers in case of user entered name like "galina33"
        private void countAge() {
            String ageString;

            try{
                Pattern p = Pattern.compile("(^|\\s?\\W.)\\d+");
                Matcher m = p.matcher(text);
                m.find();
                ageString = m.group().trim();
                age = Integer.parseInt(ageString);

            } catch (IllegalStateException e){
                System.out.println("No age detected!");
                this.request();
            }

        }

        //name can contain numbers but not start from number
        private void countName() {

            try{

                Pattern p = Pattern.compile("(^|\\s?\\D?)[A-z]+\\d?\\S?");
                Matcher m = p.matcher(text);
                m.find();
                name = m.group().trim();

            } catch (IllegalStateException e){

            System.out.println("No name detected!");
            this.request();
            }

        }

    }
