package models;

import java.util.HashMap;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class PremiumMember extends Member
{

    public PremiumMember(String email, String name, String address, String gender, double height, double startingWeight, String chosenPackage, HashMap<String, String> assessments)
    {
        super(email, name, address, gender, height, startingWeight, chosenPackage, assessments);
    }

    public void chosenPackage(String packageChoice)
    {

    }
}