package models;

import java.util.HashMap;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class StudentMember extends Member
{

    private String studentId;
    private String collegeName;

    public StudentMember(String email, String name, String address, String gender, double height, double startingWeight, String chosenPackage, String studentId, String collegeName)
    {
        super(email, name, address, gender, height, startingWeight, chosenPackage);

        //no validation on studentId
        this.studentId = studentId;

        //no validation on collegeName
        this.collegeName = collegeName;

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    //Provides the concrete implementation for this method.  The chosenPackage is set to the package associated with their collegeName.
    // If there is no package associated with their college, default to “Package 3.
    @Override
    public void chosenPackage(String chosenPackage)
    {
        //TODO: Provides the concrete implementation for this method.  The chosenPackage is set to the package associated with their collegeName.  If there is no package associated with their college, default to “Package 3”.
        chosenPackage = "WIT";
    }

    public String toString()
    {
        return super.toString() + "Student ID: " + studentId + ", College: " + collegeName;
    }
}
