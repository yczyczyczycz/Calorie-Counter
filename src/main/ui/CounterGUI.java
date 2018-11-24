package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterGUI extends JFrame implements ActionListener{

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel display;
    private JTextField text;

    public CounterGUI()
    {
        super("Calorie Counter");
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createComponents()
    {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,3));
        panel.add(buttonPanel, BorderLayout.CENTER);

        //JLabel
        display = new JLabel("Calorie counter, please make your selection.");
        display.setPreferredSize(new Dimension(FRAME_WIDTH, 50));
        panel.add(display, BorderLayout.NORTH);

        //text
        text = new JTextField(20);
        panel.add(text, BorderLayout.SOUTH);

        //buttons
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);

        add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
