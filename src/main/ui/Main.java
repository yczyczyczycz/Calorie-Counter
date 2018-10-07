package ui;

import java.util.Scanner;

import events.InputEvent;
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
        Person user;
        System.out.println("1 to create a new user. 2 to load user from a text file.");
        userInput = reader.nextInt();
        if(userInput == 1)
        {
            user = InputEvent.setUpUser(reader);
        }
        else
        {
            System.out.println("Please input the name of your text file.");
            String fileName = reader.next();
            user = new Person();
            user.load(fileName);
            System.out.println("You loaded user info:");
            System.out.println(user.toString());
        }

        DailyCount day = new DailyCount();
        exeCommands(user, day, reader);
        reader.close();
    }

    public static void exeCommands(Person user, DailyCount day, Scanner reader)
    {
        boolean exit = false;
        int userInput;

        while(!exit)
        {
            userInput = InputEvent.getOption(reader);
            if(userInput == 0)
                exit = true;
            else if(userInput == 1)
                day.foodEvent(reader);
            else if(userInput == 2)
                day.workoutEvent(reader);
            else if(userInput == 3)
                System.out.println("Total calorie standing is " + day.countCalorie() + " calories.");
            else if(userInput == 4)
                System.out.println(day.toString());
            else if(userInput == 5)
            {
                String fileName;
                System.out.println("Please enter the file name.");
                fileName = reader.next();
                user.addDayCount(day);
                user.save(fileName);
                day = new DailyCount();
            }
            else if(userInput == 6)
                System.out.println(user.dailyCalorieDifference(day));
        }
    }

}
