package events;

import java.util.Scanner;

import exceptions.NotValidInputException;
import exceptions.NotValidOptionException;
import model.Person;

public class InputEvent {

    /** Gets the input from user and returns as an integer.
     ** @return the user input as an integer.
     */
    public static int getOption(Scanner reader) throws NotValidOptionException
    {
        System.out.println("1 to input a meal.");
        System.out.println("2 to input a workout session.");
        System.out.println("3 to print out the total amount of calories of the day.");
        System.out.println("4 to print out a list of meals and workouts.");
        System.out.println("5 to save the day's record to a text file and start a new day.");
        System.out.println("6 to calculate the daily calorie difference.");
        System.out.println("0 to exit program");
        int n = reader.nextInt();
        reader.nextLine();
        if(n < 0 || n > 7)
            throw new NotValidOptionException();
        return n;
    }

    //EFFECTS: Set up the user
    public static Person setUpUser(Scanner reader) throws NotValidInputException
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
        
        rate = calculateBMR(age, height, weight, gender);

        Person user = new Person(name, age, height, weight, gender, rate);

        return user;
    }

    //REQUIRES: double height in cm, double weight in kg, int age is greater than 0, false is male and true is female
    //EFFECTS: Returns the BMR as a double
    public static double calculateBMR(int age, double height, double weight, boolean gender)
    {
        double rate;

        //female
        if(gender)
            rate = Math.round(655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age));
        //male
        else
            rate = Math.round(66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age));

        return rate;
    }
}
