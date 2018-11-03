package model;

public class Drink extends CalorieIn
{
    private double volume;

    //Constructor
    public Drink(String name, double vol, CalorieCounterDatabase ccd)
    {
        super(name, ccd);
        volume = vol;
    }

    @Override
    public void setFoodCalorie(String food, CalorieCounterDatabase ccd)
    {
        this.calorie = ccd.setupCalorie(food);
    }

    @Override
    public double getCalorie()
    {
        return volume * this.calorie;
    }

    @Override
    public String toString()
    {
        return (volume + " ml of " + foodName + " ");
    }

}
