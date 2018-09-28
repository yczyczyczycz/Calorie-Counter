package model;

import interfaces.Edible;

public class Drink implements Edible {

    private String drinkName;
    private double volume;
    private double caloriePerML;

    //Default constructor
    public Drink() {
    }

    ;
    //Constructor
    public Drink(String name, double vol)
    {
        drinkName = name;
        volume = vol;
    }

    @Override
    public double getCalorie()
    {
        return volume * caloriePerML;
    }

    @Override
    public String getName()
    {
        return drinkName;
    }
}
