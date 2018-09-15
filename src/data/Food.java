package data;

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

    /**
     **
     */
    public Food(String name)
    {
        foodName = name;
        calorie = getFoodCalorie(name);
    }

    private static double getFoodCalorie(String food)
    {
        double calorie = 0;
        if(food.equals("burger"))
            calorie = 500;
        else if(food.equals("ramen"))
            calorie = 400;

        return calorie;
    }

    public String toString()
    {
        return (foodName + " ");
    }
}
