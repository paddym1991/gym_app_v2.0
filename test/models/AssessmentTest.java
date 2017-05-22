package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Paddym1991 on 22/05/2017.
 */
class AssessmentTest {

    private Assessment assessment1;
    private Assessment assessment2;
    private Trainer trainer1;
    private Trainer trainer2;

    @BeforeEach
    void setUp() throws Exception {
        assessment1 = new Assessment(105.6, 44, 35, 30, 31, 50, "Good job", trainer1);
        assessment2 = new Assessment(50, 20, 20, 20, 20, 20, "Keep it up", trainer2);

        trainer1 = new Trainer("tim@tmail.com", "Timmy Timson","Timmytown","M", "Training");
        trainer2 = new Trainer("ruth@rmail.com", "Ruth Ruthson","Ruthstown","F","Legs");
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testGetWeight() {
        assertEquals(105.6, assessment1.getWeight());
        assertEquals(50, assessment2.getWeight());
    }

    @Test
    void testGetChest() throws Exception {
        assertEquals(44, assessment1.getChest());
        assertEquals(20, assessment2.getChest());
    }

    @Test
    void testGetThigh() throws Exception {
        assertEquals(35, assessment1.getThigh());
        assertEquals(20, assessment2.getThigh());
    }

    @Test
    void testGetUpperArm() throws Exception {
        assertEquals(30, assessment1.getUpperArm());
        assertEquals(20, assessment2.getUpperArm());
    }

    @Test
    void testGetWaist() throws Exception {
        assertEquals(31, assessment1.getWaist());
        assertEquals(20, assessment2.getWaist());
    }

    @Test
    void testGetHips() throws Exception {
        assertEquals(50, assessment1.getHips());
        assertEquals(20, assessment2.getHips());
    }

    @Test
    void testGetComment() throws Exception {
        assertEquals("Good job", assessment1.getComment());
        assertEquals("Keep it up", assessment2.getComment());
    }

    @Test
    void testSetComment() throws Exception {
        assessment1.setComment("comment1");
        assertEquals("comment1", assessment1.getComment());
        assessment2.setComment("comment2");
        assertEquals("comment2", assessment2.getComment());
    }

    @Test
    void testGetTrainer() throws Exception {
        assertEquals(trainer1, assessment1.getTrainer());
        assertEquals(trainer2, assessment2.getTrainer());
    }

    @Test
    void testToString() throws Exception {
        assertEquals("Weight: 105" + " Kgs"
                + "\nChest: 44" + " Cms"
                + "\nThigh: 35" + " Cms"
                + "\nupperArm: 30" + " Cms"
                + "\nWaist: 31" + " Cms"
                + "\nHips: 50" + " Cms"
                + "\nComment: Good job" + " ."
                + "\nTrainer: Timmy Timson" + " .", assessment1.toString());

        assertEquals("Weight: 50" + " Kgs"
                + "\nChest: 20" + " Cms"
                + "\nThigh: 20" + " Cms"
                + "\nupperArm: 20" + " Cms"
                + "\nWaist: 20" + " Cms"
                + "\nHips: 20" + " Cms"
                + "\nComment: Keep it up" + " ."
                + "\nTrainer: Ruth Ruthston" + " .", assessment2.toString());
    }

}