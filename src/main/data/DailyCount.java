package data;
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

    //REQUIRES: Scanner reader
    //MODIFIES: this
    //EFFECTS: Asks the user for the food consumed as a String input and stores it
    public void foodEvent(Scanner reader)
    {
        System.out.println("Please type the food you ate.");
        String input = reader.nextLine();
        Food justAte = new Food(input);
        food.add(justAte);
    }

    //REQUIRES: Scanner reader
    //MODIFIES: this
    //EFFECTS: Asks the user for the activity as a String input and stores it
    public void workoutEvent(Scanner reader)
    {
        System.out.println("Please type the activity you did.");
        String input1 = reader.next();
        System.out.println("Please type the duration of the activity in hours.");
        int input2 = reader.nextInt();
        PhysicalActivity justDid = new PhysicalActivity(input1, input2);
        activity.add(justDid);
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

        return (foodList + " " + activityList);
    }
}
