package ui.panels;

import main.menu.Food;
import main.menu.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ViewOrder extends Panels implements ActionListener {
    public ViewOrder(JFrame javaFrame, Order currentOrder) {
        super(javaFrame, currentOrder);
        label = new JLabel("You have currently ordered: ");
        JButton goBack = new JButton("Go back");
        goBack.addActionListener(this);
        add(label);
        add(bigBlankSpace);

        for (Food food : currentOrder.getCurrentFoodOrdered().keySet()) {
            add(blankSpace);
            add(new JLabel("You have ordered " + food.getAmountOrdered() + " " + food.getName()));
            add(blankSpace);
        }

        add(blankSpace);
        add(goBack);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        javaFrame.add(new MainMenu(javaFrame, currentOrder));
    }
}
