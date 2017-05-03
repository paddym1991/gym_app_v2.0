package controllers;

import models.GymApi;
import models.Member;
import models.Trainer;
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
        return input.getIntInput();
    }


    public void runGymMenu()
    {
        int userOption = gymMenu();
        while (userOption != 0)
        {
            switch (userOption)
            {
                case 1: System.out.println("Please enter your email address: ");
                        input.getStringInput();
                        //TODO: verify email
                break;
                case 2: System.out.println("Please enter your email address: ");
                        input.getStringInput();
                        //TODO: verify email
                break;
                case 3: addMember();
                break;
                case 4: addTrainer();
                break;
                default: System.out.println("\nInvalid option entered: " + userOption);
                break;
            }
            System.out.println("\nPress Enter to continue. . .");
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
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        //input.nextLine();
        return input.getIntInput();
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
        System.out.println("  7) Assessments");
        System.out.println("  8) Reports");
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        //input.nextLine();
        return input.getIntInput();
    }

    private void addMember()
    {
        String memberType = "";
        memberType = memberType.toUpperCase();
        if ((memberType.equals("S")) || (memberType.equals("P")))
        {
            memberType = memberType;
        }
        System.out.print("Student or Premium ('S' or 'P')");
        input.getStringInput();

        input.getStringInput();
        System.out.println("Please enter the following member details...");



            System.out.print("\tstudentId: ");
            int studentId = input.getIntInput();
            input.getIntInput();

            System.out.print("\tCollege: ");
            String collegeName = input.getStringInput();
            input.getStringInput();


        System.out.print("\temail: ");
        String email = input.getStringInput();

        System.out.print("\tName (max 30 chars): ");
        String name = input.getStringInput();

        System.out.print("\tAddress: ");
        String address = input.getStringInput();

        System.out.print("\tHeight (between 1 and 3 metres): ");
        double height = input.getDoubleInput();

        System.out.print("\tStarting weight (between 35kg and 250kg): ");
        double startingWeight = input.getDoubleInput();
        input.getStringInput();

        System.out.print("\tGender (M/F): ");
        String gender = input.getStringInput();

        System.out.print("\tChosen Package: ");
        String chosenPackage = input.getStringInput();

       // gym.addMember(new Member(studentId, collegeName, email, name, address, height, startingWeight, gender, chosenPackage));

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

}
