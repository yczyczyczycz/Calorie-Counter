package tests;

import model.Person;

public class TestSave {

    public static void main(String[] args) {
        Person test = new Person("Tester", 23, 180,64, true, 1200);

        test.save("TestSave.txt");
    }
}
