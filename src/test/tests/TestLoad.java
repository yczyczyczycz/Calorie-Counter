package tests;

import model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLoad {
    public static void main(String[] args) {
        Person test = new Person();
        test.load("TestSave.txt");
        System.out.println(test.toString());
    }
}
