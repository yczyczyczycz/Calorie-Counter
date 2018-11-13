package ui;

import model.DailyCount;
import model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
/** The Main class contains the main method that will run the program.
 **
 */
public class Main
{
    //Main that runs the program
    public static void main(String[] args)
    {
        try{
            read();
        } catch(IOException e){}

        runCalorieCounter();
    }

    /** Creates a DailyCount object that will track a user's caloric activities.
     ** It will asks the user for input until the user exits the program.
     ** For now there is an option to print out what the user inputted.
     */
    public static void runCalorieCounter()
    {
        int userInput;
        Scanner reader = new Scanner(System.in);
        DailyCount day = new DailyCount();
        Person user = new Person();

        System.out.println("1 to create a new user. 2 to load user from a text file.");
        userInput = reader.nextInt();
        if(userInput == 1)
        {
           InputHelper.setUpCorrectUser(user, reader);
           System.out.println(user.toString());
        }
        else
        {
            user = new Person();
            InputHelper.loadCorrectFile(reader, user);

            System.out.println("You loaded user info:");
            System.out.println(user.toString());
        }
        user.addDayCount(day);
        InputHelper.exeCommands(user, day, reader);
        reader.close();
    }

    public static void read() throws MalformedURLException, IOException {

        BufferedReader br = null;

        try {
            String theURL = "https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
}
