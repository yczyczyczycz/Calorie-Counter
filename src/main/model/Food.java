package model;

/**
 **
 */
public class Food
{
    private String foodName;
    private double calorie;

    /**
     **
     */
    public Food(){}

    //REQUIRES: String name
    //MODIFIES: this
    //EFFECTS: Constructs a Food object with the given name
    public Food(String name)
    {
        foodName = name;
        calorie = getFoodCalorie(name);
    }

    //REQUIRES: String food
    //EFFECTS: Returns the calorie of the food inputted
    private static double getFoodCalorie(String food)
    {
        double calorie = 0;
        /*
        if(food.equals("burger"))
            calorie = 500;
        else if(food.equals("ramen"))
            calorie = 400;*/
        switch (food)
        {
            case "burger":
                calorie = 500;
                break;
            case "ramen":
                calorie = 400;
                break;
            case "sandwich":
                calorie = 450;
                break;
            case "fried chicken":
                calorie = 800;
                break;
            case "banana":
                calorie = 100;
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
        return calorie;
    }

    //EFFECTS: Prints out the name of the Food object
    public String toString()
    {
        return (foodName + " ");
    }
}
