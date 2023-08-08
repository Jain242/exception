


package HW3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * task1
 */
public class task1 {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "CP866");
        System.out.println("Введите данные (ФИО, дата рождения, номер телефона, пол):");
        String input = scanner.nextLine();

        try {
            processUserData(input);
            System.out.println("Данные успешно обработаны и записаны в файл(ы).");
        } catch (InvalidDataException | WriteException | DataCountException e) {
            System.err.println("Ошибка: " + e.getMessage());
            //e.getStackTrace();
        }
    }

    public static  void processUserData(String input) throws InvalidDataException, WriteException, DataCountException{

        String[] data = input.split("\\s+");

        if (data.length != 6) {
            throw new DataCountException("Неверное количество параметров.");
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        // Проверка  ФИО
        if (!isNameValid(surname) || !isNameValid(name) || !isNameValid(patronymic)) {
            throw new InvalidDataException("Неверный формат ФИО.");
        }

        // Проверка  даты
        if (!isDateValid(birthDate)) {
            throw new InvalidDataException("Неверный формат даты рождения.");
        }

        // Проверка  телефона
        if (!isPhoneNumberValid(phoneNumber)) {
            throw new InvalidDataException("Неверный формат номера телефона.");
        }

  
        if (!isGenderValid(gender)) {
            throw new InvalidDataException("Неверный формат пола.");
        }

     
        String record = String.format("%s %s %s %s %s %s", surname, name, patronymic, birthDate, phoneNumber, gender);

        try {
            if (Files.exists(Paths.get("HW3\\save\\" + surname + ".txt"))) {
  
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("HW3\\save\\" + surname + ".txt", true))) {
                    writer.newLine();
                    writer.write(record);
                }
            } else {
  
            try (FileWriter writer = new FileWriter("HW3\\save\\" + surname + ".txt")) {
                writer.write(record);
            }
        }
        } catch (Exception e) {
            throw new WriteException("Не удалось записать в файл!");
        }
    }

    private static boolean isNameValid(String name) {
        //System.out.println(name);
        return name.matches("[А-Яа-я]+");
    }

    private static boolean isDateValid(String date) {

        String[] parts = date.split("\\.");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > java.time.LocalDate.now().getYear()) {
            return false;
        }

        return true;
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("\\d+");
    }

    private static boolean isGenderValid(String gender) {
        return gender.matches("[fmFM]");
    }

    
}