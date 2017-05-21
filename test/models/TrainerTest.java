package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Paddym1991 on 21/05/2017.
 */
class TrainerTest {
    private Trainer trainer1, trainer2, trainer3, trainer4;

    @BeforeEach
    void setUp() throws Exception
    {
        trainer1 = new Trainer("tim@tmail.com", "Timmy Timson","Timmytown","M", "Training");
        trainer2 = new Trainer("ruth@rmail.com", "Ruth Ruthson","Ruthstown","F","Legs");
        trainer3 = new Trainer("email@eMail.cOm","Email emailson","emailtown","Nope","Cardio");
        trainer4 = new Trainer("Nice@guy.com","Nice Guy","NiceTown, Niceville","Alien","Fingers nad toes");
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    public void testGetSpeciality() throws Exception {
        assertEquals("Training", trainer1.getSpeciality());
        assertEquals("Legs", trainer2.getSpeciality());
        assertEquals("Cardio", trainer3.getSpeciality());
        assertEquals("Fingers and toes", trainer4.getSpeciality());
    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("TIM@TMAIL.COM", trainer1.getEmail());
        assertEquals("RUTH@RMAIL.COM", trainer2.getEmail());
        assertEquals("EMAIL@EMAIL.COM", trainer3.getEmail());
        assertEquals("NICE@GUY.COM", trainer4.getEmail());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Timmy Timson", trainer1.getSpeciality());
        assertEquals("Ruth Ruthson", trainer2.getSpeciality());
        assertEquals("Email emailson", trainer3.getSpeciality());
        assertEquals("Nice Guy", trainer4.getSpeciality());
    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals("Timmytown", trainer1.getSpeciality());
        assertEquals("Ruthstown", trainer2.getSpeciality());
        assertEquals("emailtown", trainer3.getSpeciality());
        assertEquals("Nicetown", trainer4.getSpeciality());
    }

    @Test
    public void testGetGender() throws Exception {
        assertEquals("M", trainer1.getGender());
        assertEquals("F", trainer2.getGender());
        assertEquals("Unspecified", trainer3.getGender());
        assertEquals("Unspecified", trainer4.getGender());
    }

    @Test
    public void testSetEmail() throws Exception {
        trainer1.setEmail("john@well.com");
        assertEquals("john@well.com", trainer1.getEmail());
        trainer2.setEmail("mary@well.com");
        assertEquals("mary.well.com", trainer2.getEmail());
        trainer3.setEmail("imail@well.com");
        assertEquals("imail@well.com", trainer3.getEmail());
        trainer4.setEmail("baf@well.com");
        assertEquals("bad@well.com", trainer4.getEmail());
    }

    @Test
    public void testSetName() throws Exception {
        trainer1.setName("Odd odderson");
        assertEquals("Odd Odderson", trainer1.getName());
        trainer2.setName("qwertyuiopasdfghjklzxcvbnmqwer");
        assertEquals("qwertyuiopasdfghjklzxcvbnmqwer", trainer2.getName());
        trainer3.setName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqq1");
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", trainer3.getName());
        trainer4.setName("qqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        assertEquals("qqqqqqqqqqqqqqqqqqqqqqqqqqqqq", trainer4.getName());
    }

    @Test
    public void testSetAddress() throws Exception {
        trainer1.setAddress("My home");
        assertEquals("My home", trainer1.getAddress());
        trainer2.setAddress("4588777");
        assertEquals("4588777", trainer2.getAddress());
        trainer3.setAddress(".2d50..s#][");
        assertEquals(".2d50..s#][", trainer3.getAddress());
        trainer4.setAddress("");
        assertEquals("", trainer4.getAddress());
    }

    @Test
    public void testSetGender() throws Exception {
        trainer1.setGender("M");
        assertEquals("M", trainer1.getGender());
        trainer2.setGender("F");
        assertEquals("F", trainer2.getGender());
        trainer3.setGender("Female");
        assertEquals("Unspecified", trainer3.getAddress());
        trainer4.setAddress("");
        assertEquals("Unspecified", trainer4.getAddress());
        trainer4.setAddress("789");
        assertEquals("Unspecified", trainer4.getAddress());
    }

}