package model;

/**
 **
 */
public class Food extends CalorieIn
{
    //MODIFIES: this
    //EFFECTS: Constructs a Food object with the given name
    public Food(String name)
    {
        super(name);
    }

    //MODIFIES: this
    //EFFECTS: Set the calorie of the object
    @Override
    public void setFoodCalorie(String food)
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
        this.calorie = calorie;
    }
}
