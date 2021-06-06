package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        int numberOfAttempts = 0;
        int compNumber = 0;
        int userNumber = 0;
        int max = 0;
        int min = 100;
        final int EXIT_CODE = -1;
        boolean inputNumber;


        int difficulty;
        boolean inputDifficulty;

        try {
            inputDifficulty = true;
            System.out.println("Введите сложность игры: 1 - легкий, 2 - средний, 3 - сложный: ");
            difficulty = input.nextInt();

            switch (difficulty) {
                case 1:
                    System.out.println("легкий\nВведите любое число от 1 до 100:");
                    compNumber = rnd.nextInt(100) + 1;
                    max = 100;
                    min = 1;
                    break;
                case 2:
                    System.out.println("средний\nВведите любое число от 1 до 250:  ");
                    compNumber = rnd.nextInt(500) + 1;
                    max = 500;
                    min = 1;
                    break;
                case 3:
                    System.out.println("сложный\nВведите любое число от 1 до 500: ");
                    compNumber = rnd.nextInt(1000) + 1;
                    max = 1000;
                    min = 1;
                    break;
            }
        } catch (Exception e) {
            inputDifficulty = false;
            System.out.println("Ошибка ввода,перезапустите программу " + e.getMessage());
        }

        do {
            inputNumber = true;


            try {
                userNumber = input.nextInt();

                if (userNumber < 1 || userNumber > 500) {
                    throw new Exception();
                }

                if (userNumber > compNumber) {
                    max = userNumber;
                    System.out.println("Введите число поменьше: от " + min + " до " + userNumber);
                } else if (userNumber < compNumber) {
                    min = userNumber;
                    System.out.println("Введите число побольше: от " + userNumber + " до " + max);
                }

                if (userNumber != EXIT_CODE) {
                    numberOfAttempts++;
                }
            } catch (Exception e) {
                System.out.println("Ошибка");
                inputNumber = false;
            }

        } while (compNumber != userNumber || inputNumber == false);


        System.out.println("Поздравляю,вы угадали число!! ");
        System.out.println("Количество попыток: " + numberOfAttempts);

        if (numberOfAttempts <= 5) {
            System.out.println("красава");
        } else if (numberOfAttempts > 5 && numberOfAttempts <= 10) {
            System.out.println("среднячок");
        } else {
            System.out.println("проиграл");
        }

    }
}