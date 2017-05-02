package models;

import java.util.ArrayList;
import utils.Analytics;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class GymApi {

    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;

    public GymApi(ArrayList<Member> members, ArrayList<Trainer> trainers)
    {
        this.members = members;
        this.trainers = trainers;
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

    //TODO:
    public boolean isValidMemberIndex(int index)
    {
        return false;
    }

    //TODO:
    public boolean isValidTrainerIndex(int index)
    {
        return false;
    }

    //TODO:
    public Member searchMembersByEmail(String emailEntered)
    {
        return null;
    }

    //TODO:
    public String searchMembersByName(String nameEntered)
    {
        return null;
    }

    //TODO:
    public Person searchTrainersByEmail(String emailEntered)
    {
        return null;
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
                if(members.get(index).isIdealBodyWeight() == true)
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
                if (determineBMICategory().contains(category))
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
                listOfMembersImpAndMet = listOfMembersImpAndMet + member.getMemberName() + ":\t"
                        + member.getStartingWeight() + " kg ("
                        + member.convertWeightKGtoPounds() + " lbs)\t"
                        + member.getHeight() + " metres ("
                        + member.convertHeightMetresToInches() + " inches).\n";
            }
            return listOfMembersImpAndMet;
        }
        else
        {
            return "There are no members in the gym";
        }
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
