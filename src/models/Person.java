package models;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public abstract class Person
{
    private String email;
    private String name;
    private String address;
    private String gender;

    /**
     *
     * Constructor of objects of class Person.
     *
     *
     *
     * @param <pre>email - TODO: javadoc for email
     *name - The persons's name should be no more than 30 characters. If the entered name exceeds 30 characters,
     *the extra characters will be truncated and only the first 30 characters will be retained.
     *address - There is no validation on the person's address.
     *gender - The person's gender i.e. can be either "M" or "F". If not specified, default to "Unspecified".</pre>
     *
     */
    public Person (String email, String name, String address, String gender)
    {
        //no validation on email
        this.email = email;
        //name to be no more than 30 characters. If it exceed it gets truncated to 30
        if (name.length() > 30)
        {
            this.name = name.substring(0, 30);
        }
        else
        {
            this.name = name;
        }

        //no validation on address
        this.address = address;

        //gender to inserted as "M" or "F". entry gets changed to upper case to match
        gender = gender.toUpperCase();
        if ((gender.equals("F")) || (gender.equals("M")))
        {
            this.gender = gender;
        }
        //if neither "M" or "F" is entered gender is set as "unspecified"
        else
        {
            this.gender =  "Unspecified";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Person object. The String returned is similar to this structure:
     * <pre>
     *
     *    TODO: change here
     *      Member id: 123456, Name: Joe Soap, Address: 12 High Street, Waterford.
     *        Height: 2 metres, Starting Weight: 74 kgs, BMI of 18.5 (Normal).
     * </pre>
     */
    public String toString()
    {
        return  "Email: " + email
                + ", Name: " + name
                + ", Address: " + address
                + ".\n\tGender: " + gender;
    }


}
