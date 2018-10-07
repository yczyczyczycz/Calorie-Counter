package model;

public class Drink extends CalorieIn
{
    private double volume;

    //Constructor
    public Drink(String name, double vol)
    {
        super(name);
        volume = vol;
    }

    //MODIFIES: this
    //EFFECTS: Set the calorie of the object
    @Override
    public void setFoodCalorie(String food)
    {
        double calorie = 0;

        switch (food)
        {
            case "cola":
                calorie = 0.38;
                break;
            case "milk":
                calorie = 0.42;
                break;
            case "beer":
                calorie = 0.43;
                break;
            case "orange juice":
                calorie = 0.45;
                break;
            case "diet coke":
                calorie = 0;
                break;
            default:
                calorie = 0;
                break;
        }
        this.calorie = calorie;
    }


    public double getCalorie()
    {
        return volume * this.calorie;
    }

    public String toString()
    {
        return (volume + " ml of " + foodName + " ");
    }

}
