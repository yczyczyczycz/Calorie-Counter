package tests;

import model.DailyCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInheritance {
    private DailyCount day;

    @BeforeEach
    public void runBefore() { day = new DailyCount(); }

    //Test addFood
    @Test
    public void testAddFood()
    {
        day.addFood("burger");
        assertEquals(1, day.getFoodCount());
    }

    //Test addDrink
    @Test
    public void testAddDrink()
    {
        day.addDrink("milk", 200);
        assertEquals(1, day.getFoodCount());
    }

    //Test countCalorie for positive calories
    @Test
    public void testCountCaloriePositive()
    {
        day.addFood("burger");
        day.addDrink("milk", 200);
        day.addActivity("running", 0.5);
        assertEquals(284, day.countCalorie());
    }

    //Test toString
    @Test
    public void TestToString()
    {
        day.addFood("banana");
        day.addActivity("swimming", 1);
        day.addDrink("orange juice", 200);
        assertEquals("In: banana 200.0 ml of orange juice Out: swimming for 1.0 hours. ", day.toString());
    }
}
