package org.example;

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в следующем порядке, разделенные пробелом:");
        System.out.println("Фамилия Имя Отчество датарождения номертелефона пол");

        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Ошибка: введено неверное количество данных");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        try {
            writeUserDataToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            System.out.println("Данные успешно записаны в файл");
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл:");
            e.printStackTrace();
        }
    }

    private static void writeUserDataToFile(String lastName, String firstName, String middleName, String birthDate,
                                            String phoneNumber, String gender) throws IOException {
        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String userData = lastName + firstName + middleName + birthDate + " " + phoneNumber + gender;
            writer.write(userData);
            writer.newLine();
        }
    }
}