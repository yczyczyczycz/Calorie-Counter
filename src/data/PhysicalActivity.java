package data;

/**
 **
 */
public class PhysicalActivity
{
    private String activityName;
    private double timeInHour;
    private double caloriePerHour;

    /** Empty default constructor.
     **
     */
    public PhysicalActivity() {}

    /** Constructor
     **
     */
    public PhysicalActivity(String name, double time)
    {
        activityName = name;
        timeInHour = time;
        caloriePerHour = getActivityCalorie(name);
    }

    private static double getActivityCalorie(String activity)
    {
        double calorie = 0;

        if(activity.equals("running"))
            calorie = 600;
        else if(activity.equals("walking"))
            calorie = 300;

        return calorie;
    }

    public String toString()
    {
        return (activityName + " for " + timeInHour + " hours. ");
    }
}
