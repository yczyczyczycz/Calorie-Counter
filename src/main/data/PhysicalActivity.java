package data;

/**
 **
 */
public class PhysicalActivity
{
    private String activityName;
    private double durationInHour;
    private double caloriePerHour;

    /** Empty default constructor.
     **
     */
    public PhysicalActivity() {}

    //REQUIRES: String name, double duration, duration cannot be negative
    //MODIFIES: this
    //EFFECTS: Constructs a PhysicalActivity object with the given name and duration
    public PhysicalActivity(String name, double duration)
    {
        activityName = name;
        durationInHour = duration;
        caloriePerHour = getActivityCalorie(name);
    }

    //REQUIRES: String activity
    //EFFECTS: Returns the activity's calorie consumption per hour
    private static double getActivityCalorie(String activity)
    {
        double calorie = 0;
        /*
        if(activity.equals("running"))
            calorie = 600;
        else if(activity.equals("walking"))
            calorie = 300;*/

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

        return calorie;
    }

    //EFFECTS: Returns the calorie of the object
    public double getCalorie()
    {
        return caloriePerHour * durationInHour;
    }

    //EFFECTS: Prints the activity's name and duration
    public String toString()
    {
        return (activityName + " for " + durationInHour + " hours. ");
    }
}
