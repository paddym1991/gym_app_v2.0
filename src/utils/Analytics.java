package utils;

import models.Assessment;
import models.Member;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class Analytics
{


    public Analytics ()
    {

    }

    /**
     * This method calculates the BMI value for the member.
     *
     * @return the BMI value for the member. The number returned is truncated to two decimal places.
     */
    public static double calculateBMI (Member member, Assessment assessment)
    {
        //TODO:
       // bmiValue = toTwoDecimalPlaces(startingWeight / (height * height));
       // return bmiValue;

        return 0;
    }

    /**
     * The method truncates a double to 2 decimal places.
     */
    public static double toTwoDecimalPlaces(double num)
    {
        return (int)(num * 100) / 100.0;
    }


    /**
     * This method determines the BMI category that the member belongs to.
     *
     *  The category is determined by the magnitude of the members BMI according to the following:
     *  <pre>
     *
     *      BMI less than    15   (exclusive)                      is "VERY SEVERELY UNDERWEIGHT"
     *      BMI between      15   (inclusive) and 16   (exclusive) is "SEVERELY UNDERWEIGHT"
     *      BMI between      16   (inclusive) and 18.5 (exclusive) is "UNDERWEIGHT"
     *      BMI between      18.5 (inclusive) and 25   (exclusive) is "NORMAL"
     *      BMI between      25   (inclusive) and 30   (exclusive) is "OVERWEIGHT"
     *      BMI between      30   (inclusive) and 35   (exclusive) is "MODERATELY OBESE"
     *      BMI between      35   (inclusive) and 40   (exclusive) is "SEVERELY OBESE"
     *      BMI greater then 40   (inclusive)                      is "VERY SEVERELY OBESE"
     * </pre>
     *
     * @return <pre>The format of the String is similar to this (note the double quotes around the category):
     *      "NORMAL".</pre>
     */
    /*
    public static String determineBMICategory(double bmiValue)
    {

        if (calculateBMI() < 15)
        {
            return "VERY SEVERELY UNDERWEIGHT";
        }
        else if ((calculateBMI() >= 15) && (calculateBMI() < 16))
        {
            return "SEVERELY UNDERWEIGHT";
        }
        else if ((calculateBMI() >= 16) && (calculateBMI() < 18.5))
        {
            return "UNDERWEIGHT";
        }
        else if ((calculateBMI() >= 18.5) && (calculateBMI() < 25))
        {
            return "NORMAL";
        }
        else if ((calculateBMI() >= 25) && (calculateBMI() < 30))
        {
            return "OVERWEIGHT";
        }
        else if ((calculateBMI() >= 30) && (calculateBMI() < 35))
        {
            return "MODERATELY OBESE";
        }
        else if ((calculateBMI() >= 35) && (calculateBMI() < 40))
        {
            return "SEVERELY OBESE";
        }
        else //(calculateBMI() >= 40)
        {
            return "VERY SEVERELY OBESE";
        }
    }
    */

    /**
     * <pre>
     * This method returns a boolean to indicate if the member has an ideal body weight based on the Devine formula.
     *  For males, an ideal body weight is:     50 kg + 2.3 kg for each inch over 5 feet.
     *  For females, an ideal body weight is:   45.5 kg for each inch over 5 feet.
     *
     *  Note:   if no gender is specified, return the result of the female calculation.
     *  </pre>
     *  @return Returns true if the result of the devine formula is within 2 kgs (inclusive) of the starting weight; fals if it is outside this range.
     */
    /*
    public static boolean isIdealBodyWeight(Member member, Assessment assessment)
    {
        double heightToInches = convertHeightMetresToInches();
        int fiveFeet = 60;
        double idealBodyWeight = 0.0;

        if (heightToInches <= fiveFeet) {
            if (gender.equals("M")) {
                idealBodyWeight = 50;
            } else {
                idealBodyWeight = 45.5;
            }
        } else {
            if (gender.equals("M")) {
                idealBodyWeight = 50 + (2.3 * (heightToInches - fiveFeet));
            } else {
                idealBodyWeight = 45.5 + (2.3 * (heightToInches - fiveFeet));
            }
        }

        if ((idealBodyWeight >= (startingWeight - 2)) && (idealBodyWeight <= (startingWeight + 2)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    */

}
