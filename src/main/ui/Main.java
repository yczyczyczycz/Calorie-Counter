package ui;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import events.InputEvent;
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
           user = setUpCorrectUser(reader);
            System.out.println(user.toString());
        }
        else
        {
            user = new Person();
            loadCorrectFile(reader, user);

            System.out.println("You loaded user info:");
            System.out.println(user.toString());
        }
        exeCommands(user, day, reader);
        reader.close();
    }

    public static void loadCorrectFile(Scanner reader, Person user)
    {
        boolean inputCorrect = false;
        while(!inputCorrect)
        {
            inputCorrect = true;
            System.out.println("Please input the name of your text file.");
            String fileName = reader.next();

            try {
                user.load(fileName);
            }catch(FileNotFoundException e)
            {
                inputCorrect = false;
                System.out.println("No file of such name, please input again.");
            }
            finally
            {
                System.out.println("Enter any key to continue, 0 to exit.");
                if(reader.next().equals("0"))
                    System.exit(0);
            }
        }
    }

    public static Person setUpCorrectUser(Scanner reader)
    {
        boolean inputCorrect = false;
        Person user = new Person();
        while(!inputCorrect) {
            inputCorrect = true;
            try {
                user = InputEvent.setUpUser(reader);
            } catch (NotValidInputException e) {
                inputCorrect = false;
                System.out.println("Invalid input. Please input again.");
            } catch (InputMismatchException e) {
                inputCorrect = false;
                System.out.println("Invalid input. Please enter again.");
                reader.next();
            } catch (RuntimeException e){
                inputCorrect = false;
                System.out.println("Unexpected error. Please enter again.");
            }
            finally
            {
                System.out.println("Enter any key to continue, 0 to exit.");
                if(reader.next().equals("0"))
                    System.exit(0);
            }
        }
        return user;
    }

    public static void exeCommands(Person user, DailyCount day, Scanner reader)
    {
        boolean exit = false;
        int userInput;

        while(!exit)
        {
            userInput = getCorrectOptions(reader);
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

    public static int getCorrectOptions(Scanner reader)
    {
        boolean inputCorrect = false;
        int result = 0;
        while(!inputCorrect)
        {
            inputCorrect = true;
            try{
                result = InputEvent.getOption(reader);
            }catch(NotValidOptionException e)
            {
                inputCorrect = false;
                System.out.println("Not a valid option. Please enter again.");
            }catch(InputMismatchException e)
            {
                inputCorrect = false;
                System.out.println("Not a valid option. Please enter again.");
            }catch (RuntimeException e){
                inputCorrect = false;
                System.out.println("Unexpected error. Please enter again.");
            }
            finally
            {
                System.out.println("Enter any key to continue, 0 to exit.");
                if(reader.next().equals("0"))
                    System.exit(0);
            }
        }
        return result;
    }
}
