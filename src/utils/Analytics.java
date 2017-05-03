package utils;

import models.Assessment;
import models.Member;


/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class Analytics
{


    private Member member;

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
        double bmiValue = toTwoDecimalPlaces(member.getStartingWeight() / (member.getHeight() * member.getHeight()));
        return bmiValue;
        //TODO: whats the deal with assessment parameter?
    }

    /**
     * The method truncates a double to 2 decimal places.
     */
    //TODO: should this be static
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
    //TODO: should this be static?
    public static String determineBMICategory(double bmiValue)
    {
        if (bmiValue < 15)
        {
            return "VERY SEVERELY UNDERWEIGHT";
        }
        else if ((bmiValue >= 15) && (bmiValue < 16))
        {
            return "SEVERELY UNDERWEIGHT";
        }
        else if ((bmiValue >= 16) && (bmiValue < 18.5))
        {
            return "UNDERWEIGHT";
        }
        else if ((bmiValue >= 18.5) && (bmiValue < 25))
        {
            return "NORMAL";
        }
        else if ((bmiValue >= 25) && (bmiValue < 30))
        {
            return "OVERWEIGHT";
        }
        else if ((bmiValue >= 30) && (bmiValue < 35))
        {
            return "MODERATELY OBESE";
        }
        else if ((bmiValue >= 35) && (bmiValue < 40))
        {
            return "SEVERELY OBESE";
        }
        else //(bmiValue >= 40)
        {
            return "VERY SEVERELY OBESE";
        }
    }

    /**
     * <pre>
     * This method returns a boolean to indicate if the member has an ideal body weight based on the Devine formula.
     *  For males, an ideal body weight is:     50 kg + 2.3 kg for each inch over 5 feet.
     *  For females, an ideal body weight is:   45.5 kg for each inch over 5 feet.
     *
     *  Note:   if no gender is specified, return the result of the female calculation.
     *  </pre>
     *  @return Returns true if the result of the devine formula is within 2 kgs (inclusive) of the starting weight; false if it is outside this range.
     */
    //TODO: should this be static?
    public static boolean isIdealBodyWeight(Member member, Assessment assessment)
    {
        double heightToInches = convertHeightMetresToInches(member.getHeight()); //TODO: may change this to assessment.getHeight()
        int fiveFeet = 60;
        double idealBodyWeight = 0.0;

        if (heightToInches <= fiveFeet) {
            if (member.getGender().equals("M")) {
                idealBodyWeight = 50;
            } else {
                idealBodyWeight = 45.5;
            }
        } else {
            if (member.getGender().equals("M")) {
                idealBodyWeight = 50 + (2.3 * (heightToInches - fiveFeet));
            } else {
                idealBodyWeight = 45.5 + (2.3 * (heightToInches - fiveFeet));
            }
        }

        if ((idealBodyWeight >= (member.getStartingWeight() - 2)) && (idealBodyWeight <= (member.getStartingWeight() + 2)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method returns the member height converted from metres to inches.
     *
     * @return member height converted from metres to inches using the formula: meters multiplied by 39.37. The number returned is truncated to two decimal places.
     */
    public static double convertHeightMetresToInches(double height)
    {
        //double heightToInches = height * 39.37;
        //return toTwoDecimalPlaces(heightToInches);
        //TODO: created a member field at the top. is that ok?
        return toTwoDecimalPlaces(height * 39.37);
        //truncate this to 2 decimal places;
    }

    /**
     * This method returns the member weight converted from KGs to pounds.
     *
     * @return member weight converted from KGs to pounds. The number returned is truncated to two decimal places.
     */
    public static double convertWeightKGtoPounds(double weight)
    {
        //double weightToPounds = startingWeight * 2.2;
        //return toTwoDecimalPlaces(weightToPounds);
        //TODO: created a member field at the top. is that ok?
        return toTwoDecimalPlaces(weight * 2.2);
    }



}
