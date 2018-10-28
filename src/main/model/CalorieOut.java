package model;

import interfaces.CalorieCountable;

public abstract class CalorieOut implements CalorieCountable {
    protected String activityName;
    protected double durationInHour;
    protected double caloriePerHour;

    //MODIFIES: this
    //EFFECTS: Constructs a Food object with the given name
    public CalorieOut(String name, double duration, CalorieCounterDatabase ccd)
    {
        activityName = name;
        durationInHour = duration;
        this.setActivityCalorie(name, ccd);
    }

    @Override
    //EFFECTS: Returns the calorie of the object
    public double getCalorie()
    {
        return caloriePerHour * durationInHour;
    }

    @Override
    //EFFECTS: Returns the name of the exercise
    public String getName()
    {
        return activityName;
    }

    @Override
    //EFFECTS: Prints the activity's name and duration
    public String toString()
    {
        return (activityName + " for " + durationInHour + " hours. ");
    }

    public abstract void setActivityCalorie(String activity, CalorieCounterDatabase ccd);
}
