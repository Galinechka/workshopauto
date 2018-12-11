//1. Создать массив на 10 чисел.
//        2. Ввести с клавиатуры 10 чисел и записать их в массив.
//        3. Вывести на экран элементы массива в обратном порядке, каждое значение выводить с новой строки.

package lection1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class taskTwo {

    public static void main(String args[]) {

        System.out.println("Enter 10 numbers");

        int[] array = getInput();

        for (int i = 10; i>0; i--){
            System.out.println("Number " +i + " is " + array[i-1]);
        }

    }

    private static int[] getInput(){
        int[] array = new int[10];

        for (int i = 1; i<11; i++){

            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Number" + i + ":");
                array[i - 1] = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("No valid value detected, please check one more time.");
                i--;
            }

        }
        return array;
    }

}