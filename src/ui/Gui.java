package ui;

import ui.panels.MainMenu;
import ui.panels.OrderType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField field;
    private JPanel jpanel1;
    private MainMenu mainMenu;
    private OrderType orderType;

    public Gui() {
        //Setup
        super("McDonald Kiosk");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());

        //Add Swing Components
        JButton btn = new JButton("Change");
        btn.setActionCommand("myButton");
        btn.addActionListener(this); //sets "this" class as an action listener for btn.
        //that means that when the btn is clicked,
        //this.actionPerformed(ActionEvent e) will be called.
        //You could also set a different class, if you wanted
        //to capture the response behaviour elsewhere

        jpanel1 = new JPanel();
        label = new JLabel("flag");
        field = new JTextField(5);
        mainMenu = new MainMenu(this);

        //Adding it components onto Swing
        jpanel1.add(field);
        jpanel1.add(btn);
        jpanel1.add(label);

        add(mainMenu);

        //Opening the Jframe
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //this is the method that runs when Swing registers an action on an element
    //for which this class is an ActionListener
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            label.setText(field.getText());
        }
    }

    public void makeVisible() {
        jpanel1.setVisible(true);
    }

    public void makeInVisible() {
        jpanel1.setVisible(false);
    }
}
