package controllers;

import java.util.ArrayList;
import java.util.Date;

import models.Assessment;
import models.Member;
import models.Person;
import models.Trainer;
import utils.Analytics;

import static utils.Analytics.calculateBMI;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class GymApi {

    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;

    public GymApi()
    {
        this.members = new ArrayList<Member>();
        this.trainers = new ArrayList<Trainer>();
    }

    /**
     *
     * Adds a member to the gym collection.
     *
     * @param member The member object that will be added to the gym collection.
     *
     */
    public void addMember(Member member)
    {
        members.add(member);
    }

    /**
     *
     * Adds a member to the gym collection.
     *
     * @param trainer The trainer object that will be added to the gym collection.
     *
     */
    public void addTrainer(Trainer trainer)
    {
        trainers.add(trainer);
    }

    /**
     * Returns the number of members stored in the gym collection.
     *
     * @return The number of member object currently stored in the gym collection.
     */
    public int numberOfMembers()
    {
        return members.size();
    }

    /**
     * Returns the number of trainers stored in the gym collection.
     *
     * @return The number of trainers object currently stored in the gym collection.
     */
    public int numberOfTrainers()
    {
        return trainers.size();
    }

    //TODO:
    public ArrayList<Member> getMembers()
    {
        return members;
    }

    //TODO:
    public ArrayList<Trainer> getTrainers()
    {
        return trainers;
    }

    //if the size of the members array is greater than the index and is not negative, then it is a valid index.
    public boolean isValidMemberIndex(int index)
    {
        return index >= 0 && index < numberOfMembers();
    }

    //if the size of the trainers array is greater than the index and is not negative, then it is a valid index.
    public boolean isValidTrainerIndex(int index)
    {
        return index >= 0 && index < numberOfTrainers();
    }

    //TODO:
    public Member searchMembersByEmail(String emailEntered)
    {
        Member memberFound = null;

        for (Member member : members)
        {
            if (member.getEmail().equals(emailEntered)) memberFound = member;
        }
        return memberFound;
    }

    //TODO:
    public String searchMembersByName(String nameEntered)
    {
        String membersFound = "";

        if(numberOfMembers() > 0)
        {
            for (int i = 0; isValidMemberIndex(i); i++) {
                Member member = members.get(i);
                if (member.getName().toUpperCase().contains(nameEntered.toUpperCase())) {
                     membersFound += "\n" + (i + 1) + ": " + member.getName() + "\tEmail: " + member.getEmail().toLowerCase();
                }
            }
            if (membersFound.equals(""))
            {
                return "There are no members matching your search: " + nameEntered;
            }
            else
            {
                return "Results Found: " + membersFound;
            }
        }
        else
        {
            return "There are no members in the gym";
        }
    }

    //TODO:
    public Trainer searchTrainersByEmail(String emailEntered)
    {
        Trainer trainerFound = null;

        for (Trainer trainer: trainers)
        {
            if (trainer.getEmail().equals(emailEntered)) trainerFound = trainer;
        }
        return trainerFound;
    }

    /**
     * Returns a String representing all the members stored in the gym collection.
     *
     * @return
     *<pre>String representing all the members stored in the gym collection. The String returned is similar to this structure, with the preceeding number representing the index number of the
     *member within the collection:
     *
     *    0: member's toString() format
     *    1: member's toString() format
     *    2: member's toString() format
     */
    public String listMembers()
    {
        if (members.size() > 0)
        {
            String listOfMembers = "";
            for(int index = 0; index < members.size(); index++)
            {
                listOfMembers = listOfMembers + index + ": " + members.get(index).toString() + "\n\n";
                //listOfMembers = listOfMembers + member.toString() + "\n\n";
            }
            return listOfMembers;

        }
        else
        {
            return "There are no members in the gym";
        }
    }

    /**
     * List all the members that have an ideal starting weight.
     *
     * @return
     * <pre>The list of members (i.e use the toString method here) that have an ideal starting weight based on the devine method.
     *
     * If there are no members with an ideal starting weight, the message
     *     "There are no members in the gym with an ideal weight" should be returned.
     *
     * If there are no members in the gym, the message
     *     "There are no members in the gym" should be returned.
     * </pre>
     */
    public String listMembersWithIdealWeight()
    {
        if (members.size() > 0)
        {
            String membersIdealWeight = "";
            for (int index = 0; index < members.size(); index++)
            {
                if(Analytics.isIdealBodyWeight(members.get(index), members.get(index).latestAssessment()) == true)
                {
                    membersIdealWeight =  membersIdealWeight + members.get(index).toString() + "\n\n";
                }
            }
            if(membersIdealWeight.equals(""))
            {
                return "There are no members with an ideal weight";
            }
            else
            {
                return membersIdealWeight;
            }
        }
        else
        {
            return "there are no members in the gym";
        }
    }

    /**
     *
     * List all the members of a specific BMI category.
     *
     *
     * @param
     * <pre>category - The category you wish to search members by.
     *
     * The specific categories are:
     *       "VERY SEVERELY UNDERWEIGHT"
     *       "SEVERELY UNDERWEIGHT"
     *       "UNDERWEIGHT"
     *       "NORMAL"
     *       "OVERWEIGHT"
     *       "MODERATELY OBESE"
     *       "SEVERELY OBESE"
     *       "VERY SEVERELY OBESE"
     *
     * This method also allows you to search by any key words e.g. "OBESE" will return members in the following categories:
     *       "MODERATELY OBESE"
     *       "SEVERELY OBESE"
     *       "VERY SEVERELY OBESE"
     * Note:     In this situation, the members are not sorted by category, they are just displayed as is.
     * </pre>
     * @return
     * <pre>The list of members whose BMI falls into the category passed as a parameter.
     *
     * If there are no members in the BMI category, the message
     *     "There are no members in the gym in this BMI category" should be returned.
     *
     * If there are no members in the gym, the message
     *     "There are no members in the gym" should be returned.
     * </pre>
     */
    public String listBySpecificBMICategory(String category)
    {
        if (members.size() > 0)
        {
            String membersBMICategory = "";
            category = category.toUpperCase();
            //for (int index = 0; index < members.size(); index++)
            //Changed the above line of code to a For Each as it allows me to get rid of '.get(index)', thus making code shorter.
            for(Member member : members)
            {
                if (Analytics.determineBMICategory(calculateBMI(member, member.latestAssessment())).contains(category))
                {
                    membersBMICategory = membersBMICategory + member.toString() + "\n\n";
                }
            }
            if(membersBMICategory.equals(""))
            {
                return "There are no members in the gym in this category";
            }
            else
            {
                return membersBMICategory;
            }
        }
        else
        {
            return "there are no members in the gym";
        }
    }


    /**
     * List all the members' weight and height both imperically and metrically.
     *
     * @return
     * <pre>Each member in the gym with the weight and height listed both imperically and metrically.
     *
     * The format of the output is like so:
     *
     *     Joe Soap:   xx kg (xxx lbs)       x.x metres (xx inches).
     *     Joan Soap:  xx kg (xxx lbs)       x.x metres (xx inches).
     *
     * If there are no members in the gym, the message
     *     "There are no members in the gym" should be returned.
     *    </pre>
     */
    public String listMemberDetailsImperialAndMetric()
    {
        if (members.size() > 0)
        {
            String listOfMembersImpAndMet = "";
            //for (int index = 0; index < members.size(); index++)
            //Changed the above line of code to a For Each as it allows me to get rid of '.get(index)' below, thus making code shorter.
            for(Member member : members)
            {
                listOfMembersImpAndMet = listOfMembersImpAndMet + member.getName() + ":\t"
                       // + member.getStartingWeight() + " kg (" //TODO: assessment.getWeigth()??
                        + member.latestAssessment().getWeight() + " kg ("
                        + Analytics.convertWeightKGtoPounds(member.getHeight()) + " lbs)\t" //TODO: assessment.getHeight()???
                        + member.getHeight() + " metres ("
                        //+ Analytics.convertHeightMetresToInches(member.getStartingWeight()) + " inches).\n"; //TODO: assessment.getWeigth()??
                        + Analytics.convertHeightMetresToInches(member.latestAssessment().getWeight()) + " inches).\n";
            }
            return listOfMembersImpAndMet;
        }
        else
        {
            return "There are no members in the gym";
        }
    }

    public void addAssessment(Assessment newAssessment)
    {
    //    searchMembersByEmail().addAssessment();
    }

    //TODO:????????????????????????????????
    //check to see if email entered already exists.
    public boolean isActiveMemberEmail(String email)
    {
        for (Member member : members)
        {
            if (member.getEmail().equals(email)) return true;
        }
        return false;
    }

    //check to see if trainer email already exists
    public boolean isActiveTrainerEmail(String email)
    {
        for (Trainer trainer : trainers)
        {
            if (trainer.getEmail().equals(email)) return true;
        }
        return false;
    }

    public String searchMemberEmail(String emailSearch)
    {
        for (Member member : members)
        {
            if (member.getEmail().equals(emailSearch)) return member.toString();
        }
        return "\nThere are no members matching this email";
    }

    public String searchMemberName(String nameSearch)
    {
        for (Member member : members)
        {
            if (member.getName().equals(nameSearch)) return member.toString();
        }
        return "\nThere are no members matching this name";
    }

    public String searchTrainerEmail(String emailSearch)
    {
        for (Trainer trainer : trainers)
        {
            if (trainer.getEmail().equals(emailSearch)) return trainer.toString();
        }
        return "\nThere are no members matching this email";
    }

    public Trainer searchMembersTrainerEmail(String trainerEmail)
    {
        for (Trainer trainer : trainers)
        {
            if (trainer.getEmail().equals(trainerEmail)) return trainer;
        }
        return null;
    }

    public Member searchMembersbyEmail(String emailSearch)
    {
        for (Member member : members)
        {
            if (member.getEmail().equals(emailSearch)) return member;
        }
        return null;
    }


    public void load() throws Exception
    {
        //TODO
    }

    public void store() throws Exception
    {
        //TODO
    }



}
