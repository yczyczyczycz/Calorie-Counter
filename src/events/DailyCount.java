package events;
import java.util.ArrayList;
import java.util.Scanner;

import data.Food;
import data.PhysicalActivity;

/**
 **
 */
public class DailyCount
{
    private static int dayCount = 0;
    private ArrayList<Food> food;
    private ArrayList<PhysicalActivity> activity;

    public DailyCount()
    {
        dayCount = ++dayCount;
        food = new ArrayList<>();
        activity = new ArrayList<>();
    }

    public void foodEvent(Scanner reader)
    {
        System.out.println("Please type the food you ate. (burger or ramen)");
        String input = reader.nextLine();
        Food justAte = new Food(input);
        food.add(justAte);
    }

    public void workoutEvent(Scanner reader)
    {
        System.out.println("Please type the activity you did. (runnning or walking)");
        String input1 = reader.next();
        System.out.println("Please type the duration of the actibity in hours.");
        int input2 = reader.nextInt();
        PhysicalActivity justDid = new PhysicalActivity(input1, input2);
        activity.add(justDid);
    }

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
