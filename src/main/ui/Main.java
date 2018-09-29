package ui;
import java.util.Scanner;
import events.inputEvent;
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
        boolean exit = false;
        int userInput;
        Scanner reader = new Scanner(System.in);
        Person user = inputEvent.setUpUser(reader);
        DailyCount day = new DailyCount();

        while(!exit)
        {
            userInput = inputEvent.getOption(reader);
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
        }

        reader.close();
    }


}
