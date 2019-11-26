package ui.panels;

import main.menu.Order;
import main.menudisplayed.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class OrderFood extends Panels {
    String buttonName;
    OrderAmount orderAmount;
    JButton btn;

    public OrderFood(JFrame javaFrame, Order order) {
        super(javaFrame, order);
        label = new JLabel("What would you like to order?");
        add(label);

        for (int i = 1; i < getMenu().getSize(); i++) {
            buttonName = "order " + getMenu().getFood(i).getName();
            btn = new JButton(buttonName);
            add(Box.createRigidArea(new Dimension(5, 10)));
            add(btn);
            btn.addActionListener((ActionListener) getFoodOrder());
            btn.setActionCommand(Integer.toString(i));
            add(Box.createRigidArea(new Dimension(5, 10)));
        }
    }


    //return the right menu for user to order from
    public abstract Menu getMenu();


    //Return the panel that the user is using to order a specific food type from
    public abstract OrderFood getFoodOrder();
}
