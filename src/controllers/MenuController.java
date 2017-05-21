package controllers;

import models.*;
import utils.ScannerInput;

import java.util.*;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Paddym1991 on 03/05/2017.
 */
public class MenuController {

    private ScannerInput input;
    private GymApi gym;
    private String trainerEmail;
    private HashMap<String, String> chosenPackage = new HashMap<>();

    public static void main(String[] args)
    {
        new MenuController();
    }

    /**
     * <pre>
     * The default constructor. The constructor creates an instance of the Scanner class. It also asks the user to enter as a trainer and a member. These details are used to create an instance of the Gym. The final task in the constructor is to run the menu.
     * </pre>
     */
    private MenuController()
    {
        input = new ScannerInput();
        gym = new GymApi();
        this.trainerEmail = trainerEmail;

        chosenPackage.put("Package 1", "Allowed access anytime to gym.\nFree access to all classes.  \nAccess to all changing areas including deluxe changing rooms.");
        chosenPackage.put("Package 2", "Allowed access anytime to gym.\n€3 fee for all classes.  \nAccess to all changing areas including deluxe changing rooms.");
        chosenPackage.put("Package 3", "Allowed access to gym at off-peak times.\n€5 fee for all classes.  \nNo access to deluxe changing rooms.");
        chosenPackage.put("WIT", "Allowed access to gym during term time.\n€4 fee for all classes.  \nNo access to deluxe changing rooms.");

        runGymMenu();
    }


    private int gymMenu()
    {
        //TODO: on app start automatically load gym data from xml file
        System.out.println("=========================================");
        System.out.println("Welcome to 'Skinny Pete's' Fitness Centre");
        System.out.println("=========================================");
        System.out.println("You can either enter as a Trainer or a Member.");
        System.out.println("Please choose one of the following options:");
        System.out.println(" 1) Member Login");
        System.out.println(" 2) Trainer Login");
        System.out.println(" 3) Member Register");
        System.out.println(" 4) Trainer Register");
        System.out.println(" 0) Exit Application");
        //TODO: on app exit automatically save gym data to xml file
        return input.validNextInt("> ");
    }


    public void runGymMenu()
    {
        int userOption = gymMenu();
        while (userOption != 0)
        {
            switch (userOption)
            {
                case 1: System.out.println("Please enter your email address: ");
                        String memberEmail = input.getStringInput().toUpperCase();
                    //TODO: verify email
                        if (!gym.isActiveMemberEmail(memberEmail))
                        {
                            System.out.println("Access Denied!\n");
                            input.getStringInput();
                            runGymMenu();
                        }
                        else {
                            runMemberMenu(gym.searchMembersByEmail(memberEmail));
                        }
                break;
                case 2: System.out.println("Please enter your email address: ");
                        String trainerEmail = input.getStringInput().toUpperCase();
                    //TODO: verify email
                        if (!gym.isActiveTrainerEmail(trainerEmail))
                        {
                            System.out.println("Access Denied!\n");
                            input.getStringInput();
                            runGymMenu();
                        }
                        else {
                            runTrainerMenu(gym.searchTrainersByEmail(trainerEmail));
                        }
                break;
                case 3: addMember();
                break;
                case 4: addTrainer();
                break;
                //TODO: should I add a remove option
                default: System.out.println("\nInvalid option entered: " + userOption);
                break;
            }
            System.out.println("\nPress Enter to continue. . .");
            input.getStringInput();
           // input.nextLine();
            //input.nextLine();
            userOption = gymMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }



    /*
    *
    * memberMenu() - This method displays the members menu for the application,
    * reads the menu option that the user entered and returns it.
    *
    *
    * @return       the users menu choice
    */
    private int memberMenu()
    {
        System.out.println("\fMember Menu");
        System.out.println("---------");
        System.out.println("  1) View profile");
        System.out.println("  2) Update profile");
        System.out.println("  3) Progress");
        System.out.println("  0) Logout");
        return input.validNextInt("> ");
    }

    private void runMemberMenu(Member thisMember)
    {
        int userOption = memberMenu();
        while (userOption != 0)
        {
            switch (userOption)
            {
                case 1: System.out.println(thisMember.toString());
                    break;
                case 2: runUpdateProfile(thisMember);
                    break;
                case 3: runProgressSubMenu(thisMember);
                    break;
                default: System.out.println("\nInvalid option entered: " + userOption);
                    break;
            }
            System.out.println("\nPress Enter to continue. . .");
            input.getStringInput();
            // input.nextLine();
            //input.nextLine();
            userOption = memberMenu();
        }
        runGymMenu();
    }

    /*
    *
    * trainerMenu() - This method displays the trainers menu for the application,
    * reads the menu option that the user entered and returns it.
    *
    *
    * @return       the users menu choice
    */
    private int trainerMenu()
    {
        System.out.println("\fTrainer Menu");
        System.out.println("---------");
        System.out.println("  1) Add a member");
        System.out.println("  2) List all members");
        System.out.println("  3) Search for a member (by email)");
        System.out.println("  4) Search for a member (by name)");
        System.out.println("---------");
        System.out.println("  5) List members with ideal body weight");
        System.out.println("  6) List members with a specific BMI category");
        System.out.println("  7) Assessment sub-menu");
        System.out.println("  8) Reports sub-menu");
        System.out.println("  0) Logout");

        return input.validNextInt("> ");
    }

    private void runTrainerMenu(Trainer thisTrainer)
    {
        int userOption = trainerMenu();
        while (userOption != 0)
        {
            switch (userOption)
            {
                case 1: addMember();
                    break;
                case 2: System.out.println(gym.listMembers());
                    break;
                case 3: //TODO: Search for a member by email
                        System.out.print("\tPlease enter email to search: ");
                        String emailSearch = input.getStringInput().toUpperCase();
                        Member foundM = gym.searchMembersByEmail(emailSearch);
                        if (foundM != null)
                        {
                            System.out.println(foundM.toString());
                        }
                        else
                        {
                            System.out.println("There are no members matching this email: " + emailSearch);
                        }
                    break;
                case 4: //TODO: Search for a member by name
                        System.out.print("\tPlease enter name to search: ");
                        String nameSearch = input.getStringInput();
                        System.out.println(gym.searchMembersByName(nameSearch));
                    break;
                case 5: System.out.println(gym.listMembersWithIdealWeight());
                    break;
                case 6: //System.out.println("");gym.listBySpecificBMICategory(members);
                        System.out.print("\nPlease enter a specific BMI category: \n");
                        String category = input.getStringInput();
                    //input.nextLine();
                        System.out.println(gym.listBySpecificBMICategory(category));
                    break;

                //user given 2 options (one for addAssessment and one for update comment)
                //if user selects 1, they will be prompted to enter email for member they wish to assess.
                //if this member is found then addAssessment() method will be called
                case 7: System.out.println(" 1) Add Assessment for a member.");
                        System.out.println(" 2) Update comment on an assessment for a member.");
                        int assessmentChoice = input.validNextInt("\nPlease choose an option (1 or 2): ");
                        if (assessmentChoice == 1)
                        {
                            System.out.print("\tPlease enter email of the member you want to add assessment to: ");
                            String assessmentEmailSearch = input.getStringInput().toUpperCase();
                            Member assessedMember = gym.searchMembersByEmail(assessmentEmailSearch);

                            if (assessedMember == null)
                            {
                                System.out.println("There are no members matching this email!");
                                input.getStringInput();
                            }
                            else
                            {
                                addAssessment(thisTrainer, assessedMember);
                            }
                        }
                        else if (assessmentChoice == 2)
                        {
                            {
                                System.out.print("\tPlease enter email of the member you want to add comment to: ");
                                String memberEmailComSearch = input.getStringInput().toUpperCase();
                                Member commentMember = gym.searchMembersByEmail(memberEmailComSearch);

                                if (commentMember == null)
                                {
                                    System.out.println("There are no members matching this email!");
                                    input.getStringInput();
                                }
                                else
                                {
                                    System.out.println("Update Comment for: \n" + commentMember.latestAssessment());
                                    System.out.println("Enter updated comment: ");
                                    String commentUpdate = input.getStringInput();

                                    commentMember.latestAssessment().setComment(commentUpdate);
                                    System.out.println("Comment updated for " + commentMember.getName());
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Invalid option");
                            input.getStringInput();
                        }
                    break;
                case 8: //TODO: reports sub-menu
                    int reportOption = reportSubMenu();
                    while (reportOption != 0)
                    {
                        switch (reportOption) {
                            case 1:
                                System.out.print("\tPlease enter email to search: ");
                                String memberEmailReportSearch = input.getStringInput().toUpperCase();
                                Member reportMember = gym.searchMembersByEmail(memberEmailReportSearch);

                                if (reportMember == null) {
                                    System.out.println("There are no members matching this email!");
                                    input.getStringInput();
                                } else {
                                    runProgressSubMenu(reportMember);
                                }
                                break;
                            case 2:
                                System.out.print("\tPlease enter name to search: ");
                                String memberNameReportSearch = input.getStringInput();
                                System.out.println(gym.searchMembersByName(memberNameReportSearch));

                                System.out.print("\tVerify name of member: ");
                                String verifyName = input.getStringInput();

                                for (int i = 0; gym.isValidMemberIndex(i); i++) {
                                    Member verifiedMember = gym.getMembers().get(i);
                                    if (verifiedMember.getName().toUpperCase().equals(verifyName.toUpperCase())) {
                                        runProgressSubMenu(verifiedMember);
                                    }
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("\nInvalid option entered: " + reportOption);
                                break;
                        }
                            System.out.println("\nPress Enter to continue. . .");
                            input.getStringInput();
                            input.getStringInput();
                            reportOption = reportSubMenu();
                    }
                    runTrainerMenu(thisTrainer);
                default: System.out.println("\nInvalid option entered: " + userOption);
                    break;
            }
            System.out.println("\nPress Enter to continue. . .");
            input.getStringInput();
            userOption = trainerMenu();
        }
        runGymMenu();
    }

    private int reportSubMenu()
    {
        System.out.println("\fReport Sub Menu");
        System.out.println("---------");
        System.out.println("  1) Specific member progress (via email search)");
        System.out.println("  2) Specific member progress (via name search)");
        System.out.println("  3) Overall members’ report");
        System.out.println("---------");
        System.out.println("  0) Back to Trainer Menu");

        return input.validNextInt("> ");
    }

    private int progressSubMenu()
    {
        System.out.println("\fProgress Sub Menu");
        System.out.println("---------");
        System.out.println("  1) View progress by weight");
        System.out.println("  2) View progress by chest measurement");
        System.out.println("  3) View progress by thigh measurement");
        System.out.println("  4) View progress by upper arm measurement");
        System.out.println("  5) View progress by waist measurement");
        System.out.println("  6) View progress by hips measurement");
        System.out.println("---------");
        System.out.println("  0) Exit");

        return input.validNextInt("> ");
    }

    private void runProgressSubMenu(Member thisMember) {
        if (thisMember.getAssessment().size() > 0) {
            int progressOption = progressSubMenu();
            while (progressOption != 0) {

                String progress = "";
                switch (progressOption) {
                    case 1: for (Date date : thisMember.sortedAssessmentDates())
                            {
                                //for (int index = thisMember.getAssessment().size() - 1; index < thisMember.getAssessment().size(); index++) {
                                    progress = progress + "\n" + date + "\nWeight: " + thisMember.getAssessment().get(date).getWeight() + "kg\n";
                                //}
                            }
                            progress = "\n" + "Starting Weight:" + thisMember.getStartingWeight() + "kg\n" + progress;
                            System.out.println(progress);
                        break;

                /*
                Map progress = thisMember.getAssessment();
                Map<Date, Assessment> sortedMap = new TreeMap<>(Collections.reverseOrder());
                Iterator<Map.Entry<Date, Assessment>> entries = newMap.entrySet().iterator();
                switch (progressOption) {
                    case 1:
                        System.out.println("Here is a view of your progress by weight: ");
                        while (entries.hasNext()) {
                            Map.Entry<Date, Assessment> entry = entries.next();
                            System.out.println("Date: " + entry.getKey() + "\tWeight: " + entry.getValue().getWeight() + "Kg's");
                        }
                        break;
                        */
                    /*
                    Map<Date, Assessment> sortedMap = thisMember.getAssessment().get(date).descendingMap();
                    switch (progressOption) {
                        case 1:
                    for (Map.Entry<Date, Assessment> entry : sortedMap.entrySet()) {
                        System.out.println("Date : " + entry.getKey() + "\tWeight : " + entry.getValue().getWeight() + "kgs");
                    }
                    */

                /*
                Map progress = thisMember.getAssessment();
                Map<Date, Assessment> map = new TreeMap<>(progress);

                ArrayList<Integer> keys = new ArrayList<Integer>(thisMember.getAssessment().keySet());
                for(int i=keys.size()-1; i>=0;i--){
                    System.out.println(map.get(keys.get(i)));
                }
                break;
                */
                    case 2: for (Date date : thisMember.sortedAssessmentDates())
                            {
                                progress = progress + "\n" + date + "\nChest: " + thisMember.getAssessment().get(date).getChest() + "cm\n";
                            }
                            System.out.println(progress);
                        break;
                    case 3: for (Date date : thisMember.sortedAssessmentDates())
                            {
                                progress = progress + "\n" + date + "\nThigh: " + thisMember.getAssessment().get(date).getThigh() + "cm\n";
                            }
                            System.out.println(progress);
                        break;
                    case 4: for (Date date : thisMember.sortedAssessmentDates())
                            {
                                progress = progress + "\n" + date + "\nUpper Arm: " + thisMember.getAssessment().get(date).getUpperArm() + "cm\n";
                            }
                            System.out.println(progress);
                        break;
                    case 5: for (Date date : thisMember.sortedAssessmentDates())
                            {
                                progress = progress + "\n" + date + "\nWaist: " + thisMember.getAssessment().get(date).getWaist() + "cm\n";
                            }
                            System.out.println(progress);
                    case 6: for (Date date : thisMember.sortedAssessmentDates())
                            {
                                progress = progress + "\n" + date + "\nHips: " + thisMember.getAssessment().get(date).getHips() + "cm\n";
                            }
                            System.out.println(progress);
                    default: System.out.println("\nInvalid option entered: " + progressOption);
                        break;
                }
                System.out.println("\nPress Enter to continue. . .");
                input.getStringInput();
                progressOption = progressSubMenu();
            }
            return;
        }
        else
        {
            System.out.println("\nNo assessments available for " + thisMember.getName());
        }
    }

    private int updateProfile()
    {
        System.out.println("\fUpdate Profile");
        System.out.println("---------");
        System.out.println("  1) Update Email");
        System.out.println("  2) Update Name");
        System.out.println("  3) Update Address");
        System.out.println("  4) Update Gender");
        System.out.println("  5) Update Height");
        System.out.println("  6) Update Starting Weight");
        System.out.println("  7) Update Package");
        System.out.println("---------");
        System.out.println("  0) Exit to Member Menu");

        return input.validNextInt("> ");
    }

    private void runUpdateProfile(Member thisMember) {
        int updateOption = updateProfile();
        while (updateOption != 0)
        {
            switch (updateOption)
            {
                case 1: System.out.println("Enter new name: ");
                        String nameUpdate = input.getStringInput();
                        thisMember.setName(nameUpdate);

                        System.out.println("Name successfully changed to " + thisMember.getName());
                        break;

                case 2: System.out.println("Enter new email: ");
                        String emailUpdate = input.getStringInput().toUpperCase();
                        while ((gym.isActiveMemberEmail(emailUpdate)) || (gym.isActiveTrainerEmail(emailUpdate)))
                        {
                            System.out.println("Email already exists\n");
                            System.out.println("Please enter another Email address:");
                            emailUpdate = input.getStringInput().toUpperCase();
                        }
                        thisMember.setEmail(emailUpdate);

                        System.out.println("Email successfully changed to " + thisMember.getEmail());
                        break;

                case 3: System.out.println("Enter new address: ");
                        String addressUpdate = input.getStringInput();
                        thisMember.setAddress(addressUpdate);

                        System.out.println("Address successfully changed to " + thisMember.getAddress());
                        break;

                case 4: System.out.println("\tEnter new gender (M/F): ");
                        String genderUpdate = input.getStringInput().toUpperCase();
                        while (!((genderUpdate.equals("F")) || (genderUpdate.equals("M"))))
                        {
                            System.out.println("Invalid Option\n");
                            System.out.println("Please enter Gender (M/F): ");
                            genderUpdate = input.getStringInput().toUpperCase();
                        }
                        thisMember.setGender(genderUpdate);

                        System.out.println("Gender successfully changed to " + thisMember.getGender());
                        break;

                case 5: double heightUpdate = input.validNextDouble("\tEnter new height (between 1 and 3 metres): ");
                        while (!((heightUpdate >= 1) && (heightUpdate <= 3)))
                        {
                            System.out.println("Invalid Entry\n");
                            heightUpdate = input.validNextDouble("Enter height (between 1 and 3 metres): ");
                        }
                        thisMember.setHeight(heightUpdate);

                        System.out.println("Height successfully changed to " + thisMember.getHeight());
                        break;

                case 6: double startingWeightUpdate = input.validNextDouble("Enter starting weight (between 35kg and 250kg): ");
                        while (!((startingWeightUpdate >= 35) && (startingWeightUpdate <= 250)))
                        {
                            System.out.println("Invalid Entry\n");
                            startingWeightUpdate = input.validNextDouble("Enter starting weight (between 35kg and 250kg): ");
                        }
                        thisMember.setStartingWeight(startingWeightUpdate);

                        System.out.println("Starting Weight successfully changed to " + thisMember.getStartingWeight());
                        break;

                case 7: System.out.print("\tEnter new Package: ");
                        String chosenPackageUpdate = input.getStringInput();
                        thisMember.setChosenPackage(chosenPackageUpdate);

                        System.out.println("Package successfully changed to " + thisMember.getChosenPackage());
                        break;

                default: System.out.println("\nInvalid option entered: " + updateOption);
                    break;
            }
            System.out.println("\nPress Enter to continue. . .");
            input.getStringInput();
            updateOption = updateProfile();
        }
        runMemberMenu(thisMember);
    }

    private void addMember()
    {
        System.out.println("\nMEMBER REGISTRATION");
        System.out.println("-------------------\n");

        //User asked whether the member being added is a student or not
        System.out.println("Student or Premium ('S' or 'P'): ");
        String memberType = input.getStringInput().toUpperCase();
        while (!((memberType.equals("S")) || (memberType.equals("P"))))
        {
            System.out.println("Invalid Option!\n");
            System.out.println("Please enter Student or Premium ('S' or 'P'): ");
            memberType = input.getStringInput().toUpperCase();
        }
        if ((memberType.equals("S")) || (memberType.equals("P")))
        {
            //following member details are to be given
            System.out.println("Please enter the following member details...");

            System.out.print("\temail: ");
            String email = input.getStringInput().toUpperCase();
            while ((gym.isActiveMemberEmail(email)) || (gym.isActiveTrainerEmail(email)))
            {
                System.out.println("Email already exists\n");
                System.out.println("Please enter another Email address:");
                email = input.getStringInput().toUpperCase();
            }

            System.out.print("\tName (max 30 chars): ");
            String name = input.getStringInput();
            if (name.length() > 30)
            {
                name = name.substring(0, 30);
            }

            System.out.print("\tAddress: ");
            String address = input.getStringInput();

            System.out.print("\tGender (M/F): ");
            String gender = input.getStringInput().toUpperCase();
            while (!((gender.equals("F")) || (gender.equals("M"))))
            {
                System.out.println("Invalid Option\n");
                System.out.println("Please enter Gender (M/F): ");
                gender = input.getStringInput().toUpperCase();
            }

           // System.out.print("\tHeight (between 1 and 3 metres): ");
            double height = input.validNextDouble("\tHeight (between 1 and 3 metres): ");
            while (!((height >= 1) && (height <= 3)))
            {
                System.out.println("Invalid Entry\n");
                height = input.validNextDouble("Enter height (between 1 and 3 metres): ");
            }

           // System.out.print("\tStarting weight (between 35kg and 250kg): ");
            double startingWeight = input.validNextDouble("\tStarting weight (between 35kg and 250kg): ");
            while (!((startingWeight >= 35) && (startingWeight <= 250)))
            {
                System.out.println("Invalid Entry\n");
                startingWeight = input.validNextDouble("Enter weight (between 35kg and 250kg): ");
            }

            if (memberType.equals("P")) {
                String chosenPackage = "";
                int packageChoice = 0;
                while (!((packageChoice == 1) || (packageChoice == 2) || (packageChoice == 3))) {
                    packageChoice = input.validNextInt("\tChosen Package (1, 2 or 3): ");
                    if (packageChoice == 1) {
                        chosenPackage = "Package 1";
                    } else if (packageChoice == 2) {
                        chosenPackage = "Package 2";
                    } else if (packageChoice == 3) {
                        chosenPackage = "Package 3";
                    } else System.out.println("Invalid Option: " + chosenPackage);
                }

                //if P was chosen, all details up to chosen package will be added to gym
                gym.addMember(new PremiumMember(email, name, address, gender, height, startingWeight, chosenPackage));
            }

            //If member type is student then user will give further information.
            else if (memberType.equals("S"))
            {
                System.out.print("\tstudentId: ");
                String studentId = input.getStringInput();

                System.out.print("\tCollege (WIT, NUIG etc.): ");
                String collegeName = input.getStringInput();

                String chosenPackage = "";
                if (collegeName.equals("WIT"))
                {
                    chosenPackage = "WIT";
                }
                else
                {
                    chosenPackage = "Package 3";
                }
                System.out.println("\tChosenPackage: " + chosenPackage);
                input.getStringInput();

                //All information inserted including student details are added.
                gym.addMember(new StudentMember(email, name, address, gender, height, startingWeight, chosenPackage, studentId, collegeName));
            }
        }
        else
        {
            //if neither 'S' nor 'P' wer chosen this message will follow. User will then exit back to menu
            System.out.println("Invalid Option");
        }
        System.out.println("\nMember successfully added!");
    }

    private void addTrainer()
    {
        System.out.println("Please enter the following trainer details...");

        //TODO: if email is already in use, tell them invalid, ask to submit again.
        System.out.print("\temail: ");
        String email = input.getStringInput().toUpperCase();
        while ((gym.isActiveMemberEmail(email)) || (gym.isActiveTrainerEmail(email)))
        {
            System.out.println("Email already exists\n");
            System.out.println("Please enter another Email address:");
            email = input.getStringInput().toUpperCase();
        }

        System.out.print("\tName (max 30 chars): ");
        String name = input.getStringInput();

        System.out.print("\tAddress: ");
        String address = input.getStringInput();

        System.out.print("\tGender (M/F): ");
        String gender = input.getStringInput().toUpperCase();
        while (!((gender.equals("F")) || (gender.equals("M"))))
        {
            System.out.println("Invalid Option\n");
            System.out.println("Please enter Gender (M/F): ");
            gender = input.getStringInput().toUpperCase();
        }

        System.out.print("\tSpeciality: ");
        String speciality = input.getStringInput();

        gym.addTrainer(new Trainer(email, name, address, gender, speciality));
    }

    private void addAssessment(Trainer assessingTrainer, Member assessedMember)
    {
        System.out.println("New Assessment for: \n" + assessedMember.toString());

        System.out.println("\n");
        double weight = input.validNextDouble("Current Weight: ");

        double chest = input.validNextDouble("Current Chest Measurement: ");

        double thigh = input.validNextDouble("Current Thigh Measurement: ");

        double upperArm = input.validNextDouble("Current Upper Arm Measurement: ");

        double waist = input.validNextDouble("Current Waist Measurement: ");

        double hips = input.validNextDouble("Current Hip Measurement: ");

        System.out.println("Trainer Comment on Assessment: ");
        String comment = input.getStringInput();

        assessedMember.addAssessment(new Assessment(weight, chest, thigh, upperArm, waist, hips, comment, assessingTrainer));

        //TODO: check to see whether assessment has been added
        System.out.println("Assessment for " + assessedMember.getName() + " successfully added.");

            /*
            Trainer trainer = gym.searchMembersTrainerEmail(trainerEmail);

            Assessment newAssessment = new Assessment(weight, chest, thigh,
                    upperArm, waist, hips, comment, trainer);

            Date date = new Date();

            gym.searchMembersByEmail(emailSearch).addAssessment(newAssessment);

            //Assessment assessment = new Assessment(weight, chest, thigh, upperArm, waist, hips, comment, trainer);
*/
/*
        System.out.println("Trainer Name: ");
        Trainer trainer = gym.getTrainers().get() searchTrainerEmail(trainerEmail).toString();

        Assessment newAssessment = new Assessment(weight, chest, thigh,
                upperArm, waist, hips, comment, gym.searchMembersTrainerEmail(trainerEmail));
        Date date = new Date();
        gym.searchMembersByEmail(emailSearch).addAssessment(date, newAssessment);
*/
    }

    //TODO: not sure whether to use this above or not
    public String enterEmail()
    {
        String email = input.getStringInput();
        while (gym.isActiveMemberEmail(email))
        {
            System.out.println("Email already exists\n");
            System.out.println("Please enter another Email address:");
            email = input.getStringInput();
        }
        return email;
    }

}
