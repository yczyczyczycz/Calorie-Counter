package model;

import interfaces.Loadable;
import interfaces.Saveable;
import observer.Subject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Person extends Subject implements Loadable, Saveable{
    private ArrayList<DailyCount> dayCount;
    private String name;
    private int age;
    private double height;
    private double weight;
    private boolean gender;
    private double BMR;
    private CalorieCounterDatabase ccd;


    //Default constructor
    public Person()
    {
        dayCount = new ArrayList<>();
        ccd = new CalorieCounterDatabase();
        ccd.databaseSetup();
    }

    //REQUIRE: age must be greater than 0, height in cm, weight in kg, false is male and true is female
    //MODIFIES: this
    //EFFECT: Construct a person object

    public Person(String name, int age, double height, double weight, boolean gender)
    {
        dayCount = new ArrayList<>();
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        setBMR(age, height, weight, false);

        ccd = new CalorieCounterDatabase();
        ccd.databaseSetup();
    }


    public void addDayCount(DailyCount day)
    {
        if(!dayCount.contains(day))
        {
            dayCount.add(day);
            day.setupDatabase(ccd);
            addObserver(day);
            day.setUserBMR(BMR);
        }
    }

    public void removeDayCount(DailyCount day)
    {
        if(dayCount.contains(day))
        {
            dayCount.remove(day);
        }
    }

    public DailyCount retrieveDay(int num)
    {
        for(int i = 0; i < dayCount.size(); i++)
        {
            if(num == dayCount.get(i).getDayNum())
                return dayCount.get(i);
        }

        return null;
    }

    /*
    public double dailyCalorieDifference(DailyCount day)
    {
        return day.countCalorie() - BMR;
    }
    */

    public void printAllDay()
    {
        for(int i = 0; i < dayCount.size(); i++)
            System.out.println(dayCount.get(i).toString());
    }

    public String printAllDayString()
    {
        String output = "";
        for(int i = 0; i < dayCount.size(); i++) {
            output += "Day " + dayCount.get(i).getDayNum() + ": " + dayCount.get(i).dailyCalorieDifference() + " ";
        }
        return output;
    }

    public String toString()
    {
        String info;
        String sex;
        if(gender)
            sex = "female";
        else
            sex = "male";

        info = "name: " + name + " age: " + age + " height: " + height
                + " weight: " + weight + " gender: " + sex + " BMR: " + BMR;

        return info;
    }

    @Override
    //REQUIRE:: a scanner and a String that is the name of a txt file
    public void save(String name)
    {
        try(PrintWriter writer = new PrintWriter(name, "UTF-8"))
        {
            writer.println(this.name);
            writer.println(age);
            writer.println(height);
            writer.println(weight);
            if(gender)
                writer.println("female");
            else
                writer.println("male");
            writer.println(BMR);

            //Now saves each day
            for(int i = 0; i < dayCount.size(); i++)
            {
                writer.println(dayCount.get(i).toString());
            }
        }
        catch(IOException ex){}
    }

    //MODIFIES: this
    //EFFECTS: Load the attributes from a text file and store it into this object
    @Override
    public void load(String name) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(name));
        this.name = reader.next();
        reader.nextLine();
        age = reader.nextInt();
        reader.nextLine();
        height = reader.nextDouble();
        reader.nextLine();
        weight = reader.nextDouble();
        reader.nextLine();
        String sex;
        if(reader.next().equals("female"))
            gender = true;
        else
            gender = false;
        reader.nextLine();
        BMR = reader.nextDouble();
    }

    //MODIFIES: THIS
    //EFFECTS: Mutator for all the fields
    public void changeUserInfo(String name, int age, double height, double weight, boolean gender)
    {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        setBMR(age, height, weight, gender);
        notifyObservers(BMR);
    }

    //REQUIRES: double height in cm, double weight in kg, int age is greater than 0, false is male and true is female
    //EFFECTS: Returns the BMR as a double
    public void setBMR(int age, double height, double weight, boolean gender)
    {
        double rate;

        //female
        if(gender)
            rate = Math.round(655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age));
        //male
        else
            rate = Math.round(66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age));

        this.BMR = rate;
    }
}
