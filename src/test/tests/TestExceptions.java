package tests;

import exceptions.NotValidInputException;
import model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TestExceptions {
    Person user;

    @BeforeEach
    public void runBefore()
    {
        user = new Person();
    }

    @Test
    public void testLoad()
    {
        try{
            user.load("userTest.txt");
        }catch(FileNotFoundException e) {
            fail("Should not throw this exception.");
        }

        try{
            user.load("iDoNotExist.txt");
            fail("Did not throw exception.");
        }catch(FileNotFoundException e) {}
    }

    @Test
    public void testUserSetup()
    {
        try {
            user = new Person("Bart", 5, 173, 65, true, 1300);
        }catch(NotValidInputException e)
        {
            fail("Should not throw this exception.");
        }

        try {
            user = new Person("Bart", -5, 173, 65, true, 1300);
            fail("Did not throw exception.");
        }catch(NotValidInputException e) {}
    }
}
