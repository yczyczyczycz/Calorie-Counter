package tests;

import model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TestSaveAndLoad {
    private Person user;

    @BeforeEach
    public void runBefore()
    {
        user = new Person();
    }

    //Test load.
    @Test
    public void testSaveAndLoad()
    {
        //Superman, 24years old, 180cm, 60kg, 24years old, 180cm, male
        user.changeUserInfo("Superman", 24, 182, 65, false);
        System.out.println(user.toString());
        user.save("userTest.txt");
        Person user2 = new Person();
        try{
            user2.load("userTest.txt");
        }catch(FileNotFoundException e){}
        System.out.println(user2.toString());
        assertTrue(user.toString().equals(user2.toString()));
    }
}