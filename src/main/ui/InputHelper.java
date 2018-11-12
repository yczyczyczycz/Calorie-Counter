package ui;

import exceptions.NotValidInputException;
import exceptions.NotValidOptionException;
import model.DailyCount;
import model.Person;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static void workoutEvent(Scanner reader, DailyCount day)
    {
        System.out.println("Please type the activity you did.");
        String input1 = reader.next();
        System.out.println("Please type the duration of the activity in hours.");
        int input2 = reader.nextInt();
        day.addActivity(input1, input2);
    }

    public static void foodEvent(Scanner reader, DailyCount day)
    {
        System.out.println("Please type 1 for food and 2 for drink.");
        int userInput = 0;
        boolean inputCorrect = false;
        while(!inputCorrect) {
            inputCorrect = true;
            try {
                userInput = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input, please try again.");
                inputCorrect = false;
                reader.next();
            }
        }
        if(userInput == 1)
        {
            System.out.println("Please type the food you ate.");
            String input = reader.next();
            day.addFood(input);
        }

        else if(userInput == 2)
        {
            System.out.println("Please type the drink you drank.");
            String input = reader.next();
            System.out.println("Please type the amount in ml");
            double amount = reader.nextDouble();
            day.addDrink(input, amount);
        }
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

    public static void setUpCorrectUser(Person user, Scanner reader)
    {
        boolean inputCorrect = false;

        while(!inputCorrect) {
            inputCorrect = true;
            try {
                setUpUser(user, reader);
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
                InputHelper.foodEvent(reader, day);
            else if(userInput == 2)
                InputHelper.workoutEvent(reader, day);
            else if(userInput == 3)
                System.out.println("Total calorie standing is " + day.countCalorie() + " calories.");
            else if(userInput == 4)
                System.out.println(day.toString());
            else if(userInput == 5)
            {
                System.out.println("Please enter the file name.");
                user.save(reader.next());
                day = new DailyCount();
                user.addDayCount(day);
            }
            else if(userInput == 6)
                System.out.println("Your daily calorie difference is " + day.dailyCalorieDifference());
            else if(userInput == 7)
            {
                System.out.println("Please enter a day to remove.");
                user.removeDayCount(user.retrieveDay(reader.nextInt()));
            }
            else if(userInput == 8)
            {
                System.out.println(user.toString());
                user.printAllDay();
            }
            else if(userInput == 9)
                setUpCorrectUser(user, reader);
            else
                System.out.println("I did not recognize that command.");
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
                result = getOption(reader);
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
        }
        return result;
    }

    public static void setUpUser(Person user, Scanner reader) throws NotValidInputException
    {
        String name;
        double height;
        double weight;
        int age;
        boolean gender;
        double rate;

        System.out.println("Please input your name:");
        name = reader.next();
        System.out.println("Please input your gender. (m for male, f for female)");
        if(reader.next().equals("m"))
            gender = false;
        else
            gender = true;

        System.out.println("Please input your height in cm.");
        height = reader.nextDouble();
        System.out.println("Please input your weight in kg.");
        weight = reader.nextDouble();
        System.out.println("Please input your age in years.");
        age = reader.nextInt();

        if(name.equals("") || height <= 0 || weight <= 0 || age <= 0)
            throw new NotValidInputException();

        user.changeUserInfo(name, age, height, weight, gender);
        user.setBMR(age, height, weight, gender);
    }

    public static int getOption(Scanner reader) throws NotValidOptionException
    {
        System.out.println("1 to input a meal.");
        System.out.println("2 to input a workout session.");
        System.out.println("3 to print out the total amount of calories of the day.");
        System.out.println("4 to print out a list of meals and workouts.");
        System.out.println("5 to save the day's record to a text file and start a new day.");
        System.out.println("6 to calculate the daily calorie difference.");
        System.out.println("7 to remove a day from the user.");
        System.out.println("8 to print out all the days.");
        System.out.println("9 to change user information.");
        System.out.println("0 to exit program");
        int n = reader.nextInt();
        reader.nextLine();
        if(n < 0 || n > 9)
            throw new NotValidOptionException();
        return n;
    }
}