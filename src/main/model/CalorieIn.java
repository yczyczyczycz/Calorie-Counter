package model;

import interfaces.CalorieCountable;


public abstract class CalorieIn implements CalorieCountable {
    protected String foodName;
    protected double calorie;

    //MODIFIES: this
    //EFFECTS: Constructs a Food object with the given name
    public CalorieIn(String name, CalorieCounterDatabase ccd)
    {
        foodName = name;
        this.setFoodCalorie(name, ccd);

    }

    public abstract void setFoodCalorie(String food, CalorieCounterDatabase ccd);


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

    @Override
    //EFFECTS: Prints out the name of the Food object
    public String toString()
    {
        return (foodName + " ");
    }
}
