package ui;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int userInput = getInput();
        eatFood(userInput);
    }

    public static int getInput()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please choose 1 for Ramen and 2 for Burger.");
        int n = reader.nextInt();
        reader.close();
        return n;
    }

    public static void eatFood(int choice)
    {
        if(choice == 1)
            System.out.println("I just ate Ramen.");
        if(choice == 2)
            System.out.println("I just ate Burger.");
    }
}
