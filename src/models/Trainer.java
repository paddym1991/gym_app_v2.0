package models;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class Trainer extends Person
{

    private String speciality;

    public Trainer(String email, String name, String address, String gender, String speciality)
    {
        super(email, name, address, gender);

        //no validation on trainers speciality
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String toString()
    {
        super.toString();
        return ".\n\tspeciality: " + speciality;
    }
}
