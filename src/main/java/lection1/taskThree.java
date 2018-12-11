//1. Создать массив на 20 чисел.
//        2. Ввести в него значения с клавиатуры.
//        3. Создать два массива с четными и нечетными числами.
//        4. Вывести оба массива на экран, каждое значение выводить с новой строки.
package lection1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class taskThree {

    static int arraySize = 20;

    public static void main(String args[]) {
        int[] arrayEven = new int[0];
        int[] arrayUneven = new int[0];


        System.out.println("Enter "+arraySize+ " numbers");

        int[] array = getInput();

        for (int number : array) {
            if (number % 2 == 0){
                arrayEven = append(arrayEven, number);
            } else {
                arrayUneven = append(arrayUneven, number);
            }
        }

        System.out.println("Even numbers:");
        printArray(arrayEven);

        System.out.println("UnEven numbers:");
        printArray(arrayUneven);

    }

    // Add int to the existing array
    private static int[] append(int[] array, int newItem){

        int newSize = array.length + 1;
        int[] tempArray = new int[newSize];

        for (int i=0; i < array.length; i++){
            tempArray[i] = array [i];
        }

        tempArray[newSize- 1] = newItem;
        return tempArray;
    }

    //receives and validate input numbers
    private static int[] getInput(){
        int[] array = new int[arraySize];

        for (int i = 1; i<(arraySize+1); i++){

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

    private static void printArray (int[] array){
        for (int number : array) {
            System.out.println(number);
        }
    }

}
