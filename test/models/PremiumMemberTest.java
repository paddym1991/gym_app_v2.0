package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Paddym1991 on 21/05/2017.
 */
class PremiumMemberTest {

    private PremiumMember premiumMember1;
    private PremiumMember premiumMember2;

    @BeforeEach
    void setUp() throws Exception {
        premiumMember1 = new PremiumMember("pre1@gmail.com", "ppppppppppppppppppppppppppppp", "Premiumtown1", "M", 1.5, 50, "Package 1");
        premiumMember2 = new PremiumMember("pre2@gmail.com", "q6q6q6q6q6q6q6q6q6q6q6q6q6q6q6", "Premiumtown2", "F", 1.8, 66.5, "Package 2");
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testChosenPackage() {
        premiumMember1.chosenPackage("Package 1");
        assertEquals("Package 1", premiumMember1.getChosenPackage());

        premiumMember2.chosenPackage("Package 2");
        assertEquals("Package 222", premiumMember2.getChosenPackage());

        premiumMember1.chosenPackage("Nope");
        assertEquals("Nothing", premiumMember1.getChosenPackage());
    }

    @Test
    void testHeight() throws Exception {
        assertEquals(1.5, premiumMember1.getHeight());
        assertEquals(1.8, premiumMember2.getHeight());
        premiumMember1.setHeight(2.9);
        assertEquals(2.9, premiumMember1.getHeight());
        premiumMember2.setHeight(3.1);
        assertEquals(1.8, premiumMember2.getHeight());
        premiumMember1.setHeight(3.0);
        assertEquals(3.0, premiumMember1.getHeight());
        premiumMember1.setHeight(0.9);
        assertEquals(1.5, premiumMember1.getHeight());
        premiumMember2.setHeight(1.1);
        assertEquals(1.1, premiumMember2.getHeight());
        premiumMember2.setHeight(1.0);
        assertEquals(1.0, premiumMember2.getHeight());
    }

    @Test
    void testStartingWeight() throws Exception {
        assertEquals(50, premiumMember1.getStartingWeight());
        assertEquals(66.5, premiumMember2.getStartingWeight());
        premiumMember1.setStartingWeight(34.9);
        assertEquals(50, premiumMember1.getStartingWeight());
        premiumMember2.setStartingWeight(35);
        assertEquals(35, premiumMember2.getStartingWeight());
        premiumMember1.setStartingWeight(35.1);
        assertEquals(35.1, premiumMember1.getStartingWeight());
        premiumMember2.setStartingWeight(249.9);
        assertEquals(249.9, premiumMember2.getStartingWeight());
        premiumMember1.setStartingWeight(250);
        assertEquals(250,premiumMember1.getStartingWeight());
        premiumMember2.setStartingWeight(35);
        assertEquals(250.1, premiumMember2.getStartingWeight());
    }


    @Test
    public void testGetEmail() throws Exception {
        assertEquals("PRE1@GMAIL.COM", premiumMember1.getEmail());
        assertEquals("PRE2@GMAIL.COM", premiumMember2.getEmail());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("pppppppppppppppppppppppppppp", premiumMember1.getName());
        assertEquals("q6q6q6q6q6q6q6q6q6q6q6q6q6q6q6", premiumMember2.getName());

    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals("Premiumtown1", premiumMember1.getAddress());
        assertEquals("Premiumtown2", premiumMember2.getAddress());
    }

    @Test
    public void testGetGender() throws Exception {
        assertEquals("M", premiumMember1.getGender());
        assertEquals("F", premiumMember2.getGender());
    }

    @Test
    public void testSetEmail() throws Exception {
        premiumMember1.setEmail("john@john.john");
        assertEquals("JOHN@JOHN.JOHN", premiumMember1.getEmail());
        premiumMember2.setEmail("787hgg@n.b");
        assertEquals("787HGG@N.B", premiumMember2.getEmail());
    }

    @Test
    public void testSetName() throws Exception {
        premiumMember1.setName("11111111111111111111111111129");
        assertEquals("11111111111111111111111111129", premiumMember1.getName());
        premiumMember2.setName("111111111111111111111111111130");
        assertEquals("111111111111111111111111111130", premiumMember2.getName());
        premiumMember1.setName("1111111111111111111111111111131");
        assertEquals("11111111111111111111111111113", premiumMember1.getName());
    }

    @Test
    public void testSetAddress() throws Exception {
        premiumMember1.setAddress("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", premiumMember1.getAddress());
        premiumMember2.setAddress("44555544     22223333322");
        assertEquals("44555544     22223333322", premiumMember2.getAddress());
        premiumMember2.setAddress(".289d0..s#][");
        assertEquals(".289d0..s#][", premiumMember2.getAddress());
    }

    @Test
    public void testSetGender () throws Exception {
        premiumMember1.setGender("M");
        assertEquals("M", premiumMember1.getGender());
        premiumMember2.setGender("F");
        assertEquals("F", premiumMember2.getGender());
        premiumMember1.setGender("Male");
        assertEquals("Unspecified", premiumMember1.getGender());
        premiumMember2.setGender("");
        assertEquals("Unspecified", premiumMember2.getGender());
        premiumMember2.setGender("789");
        assertEquals("Unspecified", premiumMember2.getGender());
    }


    @Test
    void getChosenPackage() {
    }

    @Test
    void setChosenPackage() {
    }

    @Test
    void getAssessment() {
    }

    @Test
    void setAssessment() {
    }

    @Test
    void addAssessment() {
    }

    @Test
    void latestAssessment() {
    }

    @Test
    void previousAssessment() {
    }

    @Test
    void sortedAssessmentDates() {
    }

    @Test
    void chosenPackage1() {
    }

    @Test
    void toString1() {
    }

    @Test
    void toString2() {
    }

}