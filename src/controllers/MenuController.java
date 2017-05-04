package controllers;

import models.*;
import utils.ScannerInput;

/**
 * Created by Paddym1991 on 03/05/2017.
 */
public class MenuController {

    private ScannerInput input;
    private GymApi gym;



    /**
     * <pre>
     * The default constructor. The constructor creates an instance of the Scanner class. It also asks the user to enter as a trainer and a member. These details are used to create an instance of the Gym. The final task in the constructor is to run the menu.
     * </pre>
     */
    public MenuController()
    {
        input = new ScannerInput();
        gym = new GymApi();

        runGymMenu();
    }

    public static void main(String[] args)
    {
        MenuController menu = new MenuController();
        menu.runGymMenu();
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
                case 1: input.getStringInput();
                        System.out.println("Please enter your email address: ");
                        String memberEmail = input.getStringInput();
                    //TODO: verify email
                        while (!gym.isActiveEmail(memberEmail))
                        {
                            System.out.println("Access Denied!\n");
                            input.getStringInput();
                            runGymMenu();
                        }
                        runMemberMenu();
                break;
                case 2: input.getStringInput();
                        System.out.println("Please enter your email address: ");
                        String trainerEmail = input.getStringInput();
                    //TODO: verify email
                        while (!gym.isActiveEmail(trainerEmail))
                        {
                            System.out.println("Access Denied!\n");
                            input.getStringInput();
                            runGymMenu();
                        }
                        runTrainerMenu();
                break;
                case 3: addMember();
                break;
                case 4: addTrainer();
                break;
                default: System.out.println("\nInvalid option entered: " + userOption);
                break;
            }
            System.out.println("\nPress Enter to continue. . .");
            input.getStringInput();
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
        System.out.println("  0) Exit to Main Menu");
        return input.validNextInt("> ");
    }

    private void runMemberMenu()
    {
        int userOption = memberMenu();
        while (userOption != 0)
        {
            switch (userOption)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
        System.out.println("  5) List members with ideal starting weight");
        System.out.println("  6) List members with a specific BMI category");
        System.out.println("  7) Assessment sub-menu");
        System.out.println("  8) Reports sub-menu");
        System.out.println("  0) Exit to Main Menu");

        return input.validNextInt("> ");
    }

    private void runTrainerMenu()
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
                        System.out.println("Enter Member's Email:\n");
                        String emailSearch = input.getStringInput().toUpperCase();
                        if (gym.isActiveEmail(emailSearch))
                        {
                            return ; //TODO finish this off
                        }
                    break;
                case 4: //TODO: Search for a member by name
                    break;
                case 5: System.out.println(gym.listMembersWithIdealWeight());
                    break;
                case 6: //System.out.println("");gym.listBySpecificBMICategory(members);
                        System.out.print("Please enter a specific BMI category: ");
                        input.getStringInput();
                        String category = input.getStringInput();
                    //input.nextLine();
                        System.out.println(gym.listBySpecificBMICategory(category));
                    break;
                case 7: System.out.println(" 1) Add Assessment for a member.");
                        System.out.println(" 2) Update comment on an assessment for a member.");
                        int assessmentChoice = input.validNextInt("> ");
                        if (assessmentChoice == 1)
                        {
                           // Member.setAssessment(assessment);
                            System.out.println("Add assessment for a member");
                        }
                        else if (assessmentChoice == 2)
                        {
                            System.out.println("update comment for a member");
                            //TODO: update comment
                        }
                        else
                        {
                            System.out.println("Invalid option");
                            input.getStringInput();
                        }
                    break;
                case 8: //TODO: reports sub-menu
                    break;
                default: System.out.println("\nInvalid option entered: " + userOption);
                    break;
            }
            System.out.println("\nPress Enter to continue. . .");
            input.getStringInput();
            // input.nextLine();
            //input.nextLine();
            userOption = trainerMenu();
        }
        runGymMenu();
    }

    private void addMember()
    {
        //String memberType = "";
        //memberType = memberType.toUpperCase();
        input.getStringInput();

        //User asked whether the member being added is a student or not
        System.out.println("Student or Premium ('S' or 'P'): ");
        String memberType = input.getStringInput().toUpperCase();
        if ((memberType.equals("S")) || (memberType.equals("P")))
        {
            //following member details are to be given
            System.out.println("Please enter the following member details...");

            System.out.print("\temail: ");
            String email = input.getStringInput();
            while (gym.isActiveEmail(email))
            {
                System.out.println("Email already exists\n");
                System.out.println("Please enter another Email address:");
                email = input.getStringInput();
            }

            System.out.print("\tName (max 30 chars): ");
            String name = input.getStringInput();

            System.out.print("\tAddress: ");
            String address = input.getStringInput();

            System.out.print("\tHeight (between 1 and 3 metres): ");
            double height = input.validNextDouble("> ");

            System.out.print("\tStarting weight (between 35kg and 250kg): ");
            double startingWeight = input.validNextDouble("> ");
            input.getStringInput();

            System.out.print("\tGender (M/F): ");

            String gender = input.getStringInput();

            System.out.print("\tChosen Package: ");
            String chosenPackage = input.getStringInput();

            //If member type is student then user will give further information.
            if (memberType.equals("S"))
            {
                System.out.print("\tstudentId: ");
                int studentId = input.validNextInt("> ");


                System.out.print("\tCollege: ");
                String collegeName = input.getStringInput();
                input.getStringInput();

                //All information inserted including student details are added.
                gym.addMember(new StudentMember(email, name, address, gender, height, startingWeight, chosenPackage, studentId, collegeName));
            }
            else
            {
                //if P was chosen, all details up to chosen package will be added to gym
                gym.addMember(new PremiumMember(email, name, address, gender, height, startingWeight, chosenPackage));
            }
        }
        else
        {
            //if neither 'S' nor 'P' wer chosen this message will follow. User will then exit back to menu
            System.out.println("Invalid Option");
        }
        input.getStringInput();
        System.out.println("Member successfully added!");
    }

    private void addTrainer()
    {
        input.getStringInput();
        System.out.println("Please enter the following member details...");

        System.out.print("\temail: ");
        String email = input.getStringInput();
        //TODO: if email is already in use, tell them invalid, ask to submit again.

        System.out.print("\tName (max 30 chars): ");
        String name = input.getStringInput();

        System.out.print("\tAddress: ");
        String address = input.getStringInput();

        System.out.print("\tGender (M/F): ");
        String gender = input.getStringInput();

        System.out.print("\tSpeciality: ");
        String speciality = input.getStringInput();

        gym.addTrainer(new Trainer(email, name, address, gender, speciality));
    }

    //TODO: not sure whether to use this above or not
    public String enterEmail()
    {
        String email = input.getStringInput();
        while (gym.isActiveEmail(email))
        {
            System.out.println("Email already exists\n");
            System.out.println("Please enter another Email address:");
            email = input.getStringInput();
        }
        return email;
    }

}
