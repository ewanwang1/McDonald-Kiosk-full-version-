package ui;

import main.menu.Food;
import main.menu.Order;
import ui.panels.MainMenu;
import ui.panels.OrderType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame  {
    private JLabel label;
    private JTextField field;
    private MainMenu mainMenu;
    public Order currentOrder;

    public Gui() {
        //Setup
        super("McDonald Kiosk");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());

        //Add Swing Components
        currentOrder = new Order();
        label = new JLabel("flag");
        field = new JTextField(5);
        mainMenu = new MainMenu(this, currentOrder);

        add(mainMenu);

        //Opening the Jframe
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }


}
