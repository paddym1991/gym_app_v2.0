package utils;

import java.util.Scanner;

/**
 * Created by Paddym1991 on 02/05/2017.
 */

public class ScannerInput {

    @SuppressWarnings("resource")
    public static int validNextInt(String prompt) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                return Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        } while (true);
    }

    @SuppressWarnings("resource")
    public static double validNextDouble(String prompt) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                return Double.parseDouble(input.next());
            } catch (NumberFormatException e) {
                System.err.println("\tEnter a decimal number please.");
            }
        } while (true);
    }

    public String getStringInput()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("> ");
        String inputString = input.nextLine();
        return inputString;
    }
}

/*
public class ScannerInput {

    Scanner input;

    public ScannerInput()
    {
        input = new Scanner(System.in);
    }

    public int getIntInput()
    {
        System.out.print("> ");
        int inputInt = input.nextInt();
        return inputInt;
    }

    public String getStringInput()
    {
        System.out.print("> ");
        String inputString = input.nextLine();
        return inputString;
    }

    public double getDoubleInput()
    {
        System.out.print("> ");
        double inputDouble = input.nextDouble();
        return inputDouble;
    }

}
*/



