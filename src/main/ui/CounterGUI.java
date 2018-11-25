package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CounterGUI extends JFrame{

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
        buttonPanel.setLayout(new GridLayout(3,2));
        panel.add(buttonPanel, BorderLayout.CENTER);

        //JLabel
        display = new JLabel("Calorie counter, please make your selection.");
        display.setPreferredSize(new Dimension(FRAME_WIDTH, 50));
        panel.add(display, BorderLayout.NORTH);

        //text
        text = new JTextField(20);
        panel.add(text, BorderLayout.SOUTH);
        button6 = new JButton("enter");
        button6.registerKeyboardAction(button6.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                JComponent.WHEN_FOCUSED);
        button6.registerKeyboardAction(button6.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                JComponent.WHEN_FOCUSED);
        //buttons
        button1 = new JButton("input meal");
        button2 = new JButton("input workout");
        button3 = new JButton("day calorie");
        button4 = new JButton("activity list");
        button5 = new JButton("daily calorie difference");

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);

        add(panel);
    }


}
