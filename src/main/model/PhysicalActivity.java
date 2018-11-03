package model;

import interfaces.CalorieCountable;

/**
 **
 */
public class PhysicalActivity extends CalorieOut
{
    //REQUIRES: double duration, duration cannot be negative
    //MODIFIES: this
    //EFFECTS: Constructs a PhysicalActivity object with the given name and duration
    public PhysicalActivity(String name, double duration, CalorieCounterDatabase ccd)
    {
        super(name, duration,ccd);
    }

    @Override
    public void setActivityCalorie(String activity, CalorieCounterDatabase ccd)
    {
        this.caloriePerHour = ccd.setupCalorie(activity);
    }
}
