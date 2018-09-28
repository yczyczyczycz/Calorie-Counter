package model;
import java.util.ArrayList;
import java.util.Scanner;

/**
 **
 */
public class DailyCount
{
    private static int dayCount = 0;
    private ArrayList<Food> food;
    private ArrayList<PhysicalActivity> activity;

    //MODIFIES: this
    //EFFECTS: Constructs a DailyCount object that keep tracks of calories in and out
    public DailyCount()
    {
        dayCount = ++dayCount;
        food = new ArrayList<>();
        activity = new ArrayList<>();
    }

    //EFFECTS: Asks the user for the food consumed as a String input and stores it
    public void foodEvent(Scanner reader)
    {
        System.out.println("Please type the food you ate.");
        String input = reader.nextLine();
        addFood(input);
        /*
        Food justAte = new Food(input);
        food.add(justAte);*/
    }

    //MODIFIES: this
    //EFFECTS: Adds one food item to the daily count
    public void addFood(String ate)
    {
        Food justAte = new Food(ate);
        food.add(justAte);
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
        /*
        PhysicalActivity justDid = new PhysicalActivity(input1, input2);
        activity.add(justDid);*/
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

        for(Food cur : food)
            total += cur.getCalorie();

        for(PhysicalActivity cur : activity)
            total -= cur.getCalorie();

        return total;
    }

    //EFFECTS: Prints out all the food and activity for the day
    public String toString()
    {
        String foodList = "";
        /*
        for(int i = 0; i < food.size(); i++)
            foodList += food.get(i).toString();
        */
        for(Food cur : food)
            foodList += cur.toString();

        String activityList = "";
        /*
        for(int i = 0; i < activity.size(); i++)
            activityList += activity.get(i).toString();
        */
        for(PhysicalActivity cur : activity)
            activityList += cur.toString();

        return (foodList + activityList);
    }

    //EFFECTS: Calculate and print the BMR based on user input
    public void baseCalorieEvent(Scanner reader)
    {
        double height;
        double weight;
        int age;

        System.out.println("Please input your height in cm.");
        height = reader.nextDouble();
        System.out.println("Please input your weight in kg.");
        weight = reader.nextDouble();
        System.out.println("Please input your age in years.");
        age = reader.nextInt();

        System.out.println("Your base metabolic rate is " + calculateBMR(height, weight, age) + " calories.");
    }

    //REQUIRES: double height in cm, double weight in kg, int age in years
    //EFFECTS: Returns the BMR as a double
    public static double calculateBMR(double height, double weight, int age)
    {
        return Math.round(66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * (double)age));
    }
}
