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
    public PhysicalActivity(String name, double duration)
    {
        super(name, duration);
    }

    //MODIFIES: this
    //EFFECTS: Sets the caloriePerHour for the object
    public void setActivityCalorie(String activity)
    {
        double calorie = 0;

        switch (activity)
        {
            case "running":
                calorie = 600;
                break;
            case "walking":
                calorie = 300;
                break;
            case "swimming":
                calorie = 800;
                break;
            case "biking":
                calorie = 400;
                break;
            case "basketball":
                calorie = 700;
                break;
            default:
                calorie = 0;
                break;
        }

        this.caloriePerHour = calorie;
    }
}
