package model;
import interfaces.Saveable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 **
 */
public class DailyCount
{
    private ArrayList<CalorieIn> food;
    private ArrayList<CalorieOut> activity;

    //MODIFIES: this
    //EFFECTS: Constructs a DailyCount object that keep tracks of calories in and out
    public DailyCount()
    {
        food = new ArrayList<>();
        activity = new ArrayList<>();
    }

    //EFFECTS: Asks the user for the food consumed as a String input and stores it
    public void foodEvent(Scanner reader)
    {
        System.out.println("Please type 1 for food and 2 for drink.");
        int userInput = reader.nextInt();
        if(userInput == 1)
        {
            System.out.println("Please type the food you ate.");
            String input = reader.next();
            addFood(input);
        }

        else if(userInput == 2)
        {
            System.out.println("Please type the drink you drank.");
            String input = reader.next();
            System.out.println("Please type the amount in ml");
            double amount = reader.nextDouble();
            addDrink(input, amount);
        }

    }

    //MODIFIES: this
    //EFFECTS: Adds one food item to the daily count
    public void addFood(String ate)
    {
        Food justAte = new Food(ate);
        food.add(justAte);
    }

    //MODIFIES: this
    //EFFECTS: Adds one drink item to the daily count
    public void addDrink(String ate, double amount)
    {
        Drink justDrank = new Drink(ate, amount);
        food.add(justDrank);
    }

    //EFFECTS: Returns the number of food items.
    public int getFoodCount()
    {
        return food.size();
    }


    //MODIFIES: this
    //EFFECTS: Asks the user for the activity as a String input and stores it
    public void workoutEvent(Scanner reader)
    {
        System.out.println("Please type the activity you did.");
        String input1 = reader.next();
        System.out.println("Please type the duration of the activity in hours.");
        int input2 = reader.nextInt();
        addActivity(input1, input2);
    }

    //REQUIRES: double duration, duration cannot be negative
    //MODIFIES: this
    //EFFECTS: Adds one activity item to the daily count
    public void addActivity(String name, double duration)
    {
        PhysicalActivity justDid = new PhysicalActivity(name, duration);
        activity.add(justDid);
    }

    //EFFECTS: Returns the number of activity items.
    public int getActivityCount()
    {
        return activity.size();
    }

    //EFFECTS: Returns the total net calorie for the day
    public double countCalorie()
    {
        double total = 0;

        for(CalorieIn cur : food)
            total += cur.getCalorie();

        for(CalorieOut cur : activity)
            total -= cur.getCalorie();

        return total;
    }

    //EFFECTS: Prints out all the food and activity for the day
    public String toString()
    {
        String foodList = "";

        for(CalorieIn cur : food)
            foodList += cur.toString();

        String activityList = "";

        for(CalorieOut cur : activity)
            activityList += cur.toString();

        return ("In: " + foodList + "Out: " + activityList);
    }
}
