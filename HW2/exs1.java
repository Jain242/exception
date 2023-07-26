package HW2;

import java.util.Scanner;

public class exs1 {

    public static void main(String[] args) {
        float userInput = getUserFloatInput();
        System.out.println("Введенное число: " + userInput);
    }

    public static float getUserFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float result = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите дробное число: ");
            String input = scanner.nextLine();

            try {
                result = Float.parseFloat(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введенное значение не является дробным числом.");
            }
        }

        return result;
    }
}