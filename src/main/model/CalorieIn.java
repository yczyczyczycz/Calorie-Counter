package model;

import interfaces.CalorieCountable;


public abstract class CalorieIn implements CalorieCountable {
    protected String foodName;
    protected double calorie;

    //MODIFIES: this
    //EFFECTS: Constructs a Food object with the given name
    public CalorieIn(String name)
    {
        foodName = name;
        this.setFoodCalorie(name);
    }

    //EFFECTS: Returns the calorie of the food inputted
    public abstract void setFoodCalorie(String food);


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
