package model;

import java.io.*;
import java.util.ArrayList;

import events.InputEvent;
import exceptions.NotValidInputException;
import interfaces.Loadable;
import interfaces.Saveable;

import java.util.Scanner;

public class Person implements Loadable, Saveable{
    private ArrayList<DailyCount> dayCount;
    private String name;
    private int age;
    private double height;
    private double weight;
    private boolean gender;
    private double BMR;

    //Default constructor
    public Person()
    {
        dayCount = new ArrayList<>();
    }

    //REQUIRE: age must be greater than 0, height in cm, weight in kg, false is male and true is female
    //MODIFIES: this
    //EFFECT: Construct a person object
    public Person(String name, int age, double height, double weight, boolean gender, double BMR) throws NotValidInputException
    {
        if(name.equals("") || height <= 0 || weight <= 0 || age <= 0)
            throw new NotValidInputException();

        dayCount = new ArrayList<>();
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.BMR = BMR;
    }

    public void addDayCount(DailyCount day)
    {
        dayCount.add(day);
    }

    public double dailyCalorieDifference(DailyCount day)
    {
        return day.countCalorie() - BMR;
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
        this.BMR = InputEvent.calculateBMR(age, height, weight, gender);
    }

}
