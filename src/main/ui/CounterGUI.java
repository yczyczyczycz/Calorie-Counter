package ui;

import model.DailyCount;
import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterGUI extends JFrame{

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JLabel display;
    private JTextField text;

    private Person user;
    private DailyCount day;

    public CounterGUI()
    {
        super("Calorie Counter");
        user = new Person("Bruce", 29, 173, 64, false);
        day = new DailyCount();
        user.addDayCount(day);
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createComponents()
    {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,3));
        panel.add(buttonPanel, BorderLayout.CENTER);

        //JLabel
        display = new JLabel("Calorie counter, please make your selection.");
        display.setPreferredSize(new Dimension(FRAME_WIDTH, 50));
        panel.add(display, BorderLayout.NORTH);

        //text
        text = new JTextField(20);
        panel.add(text, BorderLayout.SOUTH);

        //buttons
        button1 = new JButton("add meal");
        button1.setBackground(new Color(255,182,193));
        button1.setForeground(Color.BLACK);
        //button1.setFont(new Font("Arial", Font.PLAIN, 20));
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String textVal = text.getText();
                day.addFood(textVal);
                double amount = day.getCCD().setupCalorie(textVal);
                display.setText(textVal + " inputted, calorie count: " + amount);
            }
        });

        button2 = new JButton("add drink (100ml)");
        button2.setBackground(new Color(255,182,193));
        button2.setForeground(Color.BLACK);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String textVal = text.getText();
                day.addDrink(textVal, 100);
                double amount = day.getCCD().setupCalorie(textVal) * 100;
                display.setText(textVal + " inputted, calorie count: " + amount);
            }
        });

        button3 = new JButton("add workout (30 mins)");
        button3.setBackground(new Color(50,205,50));
        button3.setForeground(Color.BLACK);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String textVal = text.getText();
                day.addActivity(textVal, 0.5);
                double amount = day.getCCD().setupCalorie(textVal) * 0.5;
                display.setText(textVal + " inputted, calorie count: " + amount);
            }
        });

        button4 = new JButton("daily calorie count");
        button4.setBackground(new Color(135,206,250));
        button4.setForeground(Color.BLACK);
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                display.setText("Total calorie standing is " + day.countCalorie() + " calories.");
            }
        });

        button5 = new JButton("food and activity list");
        button5.setBackground(new Color(135,206,250));
        button5.setForeground(Color.BLACK);
        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                display.setText(day.toString());
            }
        });

        button6 = new JButton("daily calorie");
        button6.setBackground(new Color(135,206,250));
        button6.setForeground(Color.BLACK);
        button6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                display.setText("Your daily calorie difference is " + day.dailyCalorieDifference());
            }
        });

        button7 = new JButton("Start a new day");
        button7.setBackground(new Color(255,255,51));
        button7.setForeground(Color.BLACK);
        button7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                display.setText("Welcome to a new day!");
                day = new DailyCount();
                user.addDayCount(day);
            }
        });

        button8 = new JButton("show progress");
        button8.setBackground(new Color(255,255,51));
        button8.setForeground(Color.BLACK);
        button8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                display.setText(user.printAllDayString());
            }
        });

        button9 = new JButton("exit");
        button9.setBackground(new Color(240,128,128));
        button9.setForeground(Color.BLACK);
        button9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                dispose();
            }
        });

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);

        add(panel);
    }


}
