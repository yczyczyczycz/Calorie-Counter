package model;
import java.util.ArrayList;
import java.util.Scanner;

/**
 **
 */
public class DailyCount
{
    private ArrayList<Food> food;
    private ArrayList<PhysicalActivity> activity;

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
        System.out.println("Please type the food you ate.");
        String input = reader.nextLine();
        addFood(input);
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
}
