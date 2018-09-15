package ui;
import java.util.Scanner;
import events.DailyCount;

/** The Main class contains the main method that will run the program.
 **
 */
public class Main
{
    /** Creates a DailyCount object that will track a user's caloric activities.
     ** It will asks the user for input until the user exits the program.
     ** For now there is an option to print out what the user inputted.
     */
    public static void main(String[] args)
    {
        DailyCount day = new DailyCount();
        boolean exit = false;
        int userInput;
        Scanner reader = new Scanner(System.in);

        while(!exit)
        {
            userInput = getInput(reader);
            if(userInput == 0)
                exit = true;
            else if(userInput == 1)
                day.foodEvent(reader);
            else if(userInput == 2)
                day.workoutEvent(reader);
            else if(userInput == 3)
                System.out.println(day.toString());
        }

        reader.close();
    }

    /** Gets the input from user and returns as an integer.
     ** @return the user input as an integer.
     */
    private static int getInput(Scanner reader)
    {
        System.out.println("Please choose 1 to input a meal and 2 to input a workout session. " +
                            "3 to print out a list of meals and workouts. 0 to exit program");
        int n = reader.nextInt();
        reader.nextLine();

        return n;
    }
}
