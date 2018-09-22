package tests;

import model.DailyCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMethods
{
    private DailyCount day;

    @BeforeEach
    public void runBefore() { day = new DailyCount(); }

    // Test constructor, getFoodCount and getActivityCount
    @Test
    public void testConstructorAndGetter()
    {
        assertEquals(0, day.getFoodCount());
        assertEquals(0, day.getActivityCount());
    }

    //Test addFood
    @Test
    public void testAddFood()
    {
        day.addFood("burger");
        assertEquals(1, day.getFoodCount());
    }

    //Test addActivity
    @Test
    public void testAddActivity()
    {
        day.addActivity("swimming", 3);
        assertEquals(1, day.getActivityCount());
    }

    //Test countCalorie for 0 calorie
    @Test
    public void testCountCalorieZero()
    {
        assertEquals(0, day.countCalorie());
    }

    //Test countCalorie for positive calories
    @Test
    public void testCountCaloriePositive()
    {
        day.addFood("burger");
        day.addFood("ramen");
        day.addActivity("running", 1);
        assertEquals(300, day.countCalorie());
    }

    //Test countCalorie for negative calories
    @Test
    public void testCountCalorieNegative()
    {
        day.addFood("burger");
        day.addFood("ramen");
        day.addActivity("running", 1);
        day.addActivity("swimming", 2);
        assertEquals(-1300, day.countCalorie());
    }

    //Test toString
    @Test
    public void TestToString()
    {
        day.addFood("banana");
        day.addActivity("swimming", 1);
        day.addFood("fried chicken");
        assertEquals("banana fried chicken swimming for 1.0 hours. ", day.toString());
    }
}
