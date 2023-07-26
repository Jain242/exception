package HW2;

import java.io.FileNotFoundException;

public class exs3 {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[2] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("Ошибка деления на ноль!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Индекс выходит за пределы массива!");
        }
    }

    public static void printSum(int a, int b) throws FileNotFoundException {
        System.out.println(a + b);
    }
}