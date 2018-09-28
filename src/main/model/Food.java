package model;

import interfaces.Edible;

/**
 **
 */
public class Food implements Edible
{
    private String foodName;
    private double calorie;

    /**
     **
     */
    public Food(){}

    //MODIFIES: this
    //EFFECTS: Constructs a Food object with the given name
    public Food(String name)
    {
        foodName = name;
        calorie = getFoodCalorie(name);
    }

    //EFFECTS: Returns the calorie of the food inputted
    private static double getFoodCalorie(String food)
    {
        double calorie = 0;

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

    @Override
    //EFFECTS: Returns the calorie of the object
    public double getCalorie()
    {
        return calorie;
    }

    @Override
    //EFFECTS: Returns the food's name.
    public String getName()
    {
        return foodName;
    }

    //EFFECTS: Prints out the name of the Food object
    public String toString()
    {
        return (foodName + " ");
    }
}
