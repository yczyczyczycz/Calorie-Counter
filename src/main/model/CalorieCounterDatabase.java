package model;

import java.util.HashMap;
import java.util.Map;

public class CalorieCounterDatabase
{
    private Map<String, Double> data;

    public CalorieCounterDatabase()
    {
        data = new HashMap<>();
    }

    public void databaseSetup()
    {
        this.setupFood();
        this.setupDrink();
        this.setupActivity();
    }

    private void setupFood()
    {
        data.put("burger", new Double(500));
        data.put("ramen", new Double(400));
        data.put("sandwich", new Double(450));
        data.put("fried chicken", new Double(800));
        data.put("banana", new Double(100));
    }

    private void setupDrink()
    {
        data.put("cola", new Double(0.38));
        data.put("milk", new Double(0.42));
        data.put("beer", new Double(0.43));
        data.put("orange juice", new Double(0.45));
        data.put("diet coke", new Double(0));
    }

    private void setupActivity()
    {
        data.put("running" ,new Double(600));
        data.put("walking", new Double(300));
        data.put("swimming", new Double(800));
        data.put("biking", new Double(400));
        data.put("basketball", new Double(700));
    }

    public double setupCalorie(String str)
    {
        if(data.containsKey(str))
            return data.get(str);

        return 0;
    }

}
