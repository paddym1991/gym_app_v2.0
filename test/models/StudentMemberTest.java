package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Paddym1991 on 21/05/2017.
 */
class StudentMemberTest {

    private StudentMember studentMember1;
    private StudentMember studentMember2;
    private StudentMember studentMember3;

    @BeforeEach
    public void setUp() throws Exception {
        studentMember1 = new StudentMember("stu1@gmail.com", "ppppppppppppppppppppppppppppp", "Studenttown1", "M", 1.5, 50, "WIT", "4564", "WIT");
        studentMember2 = new StudentMember("stu2@gmail.com", "q6q6q6q6q6q6q6q6q6q6q6q6q6q6q6", "StudentTown2", "F", 1.8, 66.5, "Package 3", "245245fgrf", "NUIG");
        studentMember3 = new StudentMember("stu3@gmail.com", "0000000000000000000000000000001", "123 Well Street", "25Human", 2.5, 220, "WIT", "3434dfdf/''", "WIT");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetStudentId() throws Exception {
        assertEquals("4564", studentMember1.getStudentId());
        assertEquals("245245fgrf", studentMember2.getStudentId());
        assertEquals("3434dfdf/''", studentMember3.getStudentId());
    }

    @Test
    void testSetStudentId() throws Exception {
        studentMember1.setStudentId("big small christmas tree");
        assertEquals("big small christmas tree", studentMember1.getStudentId());
        studentMember2.setStudentId("222222222222222222222222222222222222222");
        assertEquals("222222222222222222222222222222222222222", studentMember2.getStudentId());
        studentMember3.setStudentId("l'0'l'0'l'0;l/0.i;l'p0'l#o]p'i");
        assertEquals("l'0'l'0'l'0;l/0.i;l'p0'l#o]p'i", studentMember3.getStudentId());
    }

    @Test
    void testGetCollegeName() throws Exception {
        assertEquals("WIT", studentMember1.getCollegeName());
        assertEquals("NUIG", studentMember2.getCollegeName());
        assertEquals("WIT", studentMember3.getCollegeName());
    }

    @Test
    void testSetCollegeName() throws Exception {
        studentMember1.setCollegeName("The College");
        assertEquals("The College", studentMember1.getCollegeName());
        studentMember2.setCollegeName("156 . college");
        assertEquals("156 . college", studentMember2.getCollegeName());
        studentMember3.setCollegeName("I am in no college");
        assertEquals("I am in no college", studentMember3.getCollegeName());
    }

    @Test
    void testChosenPackage() throws Exception {
        studentMember1.chosenPackage("WIT");
        assertEquals("WIT", studentMember1.getChosenPackage());
        studentMember2.chosenPackage("Package 3");
        assertEquals("Package 3", studentMember1.getChosenPackage());
        studentMember1.chosenPackage("WIT");
        assertEquals("WIT", studentMember1.getChosenPackage());
    }


    @Test
    void testHeight() throws Exception {
        assertEquals(1.5, studentMember1.getHeight());
        assertEquals(1.8, studentMember2.getHeight());
        assertEquals(2.5, studentMember3.getHeight());
        studentMember1.setHeight(2.9);
        assertEquals(2.9, studentMember1.getHeight());
        studentMember2.setHeight(3.1);
        assertEquals(1.8, studentMember2.getHeight());
        studentMember3.setHeight(0.9);
        assertEquals(2.5, studentMember3.getHeight());
        studentMember3.setHeight(1.1);
        assertEquals(1.1, studentMember3.getHeight());
    }

    @Test
    void testStartingWeight() throws Exception {
        assertEquals(50, studentMember1.getStartingWeight());
        assertEquals(66.5, studentMember2.getStartingWeight());
        assertEquals(220, studentMember3.getStartingWeight());
        studentMember1.setStartingWeight(34.9);
        assertEquals(50, studentMember1.getStartingWeight());
        studentMember2.setStartingWeight(35);
        assertEquals(35, studentMember2.getStartingWeight());
        studentMember3.setStartingWeight(35.1);
        assertEquals(35.1, studentMember3.getStartingWeight());
        studentMember3.setStartingWeight(249.9);
        assertEquals(249.9, studentMember3.getStartingWeight());
        studentMember1.setStartingWeight(250);
        assertEquals(250, studentMember1.getStartingWeight());
        studentMember2.setStartingWeight(35);
        assertEquals(250.1, studentMember2.getStartingWeight());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("STU1@GMAIL.COM", studentMember1.getEmail());
        assertEquals("STU2@GMAIL.COM", studentMember2.getEmail());
        assertEquals("STU3@GMAIL.COM", studentMember3.getEmail());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("pppppppppppppppppppppppppppp", studentMember1.getName());
        assertEquals("q6q6q6q6q6q6q6q6q6q6q6q6q6q6q6", studentMember2.getName());
        assertEquals("000000000000000000000000000000", studentMember3.getName());
    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals("Studenttown1", studentMember1.getAddress());
        assertEquals("Studenttown2", studentMember2.getAddress());
        assertEquals("123 Well", studentMember3.getAddress());
    }

    @Test
    public void testGetGender() throws Exception {
        assertEquals("M", studentMember1.getGender());
        assertEquals("F", studentMember2.getGender());
        assertEquals("Unspecified", studentMember3.getGender());
    }

    @Test
    public void testSetEmail() throws Exception {
        studentMember1.setEmail("Peahead@g.com");
        assertEquals("PEAHEAD@G.COM", studentMember1.getEmail());
        studentMember2.setEmail("152gh@hg.bn");
        assertEquals("152GH@HG.BN", studentMember2.getEmail());
        studentMember3.setEmail("fake@09.'/}");
        assertEquals("FAKE@09.'/}", studentMember3.getEmail());
    }

    @Test
    public void testSetName() throws Exception {
        studentMember1.setName("11111111111111111111111111119");
        assertEquals("11111111111111111111111111119", studentMember1.getName());
        studentMember2.setName("111111111111111111111111111110");
        assertEquals("111111111111111111111111111110", studentMember2.getName());
        studentMember3.setName("1111111111111111111111111111111");
        assertEquals("111111111111111111111111111111", studentMember3.getName());
    }

    @Test
    public void testSetAddress() throws Exception {
        studentMember1.setAddress("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", studentMember1.getAddress());
        studentMember2.setAddress("4444444     22222222");
        assertEquals("4444444     22222222", studentMember2.getAddress());
        studentMember3.setAddress(".2d50..s#][");
        assertEquals(".2d50..s#][", studentMember3.getAddress());
    }

    @Test
    public void testSetGender () throws Exception {
        studentMember1.setGender("M");
        assertEquals("M", studentMember1.getGender());
        studentMember2.setGender("F");
        assertEquals("F", studentMember2.getGender());
        studentMember3.setGender("Female");
        assertEquals("Unspecified", studentMember3.getGender());
        studentMember3.setGender("");
        assertEquals("Unspecified", studentMember3.getGender());
        studentMember1.setGender("789");
        assertEquals("Unspecified", studentMember1.getGender());
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