package com.company;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        int x = 0;
        boolean inputResult;

        do {
            inputResult = true;
            Scanner input = new Scanner(System.in);

            try {
                System.out.print("input x (from 1 to 100): ");
                x = input.nextInt();

                if(x<1 || x>100){
                    throw new Exception();
                }
            } catch (Exception e) {
                inputResult = false;
            }
        } while (inputResult == false);

        System.out.print("x = " + x);
    }
}