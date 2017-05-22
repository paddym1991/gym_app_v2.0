package controllers;

import models.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Paddym1991 on 22/05/2017.
 */
class GymApiTest {

    private GymApi gym;
    private StudentMember studentMember1;
    private PremiumMember premiumMember1;
    private Trainer trainer1;
    private Trainer trainer2;
    private Assessment assessment1;
    private Assessment assessment2;
    private Assessment assessment3;
    private Assessment assessment4;

    @BeforeEach
    void setUp() throws Exception {
        gym = new GymApi();

        studentMember1 = new StudentMember("stu1@gmail.com", "ppppppppppppppppppppppppppppp", "Studenttown1", "M", 1.5, 50, "WIT", "4564", "WIT");

        premiumMember1 = new PremiumMember("pre1@gmail.com", "ppppppppppppppppppppppppppppp", "Premiumtown1", "M", 1.5, 50, "Package 1");

        trainer1 = new Trainer("tim@tmail.com", "Timmy Timson","Timmytown","M", "Training");

        trainer2 = new Trainer("ruth@rmail.com", "Ruth Ruthson","Ruthstown","F","Legs");

        assessment1 = new Assessment(105.6, 44, 35, 30, 31, 50, "Good job", trainer1);
        assessment2 = new Assessment(50, 20, 20, 20, 20, 20, "Keep it up", trainer2);

    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void addMember() {
        gym.addMember(studentMember1);
    }

    @Test
    void addTrainer() {
    }

    @Test
    void numberOfMembers() {
    }

    @Test
    void numberOfTrainers() {
    }

    @Test
    void getMembers() {
    }

    @Test
    void getTrainers() {
    }

    @Test
    void isValidMemberIndex() {
    }

    @Test
    void isValidTrainerIndex() {
    }

    @Test
    void searchMembersByEmail() {
    }

    @Test
    void searchMembersByName() {
    }

    @Test
    void searchTrainersByEmail() {
    }

    @Test
    void listMembers() {
    }

    @Test
    void listMembersWithIdealWeight() {
    }

    @Test
    void listBySpecificBMICategory() {
    }

    @Test
    void addAssessment() {
    }

    @Test
    void isActiveMemberEmail() {
    }

    @Test
    void isActiveTrainerEmail() {
    }

    @Test
    void searchMemberEmail() {
    }

    @Test
    void searchMemberName() {
    }

    @Test
    void searchTrainerEmail() {
    }

    @Test
    void searchMembersTrainerEmail() {
    }

    @Test
    void searchMembersbyEmail() {
    }

    @Test
    void load() {
    }

    @Test
    void save() {
    }

}