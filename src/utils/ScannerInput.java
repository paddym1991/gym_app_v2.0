package utils;

import java.util.Scanner;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
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
