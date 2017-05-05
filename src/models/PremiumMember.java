package models;

import java.util.HashMap;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class PremiumMember extends Member
{

    public PremiumMember(String email, String name, String address, String gender, double height, double startingWeight, String chosenPackage)
    {
        super(email, name, address, gender, height, startingWeight, chosenPackage);
    }

    //Provides the concrete implementation for this method.  The chosenPackage is set to the value passed as a parameter.
    // There is no validation on the entered data.
    public void chosenPackage(String packageChoice)
    {
      //  super.chosenPackage = chosenPackage(packageChoice);
    }

    public String toString()
    {
        return super.toString();
    }
}
