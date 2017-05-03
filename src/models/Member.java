package models;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedSet;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public abstract class Member extends Person
{

    private double height;
    private double startingWeight;
    private String chosenPackage;
    private HashMap<String, String> assessment = new HashMap<String, String>(); //TODO: sort this out


    public Member(String email, String name, String address, String gender, double height, double startingWeight, String chosenPackage)
    {
        super(email, name, address, gender);

        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }

        else
        {
            this.height = 0.0;
        }

        if ((startingWeight >= 35) && (startingWeight <= 250))
        {
            this.startingWeight = startingWeight;
        }
        else
        {
            this.startingWeight = 0.0;
        }

        this.chosenPackage = chosenPackage;

        this.assessment = assessment;
        //this.assessment = new HashMap<>();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }




    public double getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }



    /**
     * The method truncates a double to 2 decimal places.
     */
    //TODO: have another copy of this in Analytics
    public double toTwoDecimalPlaces(double num)
    {
        return (int)(num * 100) / 100.0;
    }

    public String getChosenPackage() {
        return chosenPackage;
    }

    public void setChosenPackage(String chosenPackage) {
        this.chosenPackage = chosenPackage;
    }

    public HashMap<String, String> getAssessments() {
        return assessment;
    }

    public void setAssessments(HashMap<String, String> assessments) {
        this.assessment = assessments;
    }

    public Assessment latestAssessment()
    {
        return latestAssessment();
    }

    //TODO
    public SortedSet<Date> sortedAssessmentDates()
    {
        //return sortedAssessmentDates;
        return null;
    }

    public abstract void chosenPackage(String chosenPackage);

    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Member object. The String returned is similar to this structure:
     * <pre>
     *
     *    Member id: 123456, Name: Joe Soap, Address: 12 High Street, Waterford.
     *        Height: 2 metres, Starting Weight: 74 kgs, BMI of 18.5 (Normal).
     * </pre>
     */
    //@Override Person
    public String toString()
    {
         super.toString();
         return ".\n\tHeight: " + height
                + " metres, Starting Weight: " + startingWeight;
    }

}
