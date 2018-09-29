package model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import interfaces.Loadable;
import interfaces.Saveable;
import java.io.PrintWriter;
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
    public Person(){}

    //REQUIRE: age must be greater than 0, height in cm, weight in kg, false is male and true is female
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

    @Override
    public void save(String name) throws FileNotFoundException, UnsupportedEncodingException
    {
        PrintWriter writer = new PrintWriter(name, "UTF-8");
    }

    public void load(String name, Scanner reader)
    {

    }
}
