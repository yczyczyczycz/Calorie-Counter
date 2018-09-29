package model;

import java.io.*;
import java.util.ArrayList;
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
    public Person(String name, int age, double height, double weight, boolean gender, double BMR)
    {
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

        }
        catch(IOException ex){}
    }

    @Override
    public void load(String name)
    {
        try(Scanner reader = new Scanner(new FileReader(name)))
        {
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
        catch(FileNotFoundException ex){}
    }
}
