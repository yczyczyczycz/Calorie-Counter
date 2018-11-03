package ui;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.NotValidInputException;
import exceptions.NotValidOptionException;
import model.DailyCount;
import model.Person;

/** The Main class contains the main method that will run the program.
 **
 */
public class Main
{
    //Main that runs the program
    public static void main(String[] args)
    {
        runCalorieCounter();
    }

    /** Creates a DailyCount object that will track a user's caloric activities.
     ** It will asks the user for input until the user exits the program.
     ** For now there is an option to print out what the user inputted.
     */
    public static void runCalorieCounter()
    {
        int userInput;
        Scanner reader = new Scanner(System.in);
        DailyCount day = new DailyCount();
        Person user;

        System.out.println("1 to create a new user. 2 to load user from a text file.");
        userInput = reader.nextInt();
        if(userInput == 1)
        {
           user = InputHelper.setUpCorrectUser(reader);
            System.out.println(user.toString());
        }
        else
        {
            user = new Person();
            InputHelper.loadCorrectFile(reader, user);

            System.out.println("You loaded user info:");
            System.out.println(user.toString());
        }
        user.addDayCount(day);
        InputHelper.exeCommands(user, day, reader);
        reader.close();
    }
}
