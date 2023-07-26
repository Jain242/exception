package HW2;
import java.util.Scanner;

public class exs4 {
public static void main(String[] args) {
    
        try {
            String userData = getNonEmptyInput("Введите что-то: ");
            System.out.println("Вы ввели: " + userData);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    
    public static String getNonEmptyInput(String prompt) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String userInput = scanner.nextLine().trim();
        
        if (userInput.isEmpty()) {
            scanner.close();
            throw new Exception("Пустые строки вводить нельзя!");
        }
        
        scanner.close();
        return userInput;
    }


}
