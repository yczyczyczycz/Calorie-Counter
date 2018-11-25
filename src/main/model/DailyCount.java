package model;
import observer.UserObserver;

import java.util.ArrayList;
import java.util.Objects;

/**
 **
 */
public class DailyCount implements UserObserver
{
    private static int dayNumber = 1;
    private int uniqueNum;
    private ArrayList<CalorieIn> food;
    private ArrayList<CalorieOut> activity;
    private CalorieCounterDatabase ccd;
    private double userBMR;

    //MODIFIES: this
    //EFFECTS: Constructs a DailyCount object that keep tracks of calories in and out
    public DailyCount()
    {
        uniqueNum = dayNumber;
        food = new ArrayList<>();
        activity = new ArrayList<>();
        userBMR = 0;
        dayNumber++;
    }

    //MODIFIES: this
    //EFFECTS: Adds one food item to the daily count
    public void addFood(String ate)
    {
        Food justAte = new Food(ate, ccd);
        food.add(justAte);
    }

    //MODIFIES: this
    //EFFECTS: Adds one drink item to the daily count
    public void addDrink(String ate, double amount)
    {
        Drink justDrank = new Drink(ate, amount, ccd);
        food.add(justDrank);
    }

    //EFFECTS: Returns the number of food items.
    public int getFoodCount()
    {
        return food.size();
    }

    //REQUIRES: double duration, duration cannot be negative
    //MODIFIES: this
    //EFFECTS: Adds one activity item to the daily count
    public void addActivity(String name, double duration)
    {
        PhysicalActivity justDid = new PhysicalActivity(name, duration, ccd);
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

    public void setupDatabase(CalorieCounterDatabase ccd)
    {
        this.ccd = ccd;
    }

    public int getDayNum()
    {
        return uniqueNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyCount that = (DailyCount) o;
        return uniqueNum == that.uniqueNum;
    }

    @Override
    public int hashCode() {

        return Objects.hash(uniqueNum);
    }

    public void setUserBMR(double bmr)
    {
        this.userBMR = bmr;
    }

    public double dailyCalorieDifference()
    {
        return countCalorie() - userBMR;
    }

    @Override
    public void update(double bmr)
    {
        userBMR = bmr;
    }

    public CalorieCounterDatabase getCCD()
    {
        return this.ccd;
    }
}
