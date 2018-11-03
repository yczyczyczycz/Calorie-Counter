package model;

public class Food extends CalorieIn
{
    //MODIFIES: this
    //EFFECTS: Constructs a Food object with the given name
    public Food(String name, CalorieCounterDatabase ccd)
    {
        super(name, ccd);
    }

    @Override
    public void setFoodCalorie(String food, CalorieCounterDatabase ccd)
    {
        this.calorie = ccd.setupCalorie(food);
    }

}
