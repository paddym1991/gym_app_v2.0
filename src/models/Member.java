package models;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public abstract class Member extends Person
{

    private double height;
    private double startingWeight;
    private String chosenPackage;
    private HashMap<Date, Assessment> assessment = new HashMap<>(); //TODO: sort this out



    public Member(String email, String name, String address, String gender, double height, double startingWeight, String chosenPackage)
    {
        super(email, name, address, gender);

        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
        else
        {
            this.height = 1;
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

       // this.assessment = assessment;
        //this.assessment = new HashMap<>();
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
    }




    public double getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(double startingWeight)
    {
        if ((startingWeight >= 35) && (startingWeight <= 250))
        {
            this.startingWeight = startingWeight;
        }
    }


    public String getChosenPackage() {
        return chosenPackage;
    }

    public void setChosenPackage(String chosenPackage) {
        this.chosenPackage = chosenPackage;
    }

    public HashMap<Date, Assessment> getAssessment() {
        return assessment;
    }

    public void setAssessment(HashMap<Date, Assessment> assessment) {
        this.assessment = assessment;
    }


    public void addAssessment(Assessment newAssessment)
    {
        assessment.put(new Date(), newAssessment);
    }


    public Assessment latestAssessment()
    {
        return assessment.get(sortedAssessmentDates().last());
    }

    public Assessment previousAssessment() {
        return assessment.get(sortedAssessmentDates().last());
    }

    //TODO
    public SortedSet<Date> sortedAssessmentDates()
    {
        SortedSet<Date> keys = new TreeSet<>(assessment.keySet());
        return keys;
    }

    //The concrete implementation of this method will be completed in Member subclasses.
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
        return super.toString() +
          ".\n\tHeight: " + height
                + " metres, Starting Weight: " + startingWeight + " Kgs";
    }

}
